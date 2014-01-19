package com.clackjones.vigenere;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.clackjones.vigenere.exception.InvalidCharacterException;

public class VigenereSquareImplTest {
	private static VigenereSquareImpl vigenereSquare;

	@Before
	public void setup() {
		vigenereSquare = new VigenereSquareImpl();
	}

	@Test
	public void testEncipherLetter() throws InvalidCharacterException {
		Character keyLetter = 'L';
		Character unencipheredLetter = 'A';

		Character encipheredLetter = vigenereSquare.encipherLetter(keyLetter, unencipheredLetter);

		assertEquals("Character has not been enciphered correctly",
				Character.valueOf('L'),encipheredLetter);
	}

	@Test
	public void testEncipherLetterCaseInsensitive() throws InvalidCharacterException {
		Character keyLetter = 'l';
		Character unencipheredLetter = 'z';

		Character encipheredLetter = vigenereSquare.encipherLetter(keyLetter, unencipheredLetter);

		assertEquals("Character has not been enciphered correctly",
				Character.valueOf('K'),encipheredLetter);
	}

	@Test(expected=InvalidCharacterException.class)
	public void testEncipherLetterDetectInvalidCharacter() throws InvalidCharacterException {
		Character invalidCharacter = '8';
		Character unencipheredLetter = 'A';

		vigenereSquare.encipherLetter(invalidCharacter, unencipheredLetter);
	}

	@Test(expected=InvalidCharacterException.class)
	public void testEncipherLetterDetectInvalidCharacter2() throws InvalidCharacterException {
		Character invalidCharacter = '8';
		Character keyLetter = 'A';

		vigenereSquare.encipherLetter(keyLetter, invalidCharacter);
	}

	@Test
	public void testDecipherLetter() throws InvalidCharacterException {
		Character keyLetter = 'L';
		Character encipheredLetter = 'L';

		Character decipheredLetter = vigenereSquare.decipherLetter(keyLetter, encipheredLetter);

		assertEquals("Did not decipher letter correctly",
				Character.valueOf('A'), decipheredLetter);
	}

	@Test
	public void testDecipherLetterCaseInsensitive() throws InvalidCharacterException {
		Character keyLetter = 'l';
		Character encipheredLetter = 'k';

		Character decipheredLetter = vigenereSquare.decipherLetter(keyLetter, encipheredLetter);

		assertEquals("Did not decipher letter correctly",
				Character.valueOf('Z'), decipheredLetter);
	}
}
