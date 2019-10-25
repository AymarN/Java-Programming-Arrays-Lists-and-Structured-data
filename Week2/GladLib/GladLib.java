import edu.duke.*;
import java.util.*;

public class GladLib {
    private ArrayList<String> adjectiveList;
    private ArrayList<String> nounList;
    private ArrayList<String> colorList;
    private ArrayList<String> countryList;
    private ArrayList<String> nameList;
    private ArrayList<String> animalList;
    private ArrayList<String> timeList;
    private ArrayList<String> verbList;
    private ArrayList<String> fruitList;
    private ArrayList<String> wordSeen;
    private int wordSeenCount = 0;
    
    private Random myRandom;
    
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "datalong";
    
    public GladLib() {
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
        wordSeen = new ArrayList<String>();
    }
    
    public GladLib(String source) {
        initializeFromSource(source);
        // create a random number generator
        myRandom = new Random();
    }
    
    private void initializeFromSource(String source) {
        adjectiveList= readIt(source+"/adjective.txt"); 
        nounList = readIt(source+"/noun.txt");
        colorList = readIt(source+"/color.txt");
        countryList = readIt(source+"/country.txt");
        nameList = readIt(source+"/name.txt");      
        animalList = readIt(source+"/animal.txt");
        timeList = readIt(source+"/timeframe.txt");
        verbList = readIt(source+"/verb.txt");
        fruitList = readIt(source+"/fruit.txt");
    }
    
    private String randomFrom(ArrayList<String> source) {
            //return the next integer random value from
            //the random number generator.
            //source.size() number of elements in ArrayList.
          int index = myRandom.nextInt(source.size());
          return source.get(index);
        
    }
    
    
    // take a string label and replace it with a random string
    // in the ArrayList
    
    private String getSubstitute(String label) {
        if (label.equals("country")) {
            return randomFrom(countryList);
        }
        if (label.equals("color")){
            return randomFrom(colorList);
        }
        if (label.equals("noun")){
            return randomFrom(nounList);
        }
        if (label.equals("name")){
            return randomFrom(nameList);
        }
        if (label.equals("adjective")){
            return randomFrom(adjectiveList);
        }
        if (label.equals("animal")){
            return randomFrom(animalList);
        }
        if (label.equals("timeframe")){
            return randomFrom(timeList);
        }
            if (label.equals("verb")){
            return randomFrom(verbList);
        }
        if (label.equals("fruit")){
            return randomFrom(fruitList);
        }
        
        if (label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
        }
        return "**UNKNOWN**";
    }
    
    private String processWord(String w) {
            // indexOf first occurence of <
        int first = w.indexOf("<");
        // starting from first, returns the first occurence of >
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        // before <
        String prefix = w.substring(0,first);
        // after >
        String suffix = w.substring(last+1);
        // inside <>
        
        //********************* don't go that way *********************
        //Sub = getSubstitute(w.substring(first+1,last));
        
        //String sub = w.substring(first+1,last);
        //wordSeen.add(sub);
        //wordSeenCount.add(1);
        
 
        /* for(int k =0; k < wordSeen.size();k++)
        {
        if (wordSeen.get(k).contains(sub))
         {  sub = getSubstitute(w.substring(first+1,last));  
            }
          } */
          
       //**************************************************************   
          
          
       //********************** An answer ******************************
        /* while(true){
            sub = getSubstitute(w.substring(first+1,last));
            int findIndex = wordSeen.indexOf(sub);
           
            if(findIndex == -1){
             wordSeen.add(sub);
             wordSeenCount++;
             //return randWord;
             break;
            }
        } 
       */
      
       //***************************************************************    
             
        String sub;
        
        while(true){
            sub = getSubstitute(w.substring(first+1,last));
            int findIndex = wordSeen.indexOf(sub);
           
            if(!wordSeen.contains(sub)){
             wordSeen.add(sub);
             wordSeenCount+=1;
             break;
            }
        } 
        
        return prefix+sub+suffix;
     } 
          
    
    
    private void printOut(String s, int lineWidth) {
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }
    
    private String fromTemplate(String source) {
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        System.out.println("Total numbers of words replaced"+ wordSeenCount);
        return story;
    }
    
    private ArrayList<String> readIt(String source) {
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }
    
    public void makeStory() {
        wordSeen.clear();
        System.out.println("\n");
        //String story = fromTemplate("data/madtemplate.txt");
        String story = fromTemplate("data/madtemplate2.txt");
        printOut(story, 60);
        wordSeenCount = 0;
    }
    
}
