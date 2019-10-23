
/**
 * Write a description of WordPlay here.
 * 
 * @author (Aymar NAHUM) 
 * @version (V2 24.10.2019)
 */
public class WordPlay {

    public boolean isVowel(char ch) {
     if (ch == 'a' || ch =='e' || ch =='i' || ch =='o'|| ch =='u' || ch == 'y')   
         return true; 
     else if (ch == 'A' || ch =='E' || ch =='I' || ch =='O'|| ch =='U' || ch =='Y')
         return true;
     else
         return false;

    }
            
    public boolean isVowelA(char ch) {
     if (ch == 'a')   
         return true; 
     else if (ch == 'A')
         return true;
     else
         return false;

    }
    
    public String replaceVowels(String phrase, char ch) {

        StringBuilder original = new StringBuilder(phrase);
        //String replace = phrase;
        //char [] char2 = phrase.toCharArray();
        for (int i = 0; i < original.length();i++) {
            //char currChar = original.charAt(i);
            char currChar = original.charAt(i);
            //int idx = phrase.indexOf(currChar);
            if (isVowel(currChar))
            {
                original.setCharAt(i, ch);   
            }
            
           /*else {
                original.setCharAt(idx, currChar);
            }
           */ 
        }
        return original.toString();
    }
    
    public String emphasize(String phrase, char ch ){
        StringBuilder emphasize = new StringBuilder(phrase);
        // Look at the ith character of original
        for (int i = 0; i < emphasize.length();i++) {
        char currChar = emphasize.charAt(i);
        //int idx = phrase.indexOf(currChar);
        
        if ((currChar == ch) && (i %2 == 0))
        {
            emphasize.setCharAt(i, '*');
        }
        
        else if ((currChar == ch) && (i %2 != 0))
        {
            emphasize.setCharAt(i, '+');
        }
        
        /* else {
                emphasize.setCharAt(i, currChar);
            }
         */
        
                                                     }
        return emphasize.toString();
    }
    /* public void testreplaceVowels () {
        StringBuilder original = new StringBuilder("Hello World");
        StringBuilder result = replaceVowels (original,'*');
        System.out.println(result);
    }
    */
   
    public void WordPlay () {
        System.out.println("return value"+ " " + isVowel('F'));
        System.out.println("return value"+ " " + isVowel('a'));
        System.out.println("replace Vowels"+ " " + replaceVowels("Hello World",'*'));
        System.out.println("emphasize example1"+ " " + emphasize("dna ctgaaactga",'a'));
        System.out.println("emphasize example2"+ " " + emphasize("Mary Bella Abracadabra",'a'));
    }
    
}
