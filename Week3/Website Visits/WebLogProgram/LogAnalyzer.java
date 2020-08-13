
/**
 * Website Visits
 * In this assignement you will continue to build on the LogEntry and LogAnalyser classes
 * that you worked on inth last lesson.You will continue to use the method parseEntry from
 * the WebLogParser class, and you should not modify this class.You will write several
 * methods to solve problems about web logs.
 * @author (Aymar N.) 
 * @version (02.08.2019)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     private ArrayList<String> maxDate;
     private ArrayList<String> maxIPs;
     private ArrayList<Integer> myFreqs;
     WebLogParser WebLogParser = new WebLogParser(); 
     
     public LogAnalyzer() {
         records = new ArrayList<LogEntry>();
         maxDate = new ArrayList<String>();
         maxIPs = new ArrayList<String>();
         myFreqs = new ArrayList<Integer>();
     }
      
     //Complete the readFile method to create a FileResource and
     //iterate over all lines,create a LogEntry and store it in the 
     //records ArrayList.
     public void readFile(String filename) {
         FileResource resource = new FileResource();
          for(String line: resource.lines()){
              WebLogParser.parseEntry(line);
              records.add(WebLogParser.parseEntry(line));
          }                        
     }
     
     public int countUniqueIPs() {
        // uniqueIPs starts as an empty list
        ArrayList<String> uniqueIPs = new ArrayList<String>();
        // for each element le in records
        for (LogEntry le: records) {
        // ipAddr is le's ipAddress
        String ipAddr = le.getIpAddress();
        //if ipAddr is not in uniqueIPs
            if(!uniqueIPs.contains(ipAddr)) {
                //add ipAddr to uniqueIps
                uniqueIPs.add(ipAddr);
            }
        }
        // return the size of UniqueIPs
        return uniqueIPs.size();
     }
        
     public void printAllHigherThanNum(int Num) { 
         
        for(LogEntry le: records) {
        // Status code in LogEntrys
        int statusCode = le.getStatusCode();
        //if StatusCode greater than Num
            if(statusCode > Num) {
                //print StatusCode
                System.out.println("StatusCode greater than "+Num+": "+statusCode);
            }
        }
           
     }   
     
     //This method accesses the web logs in records and returns an ArrayList
     //of Strings of unique IP addresses that had access on the given day.
     
     public ArrayList<String> uniqueIPVisitsOnDay(String someday){
         ArrayList<String> myIPs = new ArrayList<String>();
         String myString = null;
         for(LogEntry le: records) {
             Date d = le.getAccessTime();
             String ipAddr = le.getIpAddress();
             myString = d.toString();
             int index = myIPs.indexOf(ipAddr);
             if((myString.contains(someday)) && (!myIPs.contains(ipAddr))){
                   myIPs.add(ipAddr);
                   myFreqs.add(1);
             }
         
         for (int k =0; k < myIPs.size();k++) {
             System.out.println(myIPs.get(k)+"\t"); 
         }
         
         System.out.println("Array size: "+myIPs.size());   
        }
        return myIPs; 
     } 
     
     public int countUniqueIPsInRange(int low, int high){
        // uniqueIPs starts as an empty list
        ArrayList<String> uniqueIPs = new ArrayList<String>();
        for(LogEntry New: records) {
        // Status code in LogEntrys
        int statusCode = New.getStatusCode();
        String ipAddr = New.getIpAddress();
        //if StatusCode greater than Num
            if((statusCode >= low) && (statusCode <= high)) {
                if(!uniqueIPs.contains(ipAddr)) {
                //add ipAddr to uniqueIps
                uniqueIPs.add(ipAddr);
                }
            }
        }
        return uniqueIPs.size();
     }
     
     public HashMap<String,Integer> countVisitsPerIP() {
        // Make an empty HashMap<String,Integer> counts
        HashMap<String,Integer> counts = new HashMap<String, Integer>();
        // For each le in records
        for (LogEntry le: records) {
        //ip is le's ipAddress
            String ip = le.getIpAddress();
        //Check if ip is in counts
            if (!counts.containsKey(ip)) {
                // If not put ip in with a value of 1
                counts.put(ip,1);
            }
             // If so; update the value to be 1 more
            else {
                 counts.put(ip,counts.get(ip) + 1);
            }
       }
       //counts is the answer
       return counts;
     }
     
     //In the Log Analyser class, write the method iPsMostVisits which has one
     //parameter , a HashMap<String,Integer> that maps an IP address to the number of
     // times that IP address appears in the web log file. This method returns an 
     // ArrayList of Strings of IP addresses that all have the maximum number of visits
     // to this website. For example, the call iPsMostVisits on a HashMap formed using
     // the file weblog3-short_log returns the ArrayList with these two IP addresses,
     //61.15.121.171 and 84.133.195.161. Both of them visited the site three times, which
     //is the maximum number of times any IP address visited the site.
     
    public ArrayList<String> iPsMostVisits(HashMap<String,Integer> addressNumberTime){   
    ArrayList<String> maxIps = new ArrayList<String>();    
    int greatest;
    greatest = mostNumberVisitsByIP(addressNumberTime);
    for (String s: addressNumberTime.keySet()) {
            if (addressNumberTime.get(s) == greatest) {
                maxIps.add(s);
            }
    }
    
    return maxIps;
    }
    
     //In the LogAnalyser class, write the method iPsForDays which has no parameters. This
     // method returns a HashMap<String, ArrayList<String>> that uses records and maps days
     // from web logs to an ArrayList of IP addresses that occured on that day.A day is in 
     //format "MMM DD" where MMM is the first three characters on the month name with the 
     // first letter capital and the others in lowercase, and DD is the day in two digits.
     // For example, for the file weblog3-short_log, after building this HashMap, if you 
     // print it out, you will see that Sep 14 maps to one IP address, Sep 21 maps to four
     //IP addresses and Sep 30 maps to five IP addresses.
     
     public HashMap<String,ArrayList<String>> iPsForDays(){
     HashMap<String,ArrayList<String>> dayIpThatDay = new HashMap<String,ArrayList<String>>();
     ArrayList<String> myIPs = new ArrayList<String>();
     String myString = null;
         for (LogEntry le: records) {
             Date d = le.getAccessTime();
             String ipAddr = le.getIpAddress();
             myString = d.toString();
             myIPs = uniqueIPVisitsOnDay(myString);
             dayIpThatDay.put(myString,myIPs);  
         }
     return dayIpThatDay;
    }
    
    public int findMax(){
    int theMax = myFreqs.get(0);
    int maxIndex = 0;
    for(int k=0; k < myFreqs.size(); k++){
        if (myFreqs.get(k) > theMax){
          theMax = myFreqs.get(k);
          maxIndex = k;
        }
    }
    return maxIndex;
    }
   
    public String dayWithMostIPVisits(HashMap<String,ArrayList<String>> dayIPs){
      String date;  
      String maxKey_date= null;
      for (String s : dayIPs.keySet()) {
          int index = maxDate.indexOf(s);
          if (index == -1) {
             maxDate.add(s);
             myFreqs.add(1);
          }
          else {
              int freq = myFreqs.get(index);
              myFreqs.set(index,freq+1);
               }
       }
       
       int max = findMax();
       System.out.println("max Date: "+ maxDate.get(max)+" max Freq: "+ myFreqs.get(max));
       //myFreqs.clear();
       return maxDate.get(max);
    }
    
    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String,ArrayList<String>> dayandIPs, String aDay){
        myFreqs.clear();
        ArrayList<String> mostIPs = new ArrayList<String>();
        mostIPs = uniqueIPVisitsOnDay(aDay);
        HashMap<String,Integer> counts = new HashMap<String,Integer>();      
        
        for (int k=0;k<mostIPs.size();k++) {
          String s = mostIPs.get(k) ; 
          if (!counts.containsKey(s)) {
                 counts.put(s,1);
             }
             else {
                 int freq = counts.get(s);
                 counts.put(s,freq+1);
             }
       }
       return iPsMostVisits(counts);
    }
    
    public int mostNumberVisitsByIP(HashMap<String,Integer> myCounts){ 
       int max = 0;
       for (String s: myCounts.keySet()){
            int currentNum = myCounts.get(s);
            if (currentNum > max) {
                max = currentNum;
            }
        }
        return max; 
    }
     
    public void printAll() {
         for(LogEntry le : records) {
             System.out.println(le);
         }
     }
         
}
