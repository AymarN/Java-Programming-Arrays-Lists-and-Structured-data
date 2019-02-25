
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (Aymar N.) 
 * @version (a version number or a date)
 */
import edu.duke.*;



/* 
Specifically, you should do the following: 
Create a new class called CaesarCipher.
Write the method encrypt that has two parameters, a String named input and 
an int named key. This method returns a String that has been encrypted using
the Caesar Cipher algorithm explained in the videos. Assume that all the
alphabetic characters are uppercase letters. For example, the call 
encrypt(“FIRST LEGION ATTACK EAST FLANK!”, 23)
should return the string
“CFOPQ IBDFLK XQQXZH BXPQ CIXKH!” */

public class CaesarCipher {
    
    public String encrypt (String input, int key)
    {
        // Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder (input);
        // Write down the alphabet 
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // Compute the shifted alphabet
        String shiftedAlphabet = alphabet.substring(key)+ alphabet.substring(0,key);
        
        // Count from 0 to < length of encrypted,(call it i)
        for ( int i = 0; i < encrypted.length();i++){
        // Look at the ith character of encrypted ( call it currchar)
        char currChar = encrypted.charAt(i);
        // Find the index of currChar in the alphabet (call it idx)
        int idx = alphabet.indexOf(currChar);
        // If currChar is in the alphabet
        if (idx !=-1){
            // Get the idxth character of shiftedAlphabet (newChar)
            char newChar = shiftedAlphabet.charAt(idx);
            // Replace the ith character of encrypted with newChar
            encrypted.setCharAt(i,newChar);
        }
        //otherwise : do nothing   
    }
    // Your answer is the String inside of encrypted 
     return encrypted.toString();
   }
   
   /* Modify the encrypt method to be able to handle both uppercase and 
   lowercase letters. For example, encrypt(“First Legion”, 23) should
   return “Cfopq Ibdflk”, and encrypt(“First Legion”, 17) should return 
   “Wzijk Cvxzfe”. Be sure to test the encrypt method. */
   
   public String encrypt_changed(String input, int key)
    {
        // Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder (input);
        // Write down the alphabet 
        String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabet = Alphabet.toLowerCase();
        
        // Compute the shifted alphabet
        String ShiftedAlphabet = Alphabet.substring(key)+ Alphabet.substring(0,key);
        String shiftedAlphabet = alphabet.substring(key)+ alphabet.substring(0,key);
        // Count from 0 to < length of encrypted,(call it i)
        for (int i = 0; i < encrypted.length();i++){
        // Look at the ith character of encrypted ( call it currchar)
        char currChar = encrypted.charAt(i);
        if (Character.isLowerCase(currChar))
        {
        // Find the index of currChar in the alphabet (call it idx)
            int idx = alphabet.indexOf(currChar);
        // If currChar is in the alphabet
        if (idx !=-1){
            // Get the idxth character of shiftedAlphabet (newChar)
            char newChar = shiftedAlphabet.charAt(idx);
            // Replace the ith character of encrypted with newChar
            encrypted.setCharAt(i,newChar);
        }
        
        }
        
        else {
         // Find the index of currChar in the alphabet (call it idx)
            int idx = Alphabet.indexOf(currChar);
        // If currChar is in the alphabet
        if (idx !=-1){
            // Get the idxth character of shiftedAlphabet (newChar)
            char newChar = ShiftedAlphabet.charAt(idx);
            // Replace the ith character of encrypted with newChar
            encrypted.setCharAt(i,newChar);
        }
            
        }
        
        
        //otherwise : do nothing   
    }
    // Your answer is the String inside of encrypted 
     return encrypted.toString();
   }
   
   /* Write the method encryptTwoKeys that has three parameters, a String named 
   input, and two integers named key1 and key2. This method returns a String
   that has been encrypted using the following algorithm. Parameter key1 is 
   used to encrypt every other character with the Caesar Cipher algorithm, 
   starting with the first character, and key2 is used to encrypt every other
   character, starting with the second character. For example, 
   the call encryptTwoKeys(“First Legion”, 23, 17) should return 
   “Czojq Ivdzle”. Note the ‘F’ is encrypted with key 23, the first ‘i’ 
   with 17, the ‘r’ with 23, and the ‘s’ with 17, etc. 
   Be sure to test this method.*/
   
