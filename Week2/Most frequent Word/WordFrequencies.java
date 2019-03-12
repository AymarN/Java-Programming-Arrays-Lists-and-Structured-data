
/**
 *  A description of WordFrequencies here.
 *  Determine the word that occurs the most often in a file.
 *  If more than one word occurs as the most often, then return 
 *  the first such word found. You will make all words lowercase 
 *  before counting them. 
 * @author (Aymar N) 
 * @version (01.03.2019)
 */
import edu.duke.*;
import java.util.ArrayList;

public class WordFrequencies {
    
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
      public WordFrequencies(){
          myWords = new ArrayList<String>();
          myFreqs = new ArrayList<Integer>();
        }
      
    /*
     * Write a void method findUnique that has no parameters.This method
     * should first clear both myWords and myFreqs,using .clear() method
     * Then it selects a file and then iterates over every word in the file,
     * putting the unique words found into myWords. For each word in the Kth
     * position of myFreqs.
     */    
        
    public void findUnique(){
        myWords.clear();
        myFreqs.clear();
        FileResource Resource = new FileResource("testwordfreqs.txt");
        for(String s: Resource.words()){
            s = s.toLowerCase();
            int index = myWords.indexOf(s);
            if(index == -1){
                myWords.add(s);
                myFreqs.add(1);
            }
            else {
                int freq = myFreqs.get(index);
                myFreqs.set(index,freq+1); 
            }
        }
    }
    
    /*
     * Write a void tester method that has no parameters.This method should 
     * call findUnique. Then print out the number of unique words, and for
     * each unique word, print the frequency of each word and the word
     */
    
    public void tester(){
        findUnique();
        System.out.println("# unique words: "+myWords.size());
        
        for ( int k =0; k < myWords.size();k++){
            System.out.println(myFreqs.get(k)+"\t"+ myWords.get(k));
        }
        int index = findIndexOfMax();
        System.out.println("max word/freq: " +myWords.get(index)+" "+
        myFreqs.get(index));
        
        
    }
    
    /*
     * Write the method findIndexOfMax that has no parameters.
     * This method returns an int that is the index location of the 
     * largest value in myFreqs.If there is a tie, then return the 
     * first such value.
     */ 
    
    
    public int findIndexOfMax(){
        int max = myFreqs.get(0);
        int maxIndex = 0;
        for(int k=0; k < myFreqs.size(); k++){
            if (myFreqs.get(k) >max){
                max = myFreqs.get(k);
                maxIndex = k;
            }
            
        }
        return maxIndex;
        }

}
