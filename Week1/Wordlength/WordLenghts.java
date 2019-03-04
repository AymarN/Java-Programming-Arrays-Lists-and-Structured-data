
/**
 * Figure out the most common word length of words from a file.
 * 
 * @author (Aymar N.) 
 * @version (28.02.19)
 */
import java.lang.*;
import edu.duke.*;

public class WordLenghts {
    
    /*Write a void method countWordLengths that has two parameters, a FileResource 
    *named resource and an integer array named counts. This method should read in the
    * words from resource and count the number of words of each length for all the 
    * words in resource, storing these counts in the array counts.
    */
   
   
    public void countWordLengths(FileResource Resource, int[] counts){ 
        
        for(String word : Resource.words()){
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
   
    /*
     * Write an indexOfMax that has one parameter named values that is an integer
     * array.This method returns the index position of the largest element in values.
     */
   
    public void indexOfMax(int[] values){

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
                                                   
                                                     
                                                     
                                                     
                                                     
         
      
      
        

