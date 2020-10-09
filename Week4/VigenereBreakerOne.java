package week4_assignments;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import edu.duke.*;

public class VigenereBreakerOne {
	
	//English, Known Key Length
	
    public String sliceString(String message, int whichSlice, int totalSlices) {
        int len = message.length();
        
        int limit = (len - whichSlice) / totalSlices + Math.min((len - whichSlice) % totalSlices, 1);
        
        String s = Stream.iterate(whichSlice, i -> i + totalSlices)
        .limit(limit)
        .map(message::charAt)
        .map(String::valueOf)
        .collect(Collectors.joining());
        return s;
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
    	CaesarCracker ccr = new CaesarCracker(mostCommon);
    	List<Integer> keyList = IntStream.range(0, klength).boxed().parallel()
    	.map(i -> {
    		return ccr.getKey(sliceString(encrypted,(int)i,klength));
    	})
    	.collect(Collectors.toList());
    	return keyList.stream().mapToInt(x -> x).toArray();    	
    	
    }

    public void breakVigenere () {
    	FileResource fr = new FileResource("data/secretmessage1.txt");
    	String encrypted = fr.asString();
    	int[] key = tryKeyLength(encrypted, 4, 'e');
    	System.out.println(key);
    	VigenereCipher cipher = new VigenereCipher(key);
    	String decrypted = cipher.decrypt(encrypted);
    	System.out.println("Decrypted Message: " + decrypted);
    }
    
    public static void main(String[] args) {
    	VigenereBreakerOne breaker = new VigenereBreakerOne();
    	
    	assert breaker.sliceString("abcdefghijklm", 0, 3).equals("adgjm") : "not right";
    	assert breaker.sliceString("abcdefghijklm", 1, 3).equals("behk") : "not right";
    	assert breaker.sliceString("abcdefghijklm", 2, 3).equals("cfil") : "not right";
		assert breaker.sliceString("abcdefghijklm", 0, 4).equals("aeim") : "not right";
		assert breaker.sliceString("abcdefghijklm", 1, 4).equals("bfj") : "not right";
		assert breaker.sliceString("abcdefghijklm", 2, 4).equals("cgk") : "not right";
		assert breaker.sliceString("abcdefghijklm", 3, 4).equals("dhl") : "not right";
		assert breaker.sliceString("abcdefghijklm", 0, 5).equals("afk") : "not right";
		assert breaker.sliceString("abcdefghijklm", 1, 5).equals("bgl") : "not right";
		assert breaker.sliceString("abcdefghijklm", 2, 5).equals("chm") : "not right";
		assert breaker.sliceString("abcdefghijklm", 3, 5).equals("di") : "not right";
		assert breaker.sliceString("abcdefghijklm", 4, 5).equals("ej") : "not right";
		
		breaker.breakVigenere();
    }
    
    
    
}
