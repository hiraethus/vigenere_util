package com.clackjones.vigenere;

import com.clackjones.vigenere.exception.InvalidKeyException;
import com.clackjones.vigenere.exception.InvalidMessageException;

public interface VigenereEncrypt {

	/**
	 * Set the key string for encrypting/decrypting messages
	 */
	void setKeyString(String keyString) throws InvalidKeyException;

	/**
	 * Get the key string for encrypting/decrypting messages
	 * @return
	 */
	String getKeyString() throws InvalidKeyException;

	/**
	 * Set the alphabetic message to be encrypted / decrypted
	 * @param message
	 */
	void setMessage(String message) throws InvalidMessageException;

	/**
	 * Get the alphabetic message to be encrypted / decrypted
	 * @param message
	 * @return
	 */
	String getMessage(String message);

	/**
	 * Encrypt the message given the set keystring
	 * @return
	 */
	String encrypt();

	/**
	 * Decrypt the message given the set keystring.
	 * @return
	 */
	String decrypt();
}
