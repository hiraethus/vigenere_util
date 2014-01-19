package com.clackjones.vigenere;

/**
 * An object that serves as a lookup for the Vigenere square. It is
 * case insensitive in that given a lower case alphabetical character it 
 * will always convert it into an uppercase character.
 * @author Michael
 *
 */
public interface VigenereSquare {
	
	/**
	 * This method finds the cipher character for a given letter in 
	 * a message when a given keyLetter is used.
	 * 
	 * @param keyLetter The current key character used to encipher the source letter
	 * @param unencipheredLetter The letter from the source character to be enciphered
	 * @return The enciphered character
	 */
	Character encipherLetter(Character keyLetter, Character unencipheredLetter);
	
	
	/**
	 * This method converts an enciphered letter into a deciphered letter given the 
	 * current key letter.
	 * @param keyLetter
	 * @param encipheredLetter
	 * @return
	 */
	Character decipherLetter(Character keyLetter, Character encipheredLetter);
}
