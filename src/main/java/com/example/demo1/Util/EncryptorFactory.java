package com.example.demo1.Util;

import com.example.demo1.Util.Encryption.AESEncryptorFactory;
import com.example.demo1.Util.Encryption.DESEncryptorFactory;

import java.security.Key;

public interface EncryptorFactory {
    EncryptorFactory AES = new AESEncryptorFactory();
    EncryptorFactory DES = new DESEncryptorFactory();
	Encryptor messageEncryptor(Key key);
	Encryptor streamEncryptor(Key key);
}
