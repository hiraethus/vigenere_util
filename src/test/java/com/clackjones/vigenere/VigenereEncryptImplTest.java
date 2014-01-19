package com.clackjones.vigenere;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.clackjones.vigenere.exception.InvalidKeyException;

public class VigenereEncryptImplTest {

	private static VigenereEncryptImpl vigenereEncrypt;

	@Before
	public void setup() {
		vigenereEncrypt = new VigenereEncryptImpl();
	}

	@Test
	public void testSetKeyString() throws InvalidKeyException {
		String keyString = "THISISAKEY";
		vigenereEncrypt.setKeyString(keyString);

		String outKey = vigenereEncrypt.getKeyString();
		assertEquals (keyString, outKey);
	}

	@Test
	public void testSetKeyStringToUpperCase() throws InvalidKeyException {
		String keyString = "thisIsAKey";
		vigenereEncrypt.setKeyString(keyString);

		String outKey = vigenereEncrypt.getKeyString();
		assertEquals(keyString.toUpperCase(), outKey);
	}

	@Test(expected=InvalidKeyException.class)
	public void testSetKeyStringInvalidInputString() throws InvalidKeyException {
		String keyString = "this is a key string";
		vigenereEncrypt.setKeyString(keyString);
	}

}
