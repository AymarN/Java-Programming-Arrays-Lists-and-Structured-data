
/**
 * CharactersInPlay Description.
 * The program determines the characters in one of 
 * Shakespeare's plays that have the most speaking parts.
 * Consider the play "The tragedy of Macabeth" in the file
 * macabethSmall.txt
 * 
 * @author (Aymar N) 
 * @version (05.03.2019 V2)
 */

import edu.duke.*;
import java.util.ArrayList;

public class CharactersInPlay {

    private ArrayList<String> character_name;
    private ArrayList<Integer> count;
    
    public CharactersInPlay() {
        character_name = new ArrayList<String>();
        count = new ArrayList<Integer>();
    }
    
    public void update(String person){
        
        //person = person.toLowerCase();
        int index = character_name.indexOf(person);
        if (index == -1) {
            character_name.add(person);
            count.add(1);
        }
        
        else {
                int freq = count.get(index);
                count.set(index,freq+1); 
        }
        
    }
    
    public void findAllCharacters() {
        character_name.clear();
        count.clear();
        
        FileResource Resource = new FileResource("macbethSmall.txt");
        
        for (String line: Resource.lines()){
            
           /* for(int i = 0; i < line.length();i++){
            // CurrentChar per line
            char currChar = line.charAt(i);
            // indexOf the CurrentChar
            int idx = line.indexOf(currChar);
            if(currChar == '.')
            {
              String possible_name = line.substring(0,idx);
              //System.out.println("***"+ possible_name+ "***");
              
              update(possible_name); 
            }
            */
           if (line.contains(".")) {
               
               int idx = line.indexOf(".");
               String possible_name = line.substring(0,idx);
               update(possible_name);
            
            }
            
            
           }
                                              
        }
            
    
   
    public void tester() {
        findAllCharacters();
        
        for (int k =0; k < count.size();k++) {
           
            if (count.get(k) > 1) {
            
             System.out.println("The main character is: "+ character_name.get(k) +"\t"
             +"The number of speaking parts is: "+ count.get(k));
             
            }
            
        }
            
       int num1 = 2;
       int num2 = 3;
       charactersWithNumParts(num1, num2);
    
    }
    
    public void charactersWithNumParts(int num1, int num2) {
        
        for (int k =0; k < count.size();k++) {
           
            if (count.get(k) >= num1 && count.get(k)<= num2) {
            
                System.out.println("The main character between : " + num1 + " and " + num2 
                + " is " + character_name.get(k) +"\t"
                +"The number of speaking parts is: "+ count.get(k));
             
            }
            
        }
    
    }
    
    
}
