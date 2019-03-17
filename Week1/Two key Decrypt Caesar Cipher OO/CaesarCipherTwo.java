
/**
 *  CaesarCipherTwo
 * You will put together the CaesarCipherTwo class that encrypts a message
 * with two Keys  and also decrypts the message.
 * In addition you will create a second class, TestCaesarCipherTwo to
 * test examples that use CaesarCipherTwo class including a method that will
 * automatically decrypt an encrypted file by determining the two keys that 
 * were used to encrypt it.
 * 
 * @author (Aymar NAHUM) 
 * @version (16.02.2019)
 */

import edu.duke.*;

public class CaesarCipherTwo{
    
    private int mainKey1;
    private int mainKey2;
    private String Alphabet;
    private String alphabet;
    private String ShiftedAlphabet1;
    private String shiftedAlphabet1;
    private String ShiftedAlphabet2;
    private String shiftedAlphabet2;
    
    //The constructor with Two parameters.
    
    public CaesarCipherTwo(int key1, int key2) {
        
        mainKey1 = key1;
        mainKey2 = key2;
        Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        alphabet = Alphabet.toLowerCase();
        ShiftedAlphabet1 = Alphabet.substring(key1)+ Alphabet.substring(0,key1);
        shiftedAlphabet1 = alphabet.substring(key1)+ alphabet.substring(0,key1);
        ShiftedAlphabet2 = Alphabet.substring(key2)+ Alphabet.substring(0,key2);
        shiftedAlphabet2 = alphabet.substring(key2)+ alphabet.substring(0,key2);
    }
    
    /*
     * Write an encrypt method that has one String parameter named input.
     * This method returns a String that is the input encrypted using the two
     * shifted alphabets.
     */
    
    public String encrypt(String input){
        StringBuilder encrypted = new StringBuilder(input);
        for (int i = 0; i <encrypted.length();i+=2){
        
        char currChar = encrypted.charAt(i);
        
        if ((i %2 == 0) && (Character.isLowerCase(currChar)))
        {
        
            int idx = alphabet.indexOf(currChar);
        
        if (idx!= 0)
            {
            char newChar = shiftedAlphabet1.charAt(idx);
            encrypted.setCharAt(i,newChar);
            }
        }
        
        else if ((i %2 == 0) && (Character.isUpperCase(currChar)))
        {
            int idx = Alphabet.indexOf(currChar);
        if (idx != 0)
            {
            char newChar = ShiftedAlphabet1.charAt(idx);
            encrypted.setCharAt(i,newChar);
            }
        }
        
    }
    
       for (int i = 1; i <encrypted.length();i+=2){
        char currChar = encrypted.charAt(i);
        
        if ((i %2 != 0) && (Character.isLowerCase(currChar)))
        {
            int idx = alphabet.indexOf(currChar);
        if (idx != 0)
            {
            char newChar = shiftedAlphabet2.charAt(idx);
            encrypted.setCharAt(i,newChar);
            }
        }
        
        else if ((i %2 != 0) && (Character.isUpperCase(currChar)))
        {
            int idx = Alphabet.indexOf(currChar);
        if (idx != 0)
            {
            char newChar = ShiftedAlphabet2.charAt(idx);
            encrypted.setCharAt(i,newChar);
            }
        }
                
    } 
    
    return encrypted.toString();   
    }
    
    /*
     * Write a decrypt method that has one String parameter named input.
     * This method returns a String that is the encrypted String decrypted
     * using the key1 and the key2 associated with this CaesarCipherTwo object.
     */
    
    public String decrypt(String encrypted)
    {
        
       CaesarCipherTwo cc = new CaesarCipherTwo(26 - mainKey1,26 - mainKey2);
       String decrypted = cc.encrypt(encrypted);
       return decrypted;
       
    }
    
}
