
/**
 * A description of CaesarCipher here.
 * Caesar Cipher in the same folder as Caesar Breaker.
 * @author (Aymar N.) 
 * @version (2023.03.01 V2)
 */


import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;


public class CaesarCipher {
    
   public String encrypt(String input, int key)
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
            if (idx !=-1) {
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
   
   
    public String encryptTwoKeys(String input, int key1, int key2) {
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
        
            if ((i %2 == 0) && (Character.isLowerCase(currChar))) {
            // Find the index of currChar in the alphabet (call it idx)
                int idx = alphabet.indexOf(currChar);
            // If currChar is in the alphabet
            if (idx!= 0) {
                // Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabet1.charAt(idx);
                // Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i,newChar);
            }
        }
        
            else if ((i %2 == 0) && (Character.isUpperCase(currChar))) {
                // Find the index of currChar in the alphabet (call it idx)
                int idx = Alphabet.indexOf(currChar);
                // If currChar is in the alphabet
            if (idx != 0) {
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
            if (idx != 0) {
                // Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabet2.charAt(idx);
                // Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i,newChar);
            }
        }
        
            else if ((i %2 != 0) && (Character.isUpperCase(currChar))) {
            // Find the index of currChar in the alphabet (call it idx)
            int idx = Alphabet.indexOf(currChar);
            // If currChar is in the alphabet
            if (idx != 0) {
                // Get the idxth character of shiftedAlphabet (newChar)
                char newChar = ShiftedAlphabet2.charAt(idx);
                // Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i,newChar);
            }
        }
                
    } 
    
    return encrypted.toString();
 
}


  public void CaesarCipher() {
    System.out.println(encrypt("FIRST LEGION ATTACK EAST FLANK!",23));

  } 
    
  public void encrypt() { 
      System.out.println(encrypt("First Legion",23)+"\n");
      System.out.println(encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?",15)+"\n");
  } 
    
  public void testCaesar() {
        
        //FileResource fr = new FileResource();
        try(BufferedReader inputFile = new BufferedReader(new FileReader("./data/Question 8"));)
        {
            int key = 23;
            String s = "";
            String message = "";
            String encrypted = "";
            while((s = inputFile.readLine())!= null){
                message += s;
            }
            
            encrypted = encrypt(message,key);
            System.out.println("Key is: "+ key+"\n"+encrypted);
            
        }
        catch(FileNotFoundException e){
            System.out.println("The data was not found");
        }
        catch(IOException e){
            e.printStackTrace();
        }
       
  }
    
    public void encryptTwoKeys() {
       
        
        try
        (BufferedReader fr = new BufferedReader(new FileReader("./data/Question 8"));)
        {
             int key = 14;
             int key2 = 24;
             String message = "";
             String c = "";
             String encrypted = "";
             while((c = fr.readLine())!= null)
             {
                 message += c;
             }
             encrypted = encryptTwoKeys(message,key,key2);
             System.out.println("Key1 is "+ key + " and Key2 is "+ key2 +"\n"+encrypted);
        }catch (FileNotFoundException e){
            e.getMessage();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        
        
    }

}
