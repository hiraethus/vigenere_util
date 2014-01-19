package com.clackjones.vigenere;

import org.apache.commons.lang3.StringUtils;

import com.clackjones.vigenere.exception.InvalidKeyException;
import com.clackjones.vigenere.exception.InvalidMessageException;

public class VigenereEncryptImpl implements VigenereEncrypt {
	private String keyString;

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
		// TODO Auto-generated method stub

	}

	public String getMessage(String message) {
		// TODO Auto-generated method stub
		return null;
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
