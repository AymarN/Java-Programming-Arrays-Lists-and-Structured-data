import java.util.*;
import edu.duke.*;
import java.lang.*;
import java.io.*;
import java.nio.charset.StandardCharsets.*;
import java.nio.charset.Charset;

public class VigenereBreaker {
    public static String Source = "dictionaries";
    public HashMap<String,HashSet<String>> languages =
    new HashMap<String,HashSet<String>>();
    ArrayList<Integer> freqs = new ArrayList<Integer>();
    ArrayList<Character> chars = new ArrayList<Character>();
    
    public String sliceString(String message, int whichSlice, int totalSlices) {
        //String slicing = new String();
        StringBuilder slicing = new StringBuilder(message);
        String result = new String();
        for(int k = whichSlice;k<slicing.length();k+=totalSlices){
            result += slicing.charAt(k);
        }
        return result;
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        CaesarCracker CaesarCracker = new CaesarCracker('e');
        int aKey;
        int[] key = new int[klength];
        for(int k =0;k<klength;k++) {
           aKey = CaesarCracker.getKey(sliceString(encrypted,k,klength));
           key[k] = aKey;
           //k+=1;
        }
        return key;
    }
    
    public HashSet<String> readDictionary(FileResource fr) {
        HashSet<String> h = new HashSet<String>();
        for (String line : fr.lines()) {
                h.add(line.toLowerCase());// print or process s
         }
          
    return h;
    }
    
   public int countWords(String message, HashSet<String> dict) {
    int counts = 0; 
    ArrayList<String> MessageInWords = new ArrayList<String>(Arrays.asList(message.split("\\W")));
    for(int i = 0 ; i < MessageInWords.size(); i++ ) { 
        if (dict.contains(MessageInWords.get(i).toLowerCase())) {
                // If not put ip in with a value of 1
                counts+=1;
            } 
               }                                     
    return counts;                                     
    }
    
   public String breakForLanguage(String encrypted, HashSet<String> dict) {
        int max = 0;
        int keyReturn[] = new int[100];
        int KeyLength = 0;
        String aMessage = new String();
        String largestDecryption = new String();
        String[] decrypted = new String[100];
        for(int klength =1; klength < 100 ; klength++) {
            keyReturn = tryKeyLength(encrypted, klength, mostCommomCharIn(dict));
            VigenereCipher VCipher  = new VigenereCipher(keyReturn) ;
            aMessage = VCipher.decrypt(encrypted);
            //counts is a value returned, no use starting from 0
            int counts = countWords(aMessage, dict);
            if(counts > max){
                max = counts;
                largestDecryption = aMessage;
                KeyLength = klength;
            }  
        }
        
        System.out.println("Max counts: "+ max);        
        System.out.println("The proper Key Length is : "+ KeyLength);         
        return largestDecryption;
    }
    
   public char mostCommomCharIn(HashSet<String> dict) {  
    //count frequency of Letters in a dictionary
    freqs.clear();
    String  alph = "abcdefghijklmnñopqrstuvwxyz";
    int[] mycounts = new int[27];
    byte[] alphabet = alph.getBytes(Charset.forName("UTF-8"));
    //System.out.println(" bytesArray in String " + alphabet.toString());
    String alphabetUT8 = new String(alphabet, Charset.forName("UTF-8"));
    //System.out.println(" The alphabet in UTF8 " +alphabetUT8);
    for (String s : dict) {
         int Wordlength = s.length();
         for (int i=0; i<Wordlength; i++) {
             int dex = alphabetUT8.indexOf(Character.toLowerCase(s.charAt(i)));
             if (dex != -1) {
                 mycounts[dex] += 1; 
             }
         }
    }
    
   //Max
   int maxDex = 0;
   for(int k=0; k < mycounts.length; k++){
       if (mycounts[k] > mycounts[maxDex]) {
           maxDex = k;
            }
   }
   
   char mostCommon = alphabetUT8.charAt(maxDex);
   //System.out.println("max index "+ maxDex);
   System.out.println("most common char "+ mostCommon);
   return mostCommon;
   
  }

  public String breakForAllLangs(String encrypted, HashMap<String,HashSet<String>> MyMap) {
      String largestDecryption = new String(); 
      int max = 0 ;
      String identifyLanguage = new String();
      HashSet<String> h = new HashSet<String>();  
      for(String l : MyMap.keySet()) {
        HashSet<String> readingResult = MyMap.get(l);
        int counts = countWords(encrypted,readingResult);
         if(counts > max){
            max = counts;
            largestDecryption = breakForLanguage(encrypted, readingResult);
            identifyLanguage = l;
        }
        
      }
      System.out.println(" identified language " + identifyLanguage);
      return largestDecryption;   
  }
     
  public String breakVigenere() {
      String MaxDecryption = new String();
      //FileResource resource = new FileResource("ViginereMessages/athens_keyflute.txt");
      FileResource resource = new FileResource("messages/secretmessage4.txt");
      String message = resource.asString();
      HashSet<String> DictContent = new HashSet<String>();
      String [] labels = {"Danish","Dutch","English","French","German","Italian","Portuguese","Spanish"};
      for(String s : labels) {
          FileResource dictResource = new FileResource(Source+"/"+ s);
          DictContent = readDictionary(dictResource);
          languages.put(s,DictContent);
          System.out.println("language "+ s + "\t total words in dictionary "+ DictContent.size());
          mostCommomCharIn(DictContent);
          System.out.println(" MostCommonChar in "+ s + " "+mostCommomCharIn(DictContent));
      }
      MaxDecryption = breakForAllLangs(message, languages);
      return MaxDecryption; 
  }
    
}
