/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple “substitution cipher” where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */
/*
 * Class: CMSC203 
 * Instructor: Khandan MOnshi
 * Description: Create a class that will encrypt and decrypt code 
 * based on two given methods, involves using ascii codes and altering strings
 * Due: 5/11/23
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: SOphia Pettit
*/

public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		
		//set boolean variable that used to indicate whether string is within bounds
		boolean temp=true;
		
		//loop to check each character is in bounds
		for(int i=0; i< plainText.length(); i++)
		{
			if(plainText.charAt(i)< LOWER_RANGE||plainText.charAt(i)> UPPER_RANGE)
			{
				temp=false;
			}
		}
		
		//return variables
		return temp;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		
		//call is string in bounds
		if(isStringInBounds(plainText)==false)
		{
			return "The selected string is not in bounds, Try again.";
		}
		else
		{
			//running the actual encryption part here, and initializing our return 
			String temp="";
			char sample;
			int valueOfChar;
			for( int i=0; i< plainText.length(); i++)
			{
				sample=plainText.charAt(i);
				//checks to see if value after adding key is within bounds,otherwise wrap around
				while(((int)sample+key)> UPPER_RANGE)
				{
					//reduces key until sample+key is in range
					key-=(UPPER_RANGE-LOWER_RANGE+1);
				}
				//sets ascii value for encypted char and sets it to sample and add to string
				valueOfChar= (int)sample+key;
				sample = (char)valueOfChar;
				temp+= sample;
			}
			
			//return encrpted string
			return temp;
		}
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr) {
		
		//set up the neccessary variables
		String temp="";
		char sample;
		int valueOfChar;
		int keyIndex;
		
		//set up loop that runs through the string
		for(int i=0; i<plainText.length();i++)
		{
			sample = plainText.charAt(i);
			//set key index
			keyIndex=i;
			while(keyIndex >= bellasoStr.length())
			{
				keyIndex-=bellasoStr.length();
			}
			
			valueOfChar= bellasoStr.charAt(keyIndex);
			sample=plainText.charAt(i);
			//check if key+plaintext is out of bounds
			while(sample+valueOfChar> UPPER_RANGE)
			{
				valueOfChar -= (UPPER_RANGE-LOWER_RANGE +1);
			}
			//changes sample
			sample+= valueOfChar;
			
			//adds to string
			temp+= sample;
		}
		
		//return the string
		return temp;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {
		//running the actual decryption part here, and initializing our return 
		String temp="";
		char sample;
		int valueOfChar;
		for( int i=0; i< encryptedText.length(); i++)
		{
			sample=encryptedText.charAt(i);
			//checks to see if value after subtracting/undoing key is within bounds,otherwise wrap around
			while(((int)sample-key)< LOWER_RANGE)
			{
				//reduces key until sample+key is in range
				key-=(UPPER_RANGE-LOWER_RANGE+1);
			}
			//sets ascii value for encypted char and sets it to sample and add to string
			if((int)sample-key ==96)
			{
				valueOfChar=32;
			}
			else
			{
				valueOfChar= (int)sample-key;
			}
			sample = (char)valueOfChar;
			temp+= sample;
		}
		
		//return encrpted string
		return temp;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		//set up the neccessary variables
		String temp="";
		char sample;
		int valueOfChar;
		int keyIndex;
		
		//set up loop that runs through the string
		for(int i=0; i<encryptedText.length();i++)
		{
			sample = encryptedText.charAt(i);
			//set key index
			keyIndex=i;
			while(keyIndex>= bellasoStr.length())
			{
				keyIndex-=bellasoStr.length();
			}
			
			valueOfChar= (int)bellasoStr.charAt(keyIndex);
			sample=encryptedText.charAt(i);
			//check if key+plaintext is out of bounds
			while(sample-valueOfChar< LOWER_RANGE)
			{
				valueOfChar -= (UPPER_RANGE-LOWER_RANGE +1);
			}
			//changes sample
			sample-= valueOfChar;
			
			//adds to string
			temp+= sample;
		}
		
		//return the string
		return temp;
	}
}
