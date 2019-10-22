Assignment: English Language, Known Key Length
[VigenereProgram]

The first step of this mini-project is for you to write a program that breaks a Vigenère cipher, where you know that the language is English and the key length is also known.

We have provided three Java classes to get you started:

CaesarCipher: This class provides an implementation of the Caesar cipher algorithm that you learned about earlier with public encrypt and decrypt methods. A few adjustments have been made to the code to make it easier for you to work with here:

This code follows the second, object-oriented design you learned about, in which the constructor takes the key.
The code provides public methods to encrypt or decrypt one single character encryptLetter and decryptLetter.
In the constructor, the alphabets are built to have upper- and lowercase letters to preserve the case of a message.
You should test this code in a tester class that creates a CaesarCipher object and attempts to encrypt and decrypt an entire message (such as titus-small.txt), as well as individual characters.
CaesarCracker: This class provides an implementation of the Caesar cipher cracking (or breaking) algorithm that you learned about earlier. As with the CaesarCipher class, a few adjustments have been made:

The constructor takes a parameter for the most common letter, so it can be used for languages other than English.
Finding the key has been separated from decrypting the message. You can use the method getKey to pass in an encrypted message and receive the key back.
You can test these methods in the tester class by making a new CaesarCracker object and decrypting the file titus-small_key5.txt using no arguments for the constructor (default most common character ‘e’), and the file oslusiadas_key17.txt, noting that the most common character in Portuguese is ‘a’.
VigenereCipher: This class implements a Vigenère cipher. It has the following functionality:

public VigenereCipher(int[] key): the constructor, which takes a key, which is an array of integers and initializes the field ciphers, which is an array of CaesarCipher objects.
public String encrypt(String input): a method that encrypts the String passed in and returns the encrypted message.
public String decrypt(String input): a method that decrypts the String passed in and returns the decrypted message.
public String toString(): returns a String representing the key for this cipher.
You can test these methods in the tester class by creating a VigenereCipher object with the key “rome”, which is {17, 14, 12, 4} in integers and encrypting and decrypting the file titus-small.txt, the encrypted first line of which is “Tcmp-pxety mj nikhqv htee mrfhtii tyv”.
Your first step in this mini-project is to write the three methods in the VigenereBreaker class. Specifically you should do the following:

Write the public method sliceString, which has three parameters—a String message, representing the encrypted message, an integer whichSlice, indicating the index the slice should start from, and an integer totalSlices, indicating the length of the key. This method returns a String consisting of every totalSlices-th character from message, starting at the whichSlice-th character.
You can test your method on these examples:

sliceString("abcdefghijklm", 0, 3) should return "adgjm"

sliceString("abcdefghijklm", 1, 3) should return "behk"

sliceString("abcdefghijklm", 2, 3) should return "cfil"

sliceString("abcdefghijklm", 0, 4) should return "aeim"

sliceString("abcdefghijklm", 1, 4) should return "bfj"

sliceString("abcdefghijklm", 2, 4) should return "cgk"

sliceString("abcdefghijklm", 3, 4) should return "dhl"

sliceString("abcdefghijklm", 0, 5) should return "afk"

sliceString("abcdefghijklm", 1, 5) should return "bgl"

sliceString("abcdefghijklm", 2, 5) should return "chm"

sliceString("abcdefghijklm", 3, 5) should return "di"

sliceString("abcdefghijklm", 4, 5) should return "ej"

Write the public method tryKeyLength, which takes three parameters—a String encrypted that represents the encrypted message, an integer klength that represents the key length, and a character mostCommon that indicates the most common character in the language of the message. This method should make use of the CaesarCracker class, as well as the sliceString method, to find the shift for each index in the key. You should fill in the key (which is an array of integers) and return it. Test this method on the text file athens_keyflute.txt, which is a scene from A Midsummer Night’s Dream encrypted with the key “flute”, and make sure you get the key {5, 11, 20, 19, 4}.
Write the public method breakVigenere with no parameters. This void method should put everything together, so that you can create a new VigenereBreaker in BlueJ, call this method on it, and crack the cipher used on a message. This method should perform 6 tasks (in this order):
Create a new FileResource using its default constructor (which displays a dialog for you to select a file to decrypt).
Use the asString method to read the entire contents of the file into a String.
Use the tryKeyLength method, which you just wrote, to find the key for the message you read in. For now, you should just pass ‘e’ for mostCommon.
You should create a new VigenereCipher, passing in the key that tryKeyLength found for you.
You should use the VigenereCipher’s decrypt method to decrypt the encrypted message.
Finally, you should print out the decrypted message!
Test this method on the text file athens_keyflute.txt, using key length 5. The first line should be “SCENE II. Athens. QUINCE'S house.”

Assignment: English Language, Unknown Key Length
[Unknown Key Length/VigenereProgram]

Now that you have broken Vigenère ciphers with a known key length, it is time to expand your program’s functionality to break Vigenère ciphers of unknown key length. You will do this by adding three methods to your VigenereBreaker class, and then modifying your breakVigenere method.

