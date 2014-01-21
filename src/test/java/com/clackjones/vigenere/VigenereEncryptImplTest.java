package com.clackjones.vigenere;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.clackjones.vigenere.exception.InvalidCharacterException;
import com.clackjones.vigenere.exception.InvalidKeyException;
import com.clackjones.vigenere.exception.InvalidMessageException;
import com.clackjones.vigenere.exception.KeyNotSetException;
import com.clackjones.vigenere.exception.MessageNotSetException;

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

	@Test
	public void testSetMessage() throws InvalidMessageException {
		String message = "THISISAVALIDMESSAGE";
		vigenereEncrypt.setMessage(message);

		assertEquals(message, vigenereEncrypt.getMessage());
	}

	@Test
	public void testSetMessageCaseInsensitive() throws InvalidMessageException {
		String message = "thisisavalidmessage";
		vigenereEncrypt.setMessage(message);

		assertEquals(message.toUpperCase(), vigenereEncrypt.getMessage());
	}

	@Test(expected=InvalidMessageException.class)
	public void testSetMessageThrowsInvalidMessageException() throws InvalidMessageException {
		String invalidMessage = "123456";
		vigenereEncrypt.setMessage(invalidMessage);
	}

	@Test
	public void testEncrypt() throws InvalidMessageException, InvalidKeyException, InvalidCharacterException, MessageNotSetException, KeyNotSetException {
		String key = "LEMON";
		String message= "ATTACKATDAWN";

		vigenereEncrypt.setKeyString(key);
		vigenereEncrypt.setMessage(message);

		String expectedCipherText = "LXFOPVEFRNHR";
		String cipherText = vigenereEncrypt.encrypt();

		assertEquals(expectedCipherText, cipherText);
	}

	@Test(expected=MessageNotSetException.class)
	public void testEncryptMessageThrowsMessageNotSet() throws InvalidKeyException, InvalidCharacterException, MessageNotSetException, KeyNotSetException {
		vigenereEncrypt = new VigenereEncryptImpl();
		vigenereEncrypt.setKeyString("KEYSTRING");

		vigenereEncrypt.encrypt();
	}

	@Test(expected=KeyNotSetException.class)
	public void testEncryptMessageThrowsKeyNotSet() throws InvalidKeyException, InvalidCharacterException, MessageNotSetException, KeyNotSetException, InvalidMessageException {
		vigenereEncrypt = new VigenereEncryptImpl();
		vigenereEncrypt.setMessage("MESSAGEMESSAGEMESSAGE");

		vigenereEncrypt.encrypt();
	}

	@Test
	public void testDecrypt() throws InvalidMessageException, InvalidKeyException, InvalidCharacterException, MessageNotSetException, KeyNotSetException {
		String key = "LEMON";
		String cipherText = "LXFOPVEFRNHR";

		vigenereEncrypt.setKeyString(key);
		vigenereEncrypt.setMessage(cipherText);

		String expectedDecrypted = "ATTACKATDAWN";
		String decrypted = vigenereEncrypt.decrypt();

		assertEquals(expectedDecrypted, decrypted);
	}

	@Test(expected=MessageNotSetException.class)
	public void testDecryptMessageThrowsMessageNotSet() throws InvalidKeyException, InvalidCharacterException, MessageNotSetException, KeyNotSetException {
		vigenereEncrypt = new VigenereEncryptImpl();
		vigenereEncrypt.setKeyString("KEYSTRING");

		vigenereEncrypt.decrypt();
	}

	@Test(expected=KeyNotSetException.class)
	public void testDecryptMessageThrowsKeyNotSet() throws InvalidKeyException, InvalidCharacterException, MessageNotSetException, KeyNotSetException, InvalidMessageException {
		vigenereEncrypt = new VigenereEncryptImpl();
		vigenereEncrypt.setMessage("MESSAGEMESSAGEMESSAGE");

		vigenereEncrypt.decrypt();
	}
}
