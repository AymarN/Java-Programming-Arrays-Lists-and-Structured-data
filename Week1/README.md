
[Implementing the Caesar Cipher]

Assignment 1: Word Play

You will write a program to transform words from a file into another form, such as replacing vowels with an asterix.
Specifically, you should do the following.

Create a new class called WordPlay.
Write a method isVowel that has one Char parameter named ch. This method returns true if ch is a vowel (one of 'a', 'e', 'i', 'o', or 'u' or the uppercase versions) and false otherwise.

You should write a tester method to see if this method works correctly. For example, isVowel(‘F’) should return false, and isVowel(‘a’) should return true.

Write a method replaceVowels that has two parameters, a String named phrase and a Char named ch. This method should return a String that is the string phrase with all the vowels (uppercase or lowercase) replaced by ch. For example, the call replaceVowels(“Hello World”, ‘*’) returns the string “H*ll* W*rld”. Be sure to call the method isVowel that you wrote and also test this method.

Write a method emphasize with two parameters, a String named phrase and a character named ch. This method should return a String that is the string phrase but with the Char ch (upper- or lowercase) replaced by
‘*’ if it is in an odd number location in the string (e.g. the first character has an odd number location but an even index, it is at index 0), or

‘+’ if it is in an even number location in the string (e.g. the second character has an even number location but an odd index, it is at index 1).

For example, the call emphasize(“dna ctgaaactga”, ‘a’) would return the string “dn* ctg+*+ctg+”, and the call emphasize(“Mary Bella Abracadabra”, ‘a’) would return the string “M+ry Bell+ +br*c*d*br+”. Be sure to test this method.

Assignment 2: Caesar Cipher

You will start with the Caesar Cipher algorithm you learned about in the videos, and you will make some enhancements to it, so that it works with all letters (both uppercase and lowercase) and to make it a little bit harder to decrypt. Write these methods in a CaesarCipher class you can use in the next lesson.
Specifically, you should do the following:
Create a new class called CaesarCipher.
Write the method encrypt that has two parameters, a String named input and an int named key. This method returns a String that has been encrypted using the Caesar Cipher algorithm explained in the videos. Assume that all the alphabetic characters are uppercase letters. For example, the call encrypt(“FIRST LEGION ATTACK EAST FLANK!”, 23)

should return the string

“CFOPQ IBDFLK XQQXZH BXPQ CIXKH!”

Write the void method testCaesar that has no parameters. This method should read a file and encrypt the complete file using the Caesar Cipher algorithm, printing the encrypted message. You may want to include the lines:

FileResource fr = new FileResource();
String message = fr.asString();
String encrypted = encrypt(message, key);
System.out.println("key is " + key + "\n" + encrypted);

Modify the encrypt method to be able to handle both uppercase and lowercase letters. For example, encrypt(“First Legion”, 23) should return “Cfopq Ibdflk”, and encrypt(“First Legion”, 17) should return “Wzijk Cvxzfe”. Be sure to test the encrypt method.

Write the method encryptTwoKeys that has three parameters, a String named input, and two integers named key1 and key2. This method returns a String that has been encrypted using the following algorithm. Parameter key1 is used to encrypt every other character with the Caesar Cipher algorithm, starting with the first character, and key2 is used to encrypt every other character, starting with the second character. For example, the call encryptTwoKeys(“First Legion”, 23, 17) should return “Czojq Ivdzle”. Note the ‘F’ is encrypted with key 23, the first ‘i’ with 17, the ‘r’ with 23, and the ‘s’ with 17, etc. Be sure to test this method.


[Breaking the Caesar Cipher]

Assignment 1: Word lengths

Before attempting these assignments, you should type in, compile, and understand the example programs from the lesson, including: 1) counting the twenty most common words from Shakespeare’s plays, 2) counting the resulting random rolls of dice (how many 2’s, 3’s, 4’s, etc), and 3) automatic decryption of the Caesar Cipher using statistical letter occurrences.

You will write a program to figure out the most common word length of words from a file. To solve this problem you will need to keep track of how many words from a file are of each possible length. You should group all words of length 30 or more together, and you should not count basic punctuation that are the first or last characters of a group of characters.

Specifically, you should do the following:

Create a new class called WordLengths.
Write a void method countWordLengths that has two parameters, a FileResource named resource and an integer array named counts. This method should read in the words from resource and count the number of words of each length for all the words in resource, storing these counts in the array counts.
- For example, after this method executes, counts[k] should contain the number of words of length k.

