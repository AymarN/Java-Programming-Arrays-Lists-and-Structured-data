
/**
 * Write a description of class testUniqueWordMap here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;

public class MostFrequentWordHashMapTest
{
    // instance variables - replace the example below with your own
    public static ArrayList<String> in = new ArrayList<String>();

    /**
     * Constructor for objects of class testUniqueWordMap
     */
    public MostFrequentWordHashMapTest()
    {
        // initialise instance variables
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static void testUniqueHashMethod()
    {
        // put your code here
    
        in.add("Let");
        in.add("us");
        in.add("praise");
        in.add("The");
        in.add("Lord");
        in.add("Let");
        in.add("us");
        in.add("bow");
        in.add("down");
        in.add("unto");
        in.add("The");
        in.add("Lord");
        
        MostFrequentWordHashMap MostFrequentWordHashMap = new MostFrequentWordHashMap();
        //MostFrequentWordHashMap.mapUniqueMethod(in);
        MostFrequentWordHashMap.findMaxMethod(MostFrequentWordHashMap.mapUniqueMethod(in));
    }
}
