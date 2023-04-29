package com.example.demo1.Util;

import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public class Encryptor {

	private static final String DEFAULT_ALGORITHM = "AES";

    /*
     * Attributes
     */

	private String algorithm;
	private String algorithmProvider;
	private int ivLength;
	private int tLen;
	private Key key;
	private KeySpec keySpec;
	private SecretKeyFactory secretKeyFactory;
	private ThreadLocal<byte[]> ivThreadLocal;
	private ThreadLocal<Cipher> cipherThreadLocal;
	private boolean prependIV;
	private boolean generateIV;

	public Encryptor(Key key) {
		this(key, DEFAULT_ALGORITHM);
	}
	public Encryptor(Key key, String algorithm) {
		this(key, algorithm, 0);
	}
	public Encryptor(Key key, String algorithm, int ivLength) {
		this(key, algorithm, ivLength, 0);
	}
	public Encryptor(Key key, String algorithm, int ivLength, int tLen) {
		this.key = key;
		this.algorithm = algorithm;
		this.ivLength = ivLength;
		this.tLen = tLen;
		this.ivThreadLocal = new ThreadLocal<>();
		this.cipherThreadLocal = new ThreadLocal<>();
		this.prependIV = this.generateIV = true;
	}
	public Encryptor(KeySpec keySpec, SecretKeyFactory secretKeyFactory) {
		this(keySpec, secretKeyFactory, DEFAULT_ALGORITHM, 0);
	}
	public Encryptor(KeySpec keySpec, SecretKeyFactory secretKeyFactory, String algorithm, int ivLength) {
		this(keySpec, secretKeyFactory, DEFAULT_ALGORITHM, ivLength, 0);
	}
	public Encryptor(KeySpec keySpec, SecretKeyFactory secretKeyFactory, String algorithm, int ivLength, int tLen) {
		this.keySpec = keySpec;
		this.secretKeyFactory = secretKeyFactory;
		this.algorithm = algorithm;
		this.ivLength = ivLength;
		this.tLen = tLen;
		this.ivThreadLocal = new ThreadLocal<>();
		this.cipherThreadLocal = new ThreadLocal<>();
		this.prependIV = this.generateIV = true;
	}
	public byte[] encrypt(byte[] message) throws GeneralSecurityException {
		return encrypt(message, null);
	}
	public byte[] encrypt(byte[] message, byte[] aad) throws GeneralSecurityException {
		return encrypt(message, aad, null);
	}
	public byte[] encrypt(byte[] message, byte[] aad, byte[] iv) throws GeneralSecurityException {
		Cipher cipher = getCipher(true);
		if(iv == null && generateIV && ivLength > 0) {
			iv = generateIV();
		}
		if(iv != null) {
			cipher.init(Cipher.ENCRYPT_MODE, getKey(), getAlgorithmParameterSpec(iv));
		} else {
			cipher.init(Cipher.ENCRYPT_MODE, getKey());
			iv = cipher.getIV();
		}
		ivThreadLocal.set(iv);
		if(aad != null) {
			cipher.updateAAD(aad);
		}
		byte[] encrypted;
		if(prependIV && iv != null) {
			int outputSize = cipher.getOutputSize(message.length);
			encrypted = new byte[iv.length + outputSize];
			System.arraycopy(iv, 0, encrypted, 0, iv.length);
			try {
				int nBytes = cipher.doFinal(message, 0, message.length, encrypted, iv.length);
				if(nBytes < outputSize) {
					int excessBytes = outputSize - nBytes;
					byte[] resized = new byte[encrypted.length - excessBytes];
					System.arraycopy(encrypted, 0, resized, 0, resized.length);
					encrypted = resized;
				}
			} catch (ShortBufferException e) {
				throw new RuntimeException(e);
			}
		} else {
			encrypted = cipher.doFinal(message);
		}
		return encrypted;
	}
	public byte[] decrypt(byte[] message) throws GeneralSecurityException {
		return decrypt(message, null);
	}
	public byte[] decrypt(byte[] message, byte[] aad) throws GeneralSecurityException {
		return decrypt(message, aad, null);
	}
	public byte[] decrypt(byte[] message, byte[] aad, byte[] iv) throws GeneralSecurityException {
		Cipher cipher = getCipher(true);
		if(ivLength > 0) {
			if(prependIV) {
				cipher.init(Cipher.DECRYPT_MODE, getKey(), getAlgorithmParameterSpec(message));
				if(aad != null) {
					cipher.updateAAD(aad);
				}
				return cipher.doFinal(message, ivLength, message.length - ivLength);
			} else {
				throw new IllegalStateException("Could not obtain IV");
			}
		} else {
			if(iv != null) {
				cipher.init(Cipher.DECRYPT_MODE, getKey(), getAlgorithmParameterSpec(iv));
			} else {
				cipher.init(Cipher.DECRYPT_MODE, getKey());
			}
			if(aad != null) {
				cipher.updateAAD(aad);
			}
			return cipher.doFinal(message);
		}
	}
	public byte[] getIV() {
		return ivThreadLocal.get();
	}
	public void setPrependIV(boolean prependIV) {
		this.prependIV = prependIV;
	}
	public void setGenerateIV(boolean generateIV) {
		this.generateIV = generateIV;
	}
	public String getAlgorithm() {
		return algorithm;
	}
	public void setAlgorithmProvider(String algorithmProvider) {
		this.algorithmProvider = algorithmProvider;
	}
	public Key getKey() {
		if(key != null) {
			return key;
		} else if(keySpec != null && secretKeyFactory != null) {
			try {
				return key = secretKeyFactory.generateSecret(keySpec);
			} catch (InvalidKeySpecException e) {
				throw new RuntimeException(e);
			}
		}
		throw new IllegalStateException("Cannot produce key");
	}
	public CipherInputStream wrapInputStream(InputStream is) throws GeneralSecurityException, IOException {
		return wrapInputStream(is, null);
	}
	public CipherInputStream wrapInputStream(InputStream is, byte[] iv) throws GeneralSecurityException, IOException {
		Cipher cipher = getCipher(true);
		if(iv == null && ivLength > 0) {
			if(prependIV) {
				iv = new byte[ivLength];
				is.read(iv);
			} else {
				throw new IllegalStateException("Could not obtain IV");
			}
		}
		if(iv != null) {
			cipher.init(Cipher.DECRYPT_MODE, getKey(), getAlgorithmParameterSpec(iv));
		} else {
			cipher.init(Cipher.DECRYPT_MODE, getKey());
		}
		return new CipherInputStream(is, cipher);
	}
	public CipherOutputStream wrapOutputStream(OutputStream os) throws GeneralSecurityException, IOException {
		return wrapOutputStream(os, null);
	}
	public CipherOutputStream wrapOutputStream(OutputStream os, byte[] iv) throws GeneralSecurityException, IOException {
		Cipher cipher = getCipher(true);
		if(iv == null && generateIV && ivLength > 0) {
			iv = generateIV();
		}
		if(iv != null) {
			cipher.init(Cipher.ENCRYPT_MODE, getKey(), getAlgorithmParameterSpec(iv));
		} else {
			cipher.init(Cipher.ENCRYPT_MODE, getKey());
			iv = cipher.getIV();
		}
		ivThreadLocal.set(iv);
		if(prependIV && iv != null) {
			os.write(iv);
		}
		return new CipherOutputStream(os, cipher);
	}
	public Cipher getCipher() throws GeneralSecurityException {
		return getCipher(false);
	}
	private Cipher getCipher(boolean create) throws GeneralSecurityException {
		Cipher cipher = cipherThreadLocal.get();
		if(cipher == null || create) {
			cipher = createCipher();
			cipherThreadLocal.set(cipher);
		}
		return cipher;
	}
	private Cipher createCipher() throws GeneralSecurityException {
		if(algorithmProvider != null) {
			return Cipher.getInstance(algorithm, algorithmProvider);
		} else {
			return Cipher.getInstance(algorithm);
		}
	}
	private AlgorithmParameterSpec getAlgorithmParameterSpec(byte[] ivBuffer) {
		int length = ivLength == 0  && ivBuffer != null ? ivBuffer.length : ivLength;
		String[] parts = algorithm.split("/");
		if(parts.length > 1 && parts[1].equalsIgnoreCase("GCM")) {
			return new GCMParameterSpec(tLen > 0 ? tLen: 128, ivBuffer, 0, length);
		}
		return new IvParameterSpec(ivBuffer, 0, length);
	}
	private byte[] generateIV() {
		byte[] iv = new byte[ivLength];
		SecureRandom random = new SecureRandom();
		random.nextBytes(iv);
		return iv;
	}
}