package com.clackjones.vigenere;

import org.apache.commons.lang3.StringUtils;

import com.clackjones.vigenere.exception.InvalidKeyStringException;

public class VigenereEncryptImpl implements VigenereEncrypt {
	private String keyString;

	public void setKeyString(String keyString) throws InvalidKeyStringException {
		if (!StringUtils.isAlpha(keyString)) {
			throw new InvalidKeyStringException();
		}

		this.keyString = keyString.toUpperCase();
	}

	public String getKeyString() {
		return this.keyString;
	}

}
