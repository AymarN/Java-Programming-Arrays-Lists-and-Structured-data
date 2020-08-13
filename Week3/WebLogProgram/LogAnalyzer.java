
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (Aymar N.) 
 * @version (25.07.2019)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     WebLogParser WebLogParser = new WebLogParser(); 
     
     public LogAnalyzer() {
         records = new ArrayList<LogEntry>();
     }
      
     //Complete the readFile method to create a FileResource and
     //iterate over all lines,create a LogEntry and store it in the 
     //records ArrayList.
     
     public void readFile(String filename) {
         FileResource resource = new FileResource();
          for(String line: resource.lines()){
              WebLogParser.parseEntry(line);
              records.add(WebLogParser.parseEntry(line));}                        
     }
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     
}
