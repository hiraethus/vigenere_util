package com.clackjones.vigenere;

import com.clackjones.vigenere.exception.InvalidKeyStringException;

public interface VigenereEncrypt {

	/**
	 * Set the key string for encrypting/decrypting messages
	 */
	void setKeyString(String keyString) throws InvalidKeyStringException;

	/**
	 * Get the key string for encrypting/decrypting messages
	 * @return
	 */
	String getKeyString() throws InvalidKeyStringException;

}
