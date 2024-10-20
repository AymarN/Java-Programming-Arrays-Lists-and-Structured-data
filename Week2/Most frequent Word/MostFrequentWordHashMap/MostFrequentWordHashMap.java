                                                                                                                                            
/**
 * Write a description of class MostFrequentWordHashMap.
 * 
 * 1. Generate an Hashmap of string and integers
 * 2. Generate an input of strings
 *  1.for items in the input
 *    a. if the hashmap does not contain the item
 *    b.add it and increment the value
 *    c. else
 *    d. increment the value
 *    
 *     @author (Aymar S. NAHUM)
 *     @version (10/20/2024)
 *
 */
import java.util.HashMap;
import java.util.ArrayList;

public class MostFrequentWordHashMap
{
    // instance variables - replace the example below with your own
    public static HashMap<String, Integer> uniqueMap  = new HashMap<String, Integer>();
    public static int maximum = 0;
    
    
    /**
     * Constructor for objects of class uniqueWordMap
     */
    public MostFrequentWordHashMap()
    {
        // initialise instance variables
        
    }

    /**
     * An example of a method - replace this comment with your own
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    
    // The dynamic compiler often increments the outcome
    // A solution is to generate a clear function
    // uniqueMap.clear()
    public static void  clearMap(ArrayList<String> input){
        
      
        for(int i = 0 ; i < input.size(); i = i + 1){
            uniqueMap.put( null, null);
        }
            
    } 
    
    public static HashMap<String, Integer> mapUniqueMethod(ArrayList<String> input)
    {
        
        //To avoid dynamic issues, clear the hashMap first.
        //Can't reproduce
        uniqueMap.remove(uniqueMap.get(null));
        for(int i = 0 ; i < input.size() ; i = i + 1)
        {
            if(!uniqueMap.containsKey(input.get(i))){
               uniqueMap.put(input.get(i), 1);
            }
            else 
            {
               uniqueMap.put(input.get(i), uniqueMap.get(input.get(i)) +1);
            }
        }
        
        /*
        for(int j : uniqueMap.values())
        {
            System.out.println(uniqueMap.get(j));
        }
        */
        System.out.println(uniqueMap.keySet());
        System.out.println(uniqueMap.values());
        return uniqueMap; 
    }
    
    public static int findMaxMethod(HashMap<String, Integer> map){
        //int indexMax = 0;
        for(String s : uniqueMap.keySet())
        {
            if(uniqueMap.get(s) > maximum){
               maximum = uniqueMap.get(s);
            }
            
            
        }
        
        System.out.println("The maximum is : " + maximum);
        return maximum; 
    }
}
