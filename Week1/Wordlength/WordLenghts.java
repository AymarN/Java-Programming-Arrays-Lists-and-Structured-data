
/**
 * Figure out the most common word length of words from a file.
 * 
 * @author (AymarN) 
 * @version (V2 03.2023)
 */
import java.lang.*;
import edu.duke.*;
public class WordLenghts {
    
   
public void countWordLengths(FileResource Resource, int[] counts) { 
  
        for (String word : Resource.words()){
            int Wordlength = word.length();
            for (int i=0; i<word.length();i++){
                char currChar = word.charAt(i);
                if ((i==0) || (i==word.length()-1)){
                    if (!Character.isLetter(currChar)) Wordlength--;
                }
            }  
            counts[Wordlength]++;   
            System.out.println(" Words of length "+ Wordlength +" "+ word);
        }
        
    }
   
 
public void indexOfMax(int[] values) {

        int max = 0;
        int position = 0;
            for (int i = 0; i <values.length;i++) 
              {
                  if (values[i] > max) 
                    {
                        max = values[i];
                        position = i;
                    } 
        }
        
      System.out.println("The most common word is :"+ position); 
        
    }
       
    
void testCountWordLengths(){
     FileResource Resource = new FileResource("data/smallHamlet.txt");
      int [] counts = new int[31];
      countWordLengths(Resource,counts);     
      indexOfMax(counts);    
      }              
    
    }   
                                                   
                                                     
                                                     
                                                     
                                                     
         
      
      
        

