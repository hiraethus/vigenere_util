package com.clackjones.vigenere;

import org.apache.commons.lang3.StringUtils;

import com.clackjones.vigenere.exception.InvalidKeyException;
import com.clackjones.vigenere.exception.InvalidMessageException;

public class VigenereEncryptImpl implements VigenereEncrypt {
	private String keyString;
	private String message;

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

	public String encrypt() {
		// TODO Auto-generated method stub
		return null;
	}

	public String decrypt() {
		// TODO Auto-generated method stub
		return null;
	}

}
