
/**
 *  A description of WordsinFiles here.
 *  Create a map of words to the names of files they are in.
 *  That is, you will map a String to an ArrayList of Strings.
 *  Then you can determine which ArrayList value is the largest
 *  (has the most filenames) and its Key is thus, a word that is
 *  in the most number of files.
 * 
 * @author (Aymar N.) 
 * @version (29.03.2019)
 */
import edu.duke.*;
import java.util.*;
import java.lang.*;
import java.io.*;

public class WordsinFiles {
    
    private HashMap<String,ArrayList<String>> word_filename;
    //private FileResource fr = new FileResource();
    //private ArrayList<String> myWords; 
   
    public WordsinFiles(){
     word_filename = new HashMap<String, ArrayList<String>>();
     //myWords = new ArrayList<String>();
    }
    
    
    /*
     * Write a private void method named addWordsFromFile that has one
     * parameter f of type File.This method should add all the words from
     * f into the map.If a word is not in the map, then you must create
     * a new ArrayList of type String with this word, and have the word map
     * to this ArrayList.If a word is already in the map, then add the current
     * filename to its ArrayList, unless the filename is already in the 
     * ArrayList. You can use the File method getName to get the filename of 
     * a file
     */
    
    private void addWordsFromFile(File f){
        FileResource fileResource = new FileResource(f);
        String name = f.getName();
        //ArrayList<String> myWords = new ArrayList<String>();
        
        for(String word:fileResource.words()){
            word = word.toLowerCase();
            if(!word_filename.containsKey(word)){     
                ArrayList<String> newArrayList = new ArrayList<String>();
                newArrayList.add(name);
                // For each word there is an ArrayList which contains files
                //where the word is. 
                word_filename.put(word, newArrayList);
            }
                    
            else if (word_filename.containsKey(word) && 
                !word_filename.get(word).contains(name)) {
                // Add another file to the ArrayList when the word already exists.   
                ArrayList<String> currentFileNameList = word_filename.get(word);
                currentFileNameList.add(name);
                word_filename.put(word, currentFileNameList);
                 }                                   
                  }
                                                
            }
                                                   
                                                      
    /*
     * Write a void method named buildWordFileMap that has no parameters.
     * This method first clears the map, and then uses a DirectoryResource
     * to select a group of files.Foir each file,it puts all of its words
     * the map by calling the method addWordsFromFile. The remaining methods
     * to write all assume that the HashMap has been built.
     */
    
    public void buildWordFileMap(){
        word_filename.clear(); 
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()){
            addWordsFromFile(f);
        }
    }
    
    /*
     * Write the method maxNumber that has no parameters.This method returns 
     * the maximum number of files any word appears in, considering all words
     * from a group of files.In the example above, there are four files 
     * considered. No word appears in all four files.Two words appear in three
     * of the files, so maxNumber on those four files would return 3. 
     * This method assumes that the HashMap has already been constructed.
     */
    public int maxNumber(){        
       // The hasMap has been built
       int max = 0;
       for(String word:word_filename.keySet()){
            ArrayList<String> currentFileList = word_filename.get(word);
            int currentNum = currentFileList.size();
            if (currentNum > max) {
                max = currentNum;
            }
        }
        return max;
    }
    
    /*
     * Write the method WordInNumFiles that has one integer parameter 
     * called number.This method returns an ArrayList of words that appear
     * in exactly number files. In the example,the call of wordsInNumFiles(3)
     * would return an ArrayList with the words "cats" and "and", and the call
     * wordsInNumFiles(2) wpuld return an ArrayList with the words "love",
     * "are" and "dogs", all the words that appear in exactly two files
     */
    
    private ArrayList<String> wordsInNumFiles(int number){
        // Same idea than maxNumber()
        ArrayList<String> ReturnList = new ArrayList<String>();
        for(String word:word_filename.keySet()){
            ArrayList<String> currentFileList = word_filename.get(word);
            int currentNum = currentFileList.size();
            if (currentNum == number) {
                ReturnList.add(word);
            }
        
        }
        return ReturnList;
    
    }
    
    /*
     * Write the void method printFilesIn that has one String parameter named
     * word.This method prints the names of the files this word appears in,one
     * filename per line. For example, in the example above, the call
     * printFilesIn("cats") would print the three filenames: brief1.txt, 
     * brief3.txt and brief4.txt, each on a separate line.
     */
    
    private void printFilesIn(String word){
        ArrayList<String> fileNames = word_filename.get(word);
        for (int index = 0; index < fileNames.size(); index++) {
            System.out.println(fileNames.get(index));
        }
    
  }
    
  public void test(){  
    buildWordFileMap();
    int maximum = maxNumber();
    //ArrayList<String> TestList = wordsInNumFiles(maximum);
    ArrayList<String> TestList = wordsInNumFiles(4);
    System.out.println("The maximum number of files word is in: "+maximum +" and there are "+TestList.size());
    for (int k =0;k< TestList.size(); k++)
    {
      System.out.println("All the words in the files "+TestList.get(k)+"");
    }
    System.out.println("\t");
    
    for (int k =0;k <TestList.size();k++){
        System.out.println("Filenames where the words are ");
        printFilesIn(TestList.get(k));
    }
    //System.out.println("\n");
    //printFilesIn("word");
    }
    
  }