    public String encryptTwoKeys(String input, int key1, int key2)
    {
        // Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder (input);
        // Write down the alphabet 
        String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        
        // Compute the shifted alphabet
        String ShiftedAlphabet1 = Alphabet.substring(key1)+ Alphabet.substring(0,key1);
        String shiftedAlphabet1 = alphabet.substring(key1)+ alphabet.substring(0,key1);
        
        String ShiftedAlphabet2 = Alphabet.substring(key2)+ Alphabet.substring(0,key2);
        String shiftedAlphabet2 = alphabet.substring(key2)+ alphabet.substring(0,key2);
        
        // Count from 0 to < length of encrypted,(call it i)
        for (int i = 0; i <encrypted.length();i+=2){
        // Look at the ith character of encrypted ( call it currchar)
        char currChar = encrypted.charAt(i);
        
        if ((i %2 == 0) && (Character.isLowerCase(currChar)))
        {
        // Find the index of currChar in the alphabet (call it idx)
            int idx = alphabet.indexOf(currChar);
        // If currChar is in the alphabet
        if (idx!= 0)
            {
            // Get the idxth character of shiftedAlphabet (newChar)
            char newChar = shiftedAlphabet1.charAt(idx);
            // Replace the ith character of encrypted with newChar
            encrypted.setCharAt(i,newChar);
            }
        }
        
        else if ((i %2 == 0) && (Character.isUpperCase(currChar)))
        {
        // Find the index of currChar in the alphabet (call it idx)
            int idx = Alphabet.indexOf(currChar);
        // If currChar is in the alphabet
        if (idx != 0)
            {
            // Get the idxth character of shiftedAlphabet (newChar)
            char newChar = ShiftedAlphabet1.charAt(idx);
            // Replace the ith character of encrypted with newChar
            encrypted.setCharAt(i,newChar);
            }
        }
        
    }
    
       for (int i = 1; i <encrypted.length();i+=2){
        // Look at the ith character of encrypted ( call it currchar)
        char currChar = encrypted.charAt(i);
        
        if ((i %2 != 0) && (Character.isLowerCase(currChar)))
        {
        // Find the index of currChar in the alphabet (call it idx)
            int idx = alphabet.indexOf(currChar);
        // If currChar is in the alphabet
        if (idx != 0)
            {
            // Get the idxth character of shiftedAlphabet (newChar)
            char newChar = shiftedAlphabet2.charAt(idx);
            // Replace the ith character of encrypted with newChar
            encrypted.setCharAt(i,newChar);
            }
        }
        
        else if ((i %2 != 0) && (Character.isUpperCase(currChar)))
        
        {
        // Find the index of currChar in the alphabet (call it idx)
            int idx = Alphabet.indexOf(currChar);
        // If currChar is in the alphabet
        if (idx != 0)
            {
            // Get the idxth character of shiftedAlphabet (newChar)
            char newChar = ShiftedAlphabet2.charAt(idx);
            // Replace the ith character of encrypted with newChar
            encrypted.setCharAt(i,newChar);
            }
        }
                
    } 
    
    return encrypted.toString();
 
}


  public void CaesarCipher()
   {
        System.out.println(encrypt("FIRST LEGION ATTACK EAST FLANK!",23));
    } 
    
     public void encrypt_changed()
    { 
      System.out.println(encrypt_changed("First Legion",23)+"\n");
      //System.out.println(encrypt_changed("First Legion",17)+"\n");
      //System.out.println(encrypt_changed("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",15)+"\n");
      //System.out.println(encrypt_changed("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",8)+"\n");
      //System.out.println(encrypt_changed("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",21)+"\n");
      System.out.println(encrypt_changed("Can you imagine life WITHOUT the internet AND computers in your pocket?",15)+"\n");
    } 
    
    /* Write the void method testCaesar that has no parameters. This method 
    should read a file and encrypt the complete file using the Caesar Cipher
    algorithm, printing the encrypted message. You may want to include the 
    lines: 
    */ 
    public void testCaesar()
    {
        int key = 23;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message,key);
        System.out.println("Key is"+ key+"\n"+encrypted);
    }
    
    public void encryptTwoKeys()
    {
        int key = 14;
        int key2 = 24;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encryptTwoKeys(message,key,key2);
        System.out.println("Key1 is "+ key + " and Key2 is "+ key2 +"\n"+encrypted);
     
      
    }
    
}
