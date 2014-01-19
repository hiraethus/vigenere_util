package com.clackjones.vigenere;

import com.clackjones.vigenere.exception.InvalidCharacterException;

public class VigenereSquareImpl implements VigenereSquare {
	private static final int A_NUMERIC_VALUE = (int) 'A';
	private static final int ALPHABET_LENGTH = 26;

	public Character encipherLetter(Character keyLetter,
			Character unencipheredLetter) throws InvalidCharacterException {
		keyLetter = prepareLetter(keyLetter);
		unencipheredLetter = prepareLetter(unencipheredLetter);

		int keyLetterNumericVal = (int) keyLetter;

		int distanceBetweenAAndKey = keyLetterNumericVal - A_NUMERIC_VALUE;

		int indexOfUncipheredLetter = (int) unencipheredLetter - A_NUMERIC_VALUE;
		int indexOfEncipheredLetter = (indexOfUncipheredLetter + distanceBetweenAAndKey) % ALPHABET_LENGTH;

		Character encipheredLetter = Character.valueOf((char) (A_NUMERIC_VALUE + indexOfEncipheredLetter));

		return encipheredLetter;
	}

	public Character decipherLetter(Character keyLetter,
			Character encipheredLetter) throws InvalidCharacterException {
		keyLetter = prepareLetter(keyLetter);
		encipheredLetter = prepareLetter(encipheredLetter);



		return null;
	}

	/**
	 * Ensures that the letter is upper case before the conversion.
	 * Throws an exception if the letter is not a valid A-Z character.
	 * process
	 * @param letter the input letter
	 * @return the uppercase form of the letter
	 * @throws InvalidCharacterException 
	 */
	private Character prepareLetter(Character letter) throws InvalidCharacterException {
		if (!Character.isAlphabetic(letter)) {
			throw new InvalidCharacterException();
		}
		return Character.toUpperCase(letter);
	}

}
