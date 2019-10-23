
/**
 * Write a description of TestCaesarCipherTwo here.
 * 
 * Create the TestCaeasarCipherTwo class with the following parts
 * Include halfOfString, CountLetters and maxIndex
 * 
 * @author (Aymar NAHUM) 
 * @version (16.02.2019 V2)
 */
import edu.duke.*;

public class TestCaesarCipherTwo {
    
    
    public void simpleTests() {
    FileResource fr = new FileResource();
    String message = fr.asString();
    /*CaesarCipherTwo cc2 = new CaesarCipherTwo(21,8);
    String encrypted = cc2.encrypt(message);
    System.out.println("The encryption result is "+ encrypted);
    String decrypted = cc2.decrypt(encrypted);
    System.out.println("The decryption outcome is "+ decrypted);*/
    String breakCaesarCipher = breakCaesarCipher(message);
    System.out.println("The decryption is "+ breakCaesarCipher);
    }
    
    private String halfOfString(String my_message,int start) { 
        String result = new String(); 
        for (int i = start; i < my_message.length(); i = i+2) {
           result = result + my_message.charAt(i);
        }
    
    return result; 
    }
    
    private int[] countLetters(String message) {
       String alph = "abcdefghijklmnopqrstuvwxyz";
         int[] counts = new int[26];
         for(int k=0; k < message.length();k++) {
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alph.indexOf(ch);
            if(dex!=-1){
                counts[dex]++;
            }
         }
            return counts;
    }
    
    private int getKey(String s) {
       int[] freqs = countLetters(s);
       int maxDex = maxIndex(freqs);
       int dKey = maxDex - 4;
       if (maxDex < 4) {
           dKey = 26 - (4 -maxDex);
       }
       
       return dKey;
    }
    
   
   private int maxIndex(int[] values) {
        int max = 0;
        int indexOfMax = 0;
        for(int k = 0;k<values.length;k++) {
            if (values[k]> max){
            max = values[k];
            indexOfMax = k;
            }
        
        }
        //System.out.println("The Array maxIndex is :"+ indexOfMax);
        return indexOfMax; 
        
    }
        
    private String breakCaesarCipher(String input) {
       
       String message1 = halfOfString(input,0);
       String message2 = halfOfString(input,1);
       //StringBuilder decryption = new StringBuilder(input);
       
       int key1= getKey(message1);
       int key2= getKey(message2);
      
       CaesarCipherTwo cc3 = new CaesarCipherTwo(key1,key2);
       
       //String decrypt_1=cc1.decrypt(message1);
       //String decrypt_2=cc2.decrypt(message2);
       
       String decryption = cc3.decrypt(input);
       
       //build up the final answer
       /*for (int k=0; k<(message1.length());k++){
           decryption.setCharAt((2*k), decrypt_1.charAt(k) );
           }
           
       for (int k=0; k<(message2.length());k++){
           decryption.setCharAt((2*k)+1, decrypt_2.charAt(k) );
           }
              
       System.out.println("The first key is "+key1+"\n"+"The second Key is: "+ key2); 
       System.out.println("The message decrypted with two keys :"+"\n" + decryption.toString());
       return decryption.toString();  
       */
       
       return decryption;
    }

}
