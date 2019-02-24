
/**
 * Write a description of WordPlay here.
 * You will write a program to transform words from a file into another form,
 *such as replacing vowels with an asterix.
 * 
 * @author (Aymar NAHUM) 
 * @version (a version number or a date)
 */
public class WordPlay {


    // Write a method isVowel that has one Char parameter named ch. This method returns
    //true if ch is a vowel and false otherwise.
    public boolean isVowel(char ch){
     if (ch == 'a' || ch =='e' || ch =='i' || ch =='o'|| ch =='u' || ch == 'y')   
         return true; 
     else if (ch == 'A' || ch =='E' || ch =='I' || ch =='O'|| ch =='U' || ch =='Y')
         return true;
     else
         return false;
            }

    /*        
    public boolean isVowelA(char ch){
     if (ch == 'a')   
         return true; 
     else if (ch == 'A')
         return true;
     else
         return false;
            }

    */
            
    /* Write a method replaceVowels that has two parameters, a String named phrase
    * and a char named ch. This method should return a String that is the String 
    * phrase with all vowels  replaced by ch 
    */
    public String replaceVowels(String phrase, char ch){
        StringBuilder original = new StringBuilder(phrase);
        //String replace = phrase;
        //char [] char2 = phrase.toCharArray();
        for (int i = 0; i < original.length();i++){
            //char currChar = original.charAt(i);
            char currChar = original.charAt(i);
            //int idx = phrase.indexOf(currChar);
            if (isVowel(currChar))
            {
                original.setCharAt(i, ch);   
            }
            
        
        }
        return original.toString();
    }

    /* Write a method emphasize with two parameters, a String named phrase and a
    * character named ch. This method return a String that is the String phrase
    * but with the Char ch
    */
    
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