- If a word has a non-letter as the first or last character, it should not be counted as part of the word length. For example, the word And, would be considered of length 3 (the comma is not counted), the word “blue-jeans” would be considered of length 10 (the double quotes are not counted, but the hyphen is). Note that we will miscount some words, such as “Hello,” which will be counted as 6 since we don’t count the double quotes but will count the comma, but that is OK as there should not be many words in that category.

- For any words equal to or larger than the last index of the counts array, count them as the largest size represented in the counts array.

- You may want to consider using the Character.isLetter method that returns true if a character is a letter, and false otherwise. For example, Character.isLetter(‘a’) returns true, and Character.isLetter(‘-’) returns false.

Write a void method testCountWordLengths that creates a FileResource so you can select a file, and creates a counts integer array of size 31. This method should call countWordLengths with a file and then print the number of words of each length. Test it on the small file smallHamlet.txt shown below.
Write a method indexOfMax that has one parameter named values that is an integer array. This method returns the index position of the largest element in values. Then add code to the method testCountWordLengths to call indexOfMax to determine the most common word length in the file. For example, calling indexOfMax after calling countWordLengths on the file smallHamlet.txt should return 3.
First test your program on a small file, such as this simple file shown called smallHamlet.txt:

Laer. My necessaries are embark'd. Farewell.
And, sister, as the winds give benefit
Note this file has words that are:
2 words of length 2: My as
3 words of length 3: are And the
2 words of length 4: Laer give
1 word of length 5: winds
1 word of length 6: sister
1 word of length 7: benefit
2 words of length 8: embark’d Farewell
1 word of length 11: necessaries


Assignment 2: Caesar Cipher Two Keys Decrypt

You should start by writing the decryption method explained in the lesson that decrypts a message that was encrypted with one key, using statistical letter frequencies of English text. Then you will add code to be able to decrypt a message that was encrypted with two keys, using ideas from the single key decryption method and the encryption with two keys method from the program you wrote in the last lesson.

Idea for two keys decrypt method. Recall that in using two keys, key1 and key2, key1 was used to encrypt every other character, starting with the first, of the String, and key2 was used to encrypt every other character, starting with the second. In order to decrypt the encrypted String, it may be easier to split the String into two Strings, one String of all the letters encrypted with key1 and one String of all the letters encrypted with key2. Then use the algorithm from the lesson to determine the key for each String, and then use those keys and the two key encryption method to decrypt the original encrypted message.

For example, if the encrypted message was “Qbkm Zgis”, then you would split this String into two Strings: “Qk gs”, representing the characters in the odd number positions and “bmZi” representing the characters in the even number positions. Then you would get the key for each half String and use the two key encryption method to find the message. Note this example is so small it likely won’t find the keys, but it illustrates how to take the Strings apart.

A sample file to test your program that is small with lots of e’s is called wordsLotsOfEs.txt and shown here:

Just a test string with lots of eeeeeeeeeeeeeeeees

And the same file encrypted using keys 23 and 2 is called wordsLotsOfEsEncrypted.txt and is shown here:

Gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu

Specifically, you should do the following.

Complete the decryption method shown in the lesson by creating a CaesarBreaker class with the methods countLetters, maxIndex, and decrypt. Recall that the decrypt method creates a CaesarCipher object in order to use the encrypt method you wrote for the last lesson. Make sure that your CaesarCipher class is in the same folder as CaesarBreaker! You may want to use the following code as part of your decrypt method.

CaesarCipher cc = new CaesarCipher();
String message = cc.encrypt(encrypted, 26 - key);
Write a testDecrypt method in the CaesarBreaker class that prints the decrypted message, and make sure it works for encrypted messages that were encrypted with one key.
Write the method halfOfString in the CaesarBreaker class that has two parameters, a String parameter named message and an int parameter named start. This method should return a new String that is every other character from message starting with the start position. For example, the call halfOfString(“Qbkm Zgis”, 0) returns the String “Qk gs” and the call halfOfString(“Qbkm Zgis”, 1) returns the String “bmZi”. Be sure to test this method with a small example.
Write the method getKey in the CaesarBreaker class that has one parameter, a String s. This method should call countLetters to get an array of the letter frequencies in String s and then use maxIndex to calculate the index of the largest letter frequency, which is the location of the encrypted letter ‘e’, which leads to the key, which is returned.
Write the method decryptTwoKeys in the CaesarBreaker class that has one parameter, a String parameter named encrypted that represents a String that was encrypted with the two key algorithm discussed in the previous lesson. This method attempts to determine the two keys used to encrypt the message, prints the two keys, and then returns the decrypted String with those two keys. More specifically, this method should:
- Calculate a String of every other character starting with the first character of the encrypted String by calling halfOfString.

