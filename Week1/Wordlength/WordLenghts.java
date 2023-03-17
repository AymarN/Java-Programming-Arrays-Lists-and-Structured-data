
/**
 * Figure out the most common word length of words from a file.
 *
 * @author (AymarN) 
 * @version (V2 03.2023)
 */
//import java.lang.*;
//import edu.duke.*;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class WordLenghts {
    
   
public int[] countWordLengths() { 
        int [] counts = new int[50];
        try(BufferedReader Resource = new BufferedReader(new FileReader("./data/smallHamlet.txt"));
        )
        {
             String s;
             while ((s = Resource.readLine())!= null){
             int Wordlength = s.length();
             for (int i=0; i<s.length();i++){
                char currChar = s.charAt(i);
                if ((i==0) || (i==s.length()-1)){
                    if (!Character.isLetter(currChar)) Wordlength--;
                }
             }  
             counts[Wordlength]++;   
             System.out.println(" Words of length "+ Wordlength +" "+ s);
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        
        return counts;
       
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
      //FileResource Resource = new FileResource("data/smallHamlet.txt");
      countWordLengths();     
      indexOfMax(countWordLengths());   
    }              
    
}   
                                                   
                                                     
                                                     
                                                     
                                                     
         
      
      
        