Specifically, you should do the following:

In the VigenereBreaker class, write the public method readDictionary, which has one parameter—a FileResource fr. This method should first make a new HashSet of Strings, then read each line in fr (which should contain exactly one word per line), convert that line to lowercase, and put that line into the HashSet that you created. The method should then return the HashSet representing the words in a dictionary. All the dictionary files, including the English dictionary file, are included in the starter program you download. They are inside the folder called ‘dictionaries’.

In the VigenereBreaker class, write the public method countWords, which has two parameters—a String message, and a HashSet of Strings dictionary. This method should split the message into words (use .split(“\\W+”), which returns a String array), iterate over those words, and see how many of them are “real words”—that is, how many appear in the dictionary. Recall that the words in dictionary are lowercase. This method should return the integer count of how many valid words it found.

In the VigenereBreaker class, write the public method breakForLanguage, which has two parameters—a String encrypted, and a HashSet of Strings dictionary. This method should try all key lengths from 1 to 100 (use your tryKeyLength method to try one particular key length) to obtain the best decryption for each key length in that range. For each key length, your method should decrypt the message (using VigenereCipher’s decrypt method as before), and count how many of the “words” in it are real words in English, based on the dictionary passed in (use the countWords method you just wrote). This method should figure out which decryption gives the largest count of real words, and return that String decryption. Note that there is nothing special about 100; we will just give you messages with key lengths in the range 1–100. If you did not have this information, you could iterate all the way to encrypted.length(). Your program would just take a bit longer to run.

Finally, you need to modify your breakVigenere method to make use of your new code. The steps below describe what your breakVigenere method should do. They are similar to the steps from the previous portion of this project but have been updated: new items are in italics, [and old items that you should no longer do are in square brackets.]
Create a new FileResource using its default constructor (which displays a dialog for you to select a file to decrypt).

Use that FileResource’s asString method to read the entire contents of the file into a String.
You should make a new FileResource to read from the English dictionary file that we have provided. [Use the tryKeyLength method that you just wrote to find the key for the message you read in. For now, you should just pass ‘e’ for mostCommon.]
You should use your readDictionary method to read the contents of that file into a HashSet of Strings. [You should create a new VigenereCipher, passing in the key that tryKeyLength found for you.]

You should use the breakForLanguage method that you just wrote to decrypt the encrypted message. [You should use a VigenereCipher object to decrypt the encrypted message.]
Finally, you should print out the decrypted message!

Test this method on the text file athens_keyflute.txt. The first line should be “SCENE II. Athens. QUINCE'S house”, and the key is “flute”, or {5, 11, 20, 19, 4}. This file contains 376 valid words out of 386 (total word count ignores whitespace).

Assignment: Multiple Languages
[Multiple Languages/VigenereProgram]

Finally, it is time to expand your program so that it can crack messages in other languages. To accomplish this, you need to write two new methods and modify two methods you have already written.

Specifically, you should do the following:

In the VigenereBreaker class, write the public method mostCommonCharIn, which has one parameter—a HashSet of Strings dictionary. This method should find out which character, of the letters in the English alphabet, appears most often in the words in dictionary. It should return this most commonly occurring character. Remember that you can iterate over a HashSet of Strings with a for-each style for loop.

In the VigenereBreaker class, write the public method breakForAllLangs, which has two parameters—a String encrypted, and a HashMap, called languages, mapping a String representing the name of a language to a HashSet of Strings containing the words in that language. Try breaking the encryption for each language, and see which gives the best results! Remember that you can iterate over the languages.keySet() to get the name of each language, and then you can use .get() to look up the corresponding dictionary for that language. You will want to use the breakForLanguage and countWords methods that you already wrote to do most of the work (it is slightly inefficient to re-count the words here, but it is simpler, and the inefficiency is not significant). You will want to print out the decrypted message as well as the language that you identified for the message.

Modify the method breakForLanguage to make use of your mostCommonCharIn method to find the most common character in the language, and pass that to tryKeyLength instead of ‘e’.
Modify your breakVigenere method to read many dictionaries instead of just one. In particular, you should make a HashMap mapping Strings to a HashSet of Strings that will map each language name to the set of words in its dictionary. Then, you will want to read (using your readDictionary method) each of the dictionaries that we have provided (Danish, Dutch, English, French, German, Italian, Portuguese, and Spanish) and store the words in the HashMap you made. Reading all the dictionaries may take a little while, so you might add some print statements to reassure you that your program is making progress. Once you have made that change, you will want to call breakForAllLangs, passing in the message (the code to read in the message is unchanged from before), and the HashMap you just created.

Test your program on the file athens_keyflute.txt. Notice that the correct key “flute” {5, 11, 20, 19, 4} is detected for English, French, Danish, German, and Dutch, due to ‘e’ being the most common character and the languages having cognates, but English has the greatest number of valid words for its decryption.

