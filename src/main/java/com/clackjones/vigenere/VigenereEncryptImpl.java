package com.clackjones.vigenere;

import org.apache.commons.lang3.StringUtils;

import com.clackjones.vigenere.exception.InvalidCharacterException;
import com.clackjones.vigenere.exception.InvalidKeyException;
import com.clackjones.vigenere.exception.InvalidMessageException;
import com.clackjones.vigenere.exception.KeyNotSetException;
import com.clackjones.vigenere.exception.MessageNotSetException;

public class VigenereEncryptImpl implements VigenereEncrypt {
	private String keyString;
	private String message;

	private VigenereSquare vigenereSquare = new VigenereSquareImpl();

	public void setKeyString(String keyString) throws InvalidKeyException {
		if (!StringUtils.isAlpha(keyString)) {
			throw new InvalidKeyException();
		}

		this.keyString = keyString.toUpperCase();
	}

	public String getKeyString() {
		return this.keyString;
	}

	public void setMessage(String message) throws InvalidMessageException {
		if (!StringUtils.isAlpha(message)) {
			throw new InvalidMessageException();
		}

		this.message = message.toUpperCase();
	}

	public String getMessage() {
		return this.message;
	}

	public String encrypt() throws InvalidCharacterException, MessageNotSetException, KeyNotSetException {
		if (this.message == null) { throw new MessageNotSetException(); }
		if (this.keyString == null) { throw new KeyNotSetException(); }

		int messageLength = this.message.length();
		int keyLength = this.keyString.length();
		StringBuilder encryptedMessage = new StringBuilder(messageLength);

		for (int i = 0; i < messageLength; ++i) {
			int keyCharIndex = i % keyLength;
			Character keyChar = this.keyString.charAt(keyCharIndex);
			Character messageChar = this.message.charAt(i);

			Character encryptedChar = vigenereSquare.encipherLetter(keyChar, messageChar);
			encryptedMessage.append(encryptedChar);
		}

		return encryptedMessage.toString();
	}

	public String decrypt() throws InvalidCharacterException, MessageNotSetException, KeyNotSetException {
		if (this.message == null) { throw new MessageNotSetException(); }
		if (this.keyString == null) { throw new KeyNotSetException(); }

		int messageLength = this.message.length();
		int keyLength = this.keyString.length();
		StringBuilder encryptedMessage = new StringBuilder(messageLength);

		for (int i = 0; i < messageLength; ++i) {
			int keyCharIndex = i % keyLength;
			Character keyChar = this.keyString.charAt(keyCharIndex);
			Character messageChar = this.message.charAt(i);

			Character encryptedChar = vigenereSquare.decipherLetter(keyChar, messageChar);
			encryptedMessage.append(encryptedChar);
		}

		return encryptedMessage.toString();
	}

}
