package com.clackjones.vigenere;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VigenereSquareImplTest {
	private static VigenereSquareImpl vigenereSquare;
	
	@Before
	public void setup() {
		vigenereSquare = new VigenereSquareImpl();
	}

	@Test
	public void testEncipherLetter() {
		Character keyLetter = 'L';
		Character unencipheredLetter = 'A';
		
		Character encipheredLetter = vigenereSquare.encipherLetter(keyLetter, unencipheredLetter);
		
		assertEquals("Character has not been enciphered correctly",
				Character.valueOf('L'),encipheredLetter);
	}

	@Test
	public void testEncipherLetterCaseInsensitive() {
		Character keyLetter = 'l';
		Character unencipheredLetter = 'a';
		
		Character encipheredLetter = vigenereSquare.encipherLetter(keyLetter, unencipheredLetter);
		
		assertEquals("Character has not been enciphered correctly",
				Character.valueOf('L'),encipheredLetter);
	}
}
