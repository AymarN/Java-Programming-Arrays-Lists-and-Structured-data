
/**
 * A description of CaesarBreaker here.
 * You should start by writing the decryption method explained in the
 * lesson that decrypts a message that was encrypted with one Key, using 
 * statistical letter frequencies of English text. Then you will add code 
 * to be able to decrypt a message that was encrypted with two Keys, using
 * ideas from the Single key decryption method and the encryption with two
 * keys method from the program you wrote in the last course.
 * 
 * @author (Aymar N.) 
 * @version (13.03.2019)
 */

import edu.duke.*;
import java.io.*;
import java.lang.*;

public class CaesarBreaker {
    
    /*
     * Complete the decryption method shown in the lesson by creating a
     * CaesarBreaker class with the methods countLetters, maxIndex and 
     * decrypt.
     */
    public int[] CountLetters(String message)
    {
         String alph = "abcdefghijklmnopqrstuvwxyz";
         int[] counts = new int[26];
         for(int k=0; k < message.length();k++){
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alph.indexOf(ch);
            if(dex!=-1){
                counts[dex]++;
            }
            }
            return counts;
    }
    
    //maxIndex
    public int maxIndex(int[] values){
        
        int max = 0;
        int indexOfMax = 0;
        
        for(int k = 0;k<values.length;k++){
            
            if (values[k]> max){
            max = values[k];
            indexOfMax = k;
            }
        
        }
        //System.out.println("The Array maxIndex is :"+ indexOfMax);
        return indexOfMax; 
    }
    
    public String decrypt(String encrypted, int Key){
    
       CaesarCipher cc = new CaesarCipher();
       String decrypted = cc.encrypt(encrypted, 26 - Key);
       return decrypted;
    
    }
    
    /*
     * Write the method decryptTwoKeys in the CaesarBreaker class that has
     * one parameter, a String parameter named encrypted that represents a 
     * String that was encrypted with the two keys algorithm discussed.
     */
    
    public String decryptTwoKeys(String encrypted){
        
       CaesarCipher cc = new CaesarCipher();
       String message1 = halfOfString(encrypted,0);
       String message2 = halfOfString(encrypted,1);
       StringBuilder decrypt_two = new StringBuilder(encrypted);
       int key1= getKey(message1);
       int key2= getKey(message2);
       
       String encrypt_message1=cc.encrypt(message1,(26-key1));
       String encrypt_message2=cc.encrypt(message2,(26-key2));
       
       //build up the final answer
       
       for (int k=0; k<(message1.length());k++){
           decrypt_two.setCharAt((2*k), encrypt_message1.charAt(k) );
           }
           
       for (int k=0; k<(message2.length());k++){
           decrypt_two.setCharAt((2*k)+1, encrypt_message2.charAt(k) );
           }
           
       System.out.println("The first key is "+key1+"\n"+"The second Key is: "+ key2); 
       
       System.out.println("The message decrypted with two keys :"+"\n" + decrypt_two.toString());
        
       return decrypt_two.toString();    
    
    
    }
    
    /*
     * Write the method halOfString in the CaesarBreaker class that has 
     * two parameters, a String parameter named message and an int parameter
     * named start. This method should return a new String that is every other
     * character from message starting with the start position. For instance,
     * the call halfOfString("Qbkm Zgis",0) returns the String "Qk gs" and the 
     * call halfOfString("Qbkm Zgis",1) returns the String "bmZi".
     * Be sure to test this method with a small example.
     */
    
    public String halfOfString(String message, int start){
    
        String result = new String();
        
        for (int k = start; k< message.length();k = k+2)
        {
          result = result + message.charAt(k);
        }
        return result;
    }
    
    /*
     * Write the method getKey in the CaesarBreaker class that has one parameter,
     * a string s. This method should call countLetters to get an array of the 
     * letter frequencies in String s and then use maxIndex to calculate the 
     * index of the largest letter frequency, which is the location 
     * of the encrypted letter 'e', which leads to the key, which is returned.
     */
    public int getKey(String s){
       int[] freqs = CountLetters(s);
       int maxDex = maxIndex(freqs);
       int dKey = maxDex - 4;
       if (maxDex < 4){
        
           dKey = 26 - (4 -maxDex);
       }
       
       return dKey;
        
    }
    
    public void halfOfStringTest(){
        
       FileResource resource = new FileResource("data/wordsLotsOfEs.txt");
       String message = resource.asString();
       //System.out.println(message);
       System.out.println("half of String starts with 0"+ halfOfString(message, 0));
       System.out.println("half of String starts with 1"+ halfOfString(message, 1));
       
       CaesarCipher cc = new CaesarCipher();
       String encrypted = cc.encrypt(halfOfString(message, 0), 20);
       String decrypted = decrypt(encrypted,26 - 20);
       System.out.println(encrypted);
       System.out.println(decrypted);
    
    }
    
    /*
     * Write a testDecrypt method in the CaesarBreaker class that prints the
     * decrypted message, and make sure it works for encrypted messages
     * that were encrypted with one key.
     */
    
    public void testDecrypt(){
        int key = 23;
        FileResource fr = new FileResource("wordsLotsOfEs.txt");
        String message = fr.asString();
        CaesarCipher cc = new CaesarCipher();
        String decrypted = cc.encrypt(message, 26 - key);
        System.out.println("Key is"+ key+"\n"+decrypted);
    
    }
    
    public void decryptTwoKeysTest(){
        
       FileResource resource = new FileResource("data/Question 8");
       String message = resource.asString();
       
       //String message = "Akag tjw Xibhr awoa aoee xakex znxag xwko";
       String decrypted_message = decryptTwoKeys(message); 
       System.out.println(message);
       System.out.println(decrypted_message);
    }

}
