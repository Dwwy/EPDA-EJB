package com.example.demo1.Util.Encryption;

import com.example.demo1.Util.Encryptor;
import com.example.demo1.Util.EncryptorFactory;

import java.security.Key;


/**
 * <p>Factory class for constructing AES <code>Encryptor</code> instances.</p>
 * @author Martin
 *
 */
public class AESEncryptorFactory implements EncryptorFactory {

	@Override
	public final Encryptor messageEncryptor(Key key) {
		return new Encryptor(key, "AES/CBC/PKCS5Padding", 16);
	}

	@Override
	public final Encryptor streamEncryptor(Key key) {
		return new Encryptor(key, "AES/CTR/NoPadding", 16);
	}
}
