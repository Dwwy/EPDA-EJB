package com.example.demo1.Util.Encryption;

/**
 * <p>Factory class for creating secure AES keys.</p>
 * @author Martin
 *
 */
public class AESKeyFactory extends AbsKeyFactory {

	public static final String ALGORITHM = "AES";
	public static final int MAXIMUM_KEY_LENGTH = 256;

	public AESKeyFactory() {
		super(ALGORITHM, MAXIMUM_KEY_LENGTH);
	}
}