package com.clackjones.vigenere;

import com.clackjones.vigenere.exception.InvalidCharacterException;
import com.clackjones.vigenere.exception.InvalidKeyException;
import com.clackjones.vigenere.exception.InvalidMessageException;
import com.clackjones.vigenere.exception.KeyNotSetException;
import com.clackjones.vigenere.exception.MessageNotSetException;

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
	String getMessage();

	/**
	 * Encrypt the message given the set keystring
	 * @return
	 */
	String encrypt() throws KeyNotSetException, MessageNotSetException, InvalidCharacterException;

	/**
	 * Decrypt the message given the set keystring.
	 * @return
	 */
	String decrypt() throws KeyNotSetException, MessageNotSetException, InvalidCharacterException;
}
