
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (Aymar N.) 
 * @version (03.02.2019 V2)
 */

import edu.duke.*;

public class CaesarCipher{
    
    private String Alphabet;
    private String ShiftedAlphabet;
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    
    
    //Constructor CaesarCipher
    
    public CaesarCipher(int key) {
        mainKey = key;
        Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        alphabet = Alphabet.toLowerCase();
        ShiftedAlphabet = alphabet.substring(key)+ alphabet.substring(0,key);
        shiftedAlphabet = alphabet.substring(key)+ alphabet.substring(0,key);
    
    }
    
    public String encrypt(String input) {
        // Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder (input);
        
        // Count from 0 to < length of encrypted,(call it i)
        for (int i = 0; i < encrypted.length();i++) {
        // Look at the ith character of encrypted ( call it currchar)
        char currChar = encrypted.charAt(i);
        if (Character.isLowerCase(currChar))
        {
        // Find the index of currChar in the alphabet (call it idx)
            int idx = alphabet.indexOf(currChar);
        // If currChar is in the alphabet
        if (idx !=-1) {
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
   
   
   public String decrypt(String input) {
       CaesarCipher cc = new CaesarCipher(26 - mainKey);
       String message = cc.encrypt(input);
       return message;
    }
}
