
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
    
      public WordFrequencies() {
          myWords = new ArrayList<String>();
          myFreqs = new ArrayList<Integer>();
        }
         
    public void findUnique() { 
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
    
    
    public void tester() {
        findUnique();
        System.out.println("# unique words: "+myWords.size());
        
        for ( int k =0; k < myWords.size();k++){
            System.out.println(myFreqs.get(k)+"\t"+ myWords.get(k));
        }
        int index = findIndexOfMax();
        System.out.println("max word/freq: " +myWords.get(index)+" "+
        myFreqs.get(index));
        
        
    }
     
    public int findIndexOfMax() {
        int max = myFreqs.get(0);
        int maxIndex = 0;
        for(int k=0; k < myFreqs.size(); k++) {
            if (myFreqs.get(k) >max) {
                max = myFreqs.get(k);
                maxIndex = k;
            }
            
        }
        return maxIndex;
        }

}
