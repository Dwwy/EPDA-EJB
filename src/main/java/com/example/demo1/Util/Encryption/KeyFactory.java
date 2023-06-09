package com.example.demo1.Util.Encryption;


import java.security.Key;

/**
 * <p>Factory interface for generating keys.</p>
 * @author Martin
 *
 */
public interface KeyFactory {
	/**
	 * AES <code>KeyFactory</code> implementation
	 */
    KeyFactory AES = new AESKeyFactory();
	/**
	 * AES <code>KeyFactory</code> implementation
	 */
    KeyFactory DES = new DESKeyFactory();
	/**
	 * <p>Derives and returns a strong key from a password.</p>
	 * @param password
	 * @return
	 */
	Key keyFromPassword(char[] password);
	/**
	 * <p>Generates a strong random key.</p>
	 * @return
	 */
	Key randomKey();
	/**
	 * <p>Generates a random key of size <code>size</code>.</p>
	 * @param size
	 * @return
	 */
	Key randomKey(int size);
}
