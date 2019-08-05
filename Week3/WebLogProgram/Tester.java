
/**
 * Write a description of class Tester here.
 * 
 * @author (Aymar NAHUM) 
 * @version (25.07.2019)
 */

import java.util.*;

public class Tester
{
    
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        LogAnalyzer LogAnalyzer = new LogAnalyzer();
        LogAnalyzer.readFile("short-test_log");
        LogAnalyzer.printAll();
    }
}
