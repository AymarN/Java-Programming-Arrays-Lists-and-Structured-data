
/**
 * Write a description of TestCaesarCipher here.
 * 
 * @author (Aymar N.) 
 * @version (03.02.2019)
 */
import edu.duke.*;

public class TestCaesarCipher {
    
/*
 * Write the void method simpleTests that has no parameters.This method should
 * read in a file as a string, create a CaesarCipher object with key 18, 
 * encrypt the String read in using the CaesarCipher object, print the encrypted
 * String, and decrypt the encrypted String using the decrypt method
 */    
    
public void simpleTests(){
      FileResource fr = new FileResource();
      String message = fr.asString();
      CaesarCipher cc = new CaesarCipher(18);
      String encrypted = cc.encrypt(message);
      System.out.println("The encryption result is "+ encrypted);
      String decrypted = cc.decrypt(encrypted);
      System.out.println("The decryption outcome is "+ decrypted);
      String breakCaesarCipher = breakCaesarCipher(encrypted);
      System.out.println("The decryption outcome is "+ breakCaesarCipher);
     }
     
/*
 * Write the method breakCaesarCipher that has one String parameter named input.
 * This method should figure out which key was used to encrypt this message
 * then create a CaesarCipher object with that key and decrypt the message
 * In the simpleTests method, add a call to breakCaesarCipher on the encrypted
 * String to decrypt it automatically by determining the Key, and print the 
 * decrypted String.
 */     
     
public String breakCaesarCipher(String input){
    
    int [] freqs = countLetters(input);
    int maxDex = maxIndex(freqs);
    int dkey = maxDex - 4;
    if (dkey < 0)
    { dkey = 26 - (4 - maxDex);}
    CaesarCipher cc = new CaesarCipher(dkey);
    //return dkey;
    String message = cc.decrypt(input);
    return message;
}
       
private int maxIndex(int[] values){
       int max = 0;
       int position = 0;
       //int maxDex = 0;
        for (int i = 0; i <values.length;i++) 
        {
            if (values[i] > max) 
            {
                max = values[i];
                position = i;
                //maxDex = i;
            }
            
        } 
        System.out.println("Index position of Maximum value in an array is :"+ position); 
        return position;  
       }

private int[] countLetters(String message) {
        
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for (int k = 0; k < message.length();k++){
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alph.indexOf(ch);
            if(dex!=-1){
                counts[dex]+=1;
            }
        }
        return counts;
    }
      
}
