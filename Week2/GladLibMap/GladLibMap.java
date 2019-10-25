
/**
 * Write a description of GladLibMap here.
 * 
 * @author (Aymar NAHUM) 
 * @version (12.04.2019 V2)
 */

import edu.duke.*;
import java.util.*;

public class GladLibMap {
    
    //private ArrayList<String> adjectiveList;
    //private ArrayList<String> nounList;
    //private ArrayList<String> colorList;
    //private ArrayList<String> countryList;
    //private ArrayList<String> nameList;
    //private ArrayList<String> animalList;
    //private ArrayList<String> timeList;
    //private ArrayList<String> verbList;
    //private ArrayList<String> fruitList;
    private ArrayList<String> wordSeen;
    private int wordSeenCount = 0;
    private HashMap<String,ArrayList<String>> myMap = new HashMap<String, ArrayList<String>>();
    private Random myRandom;
    private ArrayList<String> usedCategories;
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "datalong";
    
    public GladLibMap() {
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
        wordSeen = new ArrayList<String>();
        usedCategories = new ArrayList<String>();
    }
    
    public GladLibMap(String source) {
        initializeFromSource(source);
        // create a random number generator
        wordSeen = new ArrayList<String>();
        myRandom = new Random();
        usedCategories = new ArrayList<String>();
    }
    
    private void initializeFromSource(String source) {
        
        // adjectiveList= readIt(source+"/adjective.txt"); 
        // nounList = readIt(source+"/noun.txt");
        // colorList = readIt(source+"/color.txt");
        // countryList = readIt(source+"/country.txt");
        // nameList = readIt(source+"/name.txt");      
        // animalList = readIt(source+"/animal.txt");
        // timeList = readIt(source+"/timeframe.txt");
        // verbList = readIt(source+"/verb.txt");
        // fruitList = readIt(source+"/fruit.txt");
        String[] labels = {"adjective","animal","color","country","fruit","name","noun","timeframe","verb"};
        for(String s : labels){
            ArrayList<String> list = readIt(source+"/"+s+".txt");
            myMap.put(s, list);
           // System.out.println("HashMap values"+myMap.get(s));
        }
    }
    
    
    private String randomFrom(ArrayList<String> Source) {
          int index = myRandom.nextInt(Source.size());
          return Source.get(index);
        
    }
    
    
    // take a string label and replace it with a random string
    // in the ArrayList
    
    private String getSubstitute(String label) {
        
        /* 
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
        */
        if (label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
        }
        addUsedCategory(label);
        return randomFrom(myMap.get(label));
    }
    
    private void addUsedCategory(String label) {
       if (usedCategories.indexOf(label) == -1){
           usedCategories.add(label);
        }
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
              
    private int totalWordsInMap() {
       int sum = 0;      
       for (String category : myMap.keySet()) {
           ArrayList<String> words = myMap.get(category);
           System.out.println("Category:" +category+ "\tTotal words in category:"
            + words.size());
           sum += words.size();
        }
       System.out.println("Lists size: "+sum);
       return sum;
       
    }
    
  
    private int totalWordsConsidered() {
        ArrayList<String> content = new ArrayList<String>();
        int sum = 0;
        System.out.println("\nCategories used in this story:");
        for (int index = 0; index < usedCategories.size(); index++) {
            String category = usedCategories.get(index);
            content = myMap.get(category);
            System.out.println("Category: " + category + "\tWords in category: "
                    + content.size());
            sum += content.size();
        }
        System.out.println("sum of possible words: " + sum);
        return sum;
    }
    
    private void printOut(String s, int lineWidth) {
        int charsWritten = 0;
        for(String w : s.split("\\s+")) {
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
            for(String word : resource.words()) {
                story = story + processWord(word) + " ";
            }
        }
        System.out.println("Total numbers of words replaced "+ wordSeenCount);
        return story;
    }
    
    private ArrayList<String> readIt(String source) {
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()) {
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()) {
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
        System.out.println("\n");
        System.out.println(totalWordsInMap());
        System.out.println("\n"+totalWordsConsidered());
    }

}
