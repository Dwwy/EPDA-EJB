package com.example.demo1.Util;
import com.example.demo1.Util.Encryption.KeyFactory;

import java.security.GeneralSecurityException;
import java.security.Key;
import java.util.Base64;


public class TextEncryptor {

	private Encryptor encryptor;

	public TextEncryptor() {
		this(KeyFactory.AES.randomKey());
	}

	public TextEncryptor(String password) {
		this(KeyFactory.AES.keyFromPassword(password.toCharArray()));
	}

	public TextEncryptor(Key key) {
		this(EncryptorFactory.AES.messageEncryptor(key));
	}

	public TextEncryptor(Encryptor encryptor) {
		this.encryptor = encryptor;
	}

	public String encrypt(String message) {
		byte[] bytes = new byte[0];
		try {
			bytes = encryptor.encrypt(message.getBytes());
		} catch (GeneralSecurityException e) {
			throw new RuntimeException(e);
		}
		return Base64.getUrlEncoder().encodeToString(bytes);
	}

	public String decrypt(String message)  {
		byte[] bytes = Base64.getUrlDecoder().decode(message);
		try {
			return new String(encryptor.decrypt(bytes));
		} catch (GeneralSecurityException e) {
			throw new RuntimeException(e);
		}
	}

	public Encryptor getEncryptor() {
		return encryptor;
	}


}