- Calculate a String of every other character starting with the second character of the encrypted String.

- Then calculate the key used to encrypt each half String.

- You should print the two keys found.

- Calculate and return the decrypted String using the encryptTwoKeys method from your CaesarCipher class, again making sure it is in the same folder as your CaesarBreaker class.


[Object Oriented Caesar Cipher]

Assignment 1: One Key

In this assignment, you will put together the CaesarCipher class from the lesson and add a decrypt method to decrypt with the same key. In addition you will create a second class, TestCaesarCipher to test examples that use the CaesarCipher class, including writing a method that will automatically decrypt an encrypted file by determining the key and then decrypting with that key.

Specifically, you should do the following.
Create the CaesarCipher class with the following parts:

Private fields for the alphabet and shiftedAlphabet
Write a constructor CaesarCipher that has one int parameter key. This method should initialize all the private fields of the class.

Write an encrypt method that has one String parameter named input. This method returns a String that is the input encrypted using shiftedAlphabet.

Write a decrypt method that has one String parameter named input. This method returns a String that is the encrypted String decrypted using the key associated with this CaesarCipher object. One way to do this is to create another private field mainKey, which is initialized to be the value of key. Then you can create a CaesarCipher object within decrypt: CaesarCipher cc = new CaesarCipher(26 - mainKey); and call cc.encrypt(input).
Create the TestCaesarCipher class with the following parts:

Include the methods countLetters and maxIndex that you wrote in the previous lesson.
Write the void method simpleTests that has no parameters. This method should read in a file as a String, create a CaesarCipher object with key 18, encrypt the String read in using the CaesarCipher object, print the encrypted String, and decrypt the encrypted String using the decrypt method.

Write the method breakCaesarCipher that has one String parameter named input. This method should figure out which key was used to encrypt this message (in a similar manner as the previous lesson), then create a CaesarCipher object with that key and decrypt the message.
In the simpleTests method, add a call to breakCaesarCipher on the encrypted String to decrypt it automatically by determining the key, and print the decrypted String.

Assignment 2: Two Keys

In this assignment, you will put together the CaesarCipherTwo class that encrypts a message with two keys (the same way as the previous lesson: key1 is used to encrypt every other letter, starting with the first, and key2 is used to encrypt every other letter, starting with the second), and also decrypts the same message. In addition you will create a second class, TestCaesarCipherTwo to test examples that use the CaesarCipherTwo class, including writing a method that will automatically decrypt an encrypted file by determining the two keys that were used to encrypt it.

Specifically, you should do the following.
Create the CaesarCipherTwo class with the following parts:

Include private fields for the alphabet, shiftedAlphabet1, and shiftedAlphabet2.
Write a constructor CaesarCipherTwo that has two int parameters key1 and key2. This method should initialize all the private fields.

Write an encrypt method that has one String parameter named input. This method returns a String that is the input encrypted using the two shifted alphabets.

Write a decrypt method that has one String parameter named input. This method returns a String that is the encrypted String decrypted using the key1 and key2 associated with this CaesarCipherTwo object. You might want to add more private fields to the class.
Create the TestCaesarCipherTwo class with the following parts:

Include the methods halfOfString, countLetters, and maxIndex that you wrote in the previous lesson.

Write the void method simpleTests that has no parameters. This method should read in a file as a String, create a CaesarCipherTwo object with keys 17 and 3, encrypt the String using the CaesarCipherTwo object, print the encrypted String, and decrypt the encrypted String using the decrypt method.

Write the method breakCaesarCipher that has one String parameter named input. This method should figure out which keys were used to encrypt this message (in a similar manner as before), then create a CaesarCipherTwo object with that key and decrypt the message.
In the simpleTests method, add a call to breakCaesarCipher on the encrypted String to decrypt it automatically by determining the keys, and then print the decrypted String.

