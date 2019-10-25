[Telling a Random Story]

Assignment 1: Most Frequent Word
[Most frequent Word]

You will write a program to determine the word that occurs the most often in a file. If more than one word occurs as the most often, then return the first such word found. You should make all words lowercase before counting them. Thus, “This” and “this” will both be counted as the lowercase version of “this”. You should not consider punctuation, so “end” and “end,” will be considered different words. Use the WordFrequencies program in the lesson as a starting point.

Specifically, you should do the following:

Create a new project in BlueJ and then create a new class called WordFrequencies. Put all the following items in this class.
Create two private variables. One is called myWords and should be an ArrayList of type String to store unique words from a file, and one is called myFreqs and should be an ArrayList of type Integer. The kth position in myFreqs should represent the number of times the kth word in myWords occurs in the file.

Write a constructor WordFrequencies, and initialize the private variables.

Write a void method findUnique that has no parameters. This method should first clear both myWords and myFreqs, using the .clear() method. Then it selects a file and then iterates over every word in the file, putting the unique words found into myWords. For each word in the kth position of myWords, it puts the count of how many times that word occurs from the selected file into the kth position of myFreqs, as was demonstrated in the lesson.
Write a void tester method that has no parameters. This method should call findUnique. Then print out the number of unique words, and for each unique word, print the frequency of each word and the word, as was demonstrated in the lesson.

Write the method findIndexOfMax that has no parameters. This method returns an int that is the index location of the largest value in myFreqs. If there is a tie, then return the first such value.

Add code to the tester method to determine and print the word that occurs the most often in a selected file and how many times it occurs. You should find it helpful to call findIndexOfMax.

For example, if the file were testwordfreqs.txt:

This is a test. Yes a test of a test. Test.

Then the output would be:

Number of unique words: 7
1 this
1 is
3 a
3 test.
1 yes
1 test
1 of
The word that occurs most often and its count are: a 3
We are ignoring punctuation, so note that “test.” and “test” are different, as the first one has a period with it. Also note that there is a tie—two words are counted three times; you should return the first such word found which is “a”.


Assignment 2: Character Names

[Characters Names]

Write a program to determine the characters in one of Shakespeare’s plays that have the most speaking parts. Consider the play “The Tragedy of Macbeth” in the file macbeth.txt. Here are a few lines from the file put into a much smaller file called macbethSmall.txt:

MACBETH. My dearest love,
Duncan comes here tonight.
LADY MACBETH. And when goes hence?
MACBETH. Tomorrow, as he purposes.
LADY MACBETH. O, never
Shall sun that morrow see!
Your face, my Thane, is as a book where men
May read strange matters. To beguile the time,
Look like the time; bear welcome in your eye,
Your hand, your tongue; look like the innocent flower,
But be the serpent under it. He that's coming
Must be provided for; and you shall put
This night's great business into my dispatch,
Which shall to all our nights and days to come
Give solely sovereign sway and masterdom.
MACBETH. We will speak further.

Note that each speaking part is at the beginning of the line (there may be some blanks before it) and has a period immediately following it. Shakespeare used this format in many of his plays. Sometimes the name of the person to speak was all capitalized and sometimes it was not.

Write a program to print out the main characters in one of Shakespeare’s plays, those with the most speaking parts. You should identify a speaking part by reading the file line-by-line and finding the location of the first period on the line. Then you will assume that everything up to the first period is the name of a character and count how many times that occurs in the file. You will only print those characters that appear more often than others. Notice our method is somewhat error prone. For example, a period is also used to indicate the end of a sentence. By printing out only those characters that appear a lot, we will get rid of most of the errors. Periods that indicate the end of a sentence will likely be a unique phrase so you won’t print that as it would just occur once or maybe twice.

For the file macbethSmall.txt, if we process it and print ALL the possible speaker characters and counts found, we would get the following output:

MACBETH	3

Duncan comes here tonight	1
LADY MACBETH	2
May read strange matters	1
But be the serpent under it	1
Give solely sovereign sway and masterdom	1
If we only print those with a count greater than 1, then our output is:
MACBETH	3
LADY MACBETH	2

In processing the complete play in macbeth.txt you should not print out every count—you would have too much output, so instead print every count that is greater than or equal to some number (you decide what that number is).

Specifically, you should do the following:

Create a class named CharactersInPlay. Put all the following items below in this class.
You will need to create two private ArrayLists. One to store the the names of the characters you find and one to store the corresponding counts for each character.

Write a void method named update that has one String parameter named person. This method should update the two ArrayLists, adding the character’s name if it is not already there, and counting this line as one speaking part for this person.

Write a void method called findAllCharacters that opens a file, and reads the file line-by-line. For each line, if there is a period on the line, extract the possible name of the speaking part, and call update to count it as an occurrence for this person. Make sure you clear the appropriate instance variables before each new file.

Write a void method called tester that has no parameters. This method should call findAllCharacters, and then for each main character, print out the main character, followed by the number of speaking parts that character has. A main character is one who has more speaking parts than most people. You’ll have to estimate what that number should be. Test your method on the file macbethSmall.txt. and then macbeth.txt.

Write a void method called charactersWithNumParts that has two int parameters named num1 and num2, where you can assume num1 should be less than or equal to num2. This method should print out the names of all those characters that have exactly number speaking parts, where number is greater than or equal to num1 and less than or equal to num2. 
Add code in tester to test this method out.

[ Using and Improving GladLibs ]

[Using GladLibs]
[GladLib]
Assignment: Verbs and Fruits

Run the GladLib.java program that is provided. You should also have a data folder with several files. This program should generate a story using the file madtemplate.txt, which is also in the data folder. This program creates a story by replacing placeholder words such as <noun> by looking for a random word of that type. This approach uses multiple private ArrayLists, one for each type of word, to store each type of replacement. For example, one ArrayList stores different nouns. These nouns are initially read in from a file called noun.txt and stored in the ArrayList named nounList. Whenever the templated word <noun> is found in the story, a random noun from the nounList is used in place of <noun>.

You will now modify the GladLib.java file to handle two additional categories—verbs and fruits. Specifically, you should make the following adjustments to your program:

Modify the program to handle replacing verbs with <verb> tags and fruits with <fruit> tags. You will read in choices of verbs from the file verb.txt and choices for fruit from the file fruit.txt. 
These files are already in the data folder. There are several parts of the program that you will need to modify.
Add private ArrayLists, one for verbs and one for fruits.
Modify the method initializeFromSource to read the data from these two files.
Modify the method getSubstitute to handle the replacements of <verb> and <fruit> with random words of those types.
Modify the file makeStory to read in the template file madtemplate2.txt that also uses the <verb> and <fruit> tags.
Run your program to make sure it works before making additional changes.
Now modify your program so that once it uses a word, it never uses that word again. You should declare and initialize an additional private ArrayList to keep track of words that have been seen.
HINT: You will need to modify the method processWord. Once it finds a word to use, check to see if that word has been used before or not. You should also be sure that you clear out this new ArrayList in makeStory before each run of your program. The folder datalong with longer data files is provided.
Modify your program to print out the total number of words that were replaced right after the story is printed.

[Improving GladLibs]

Assignment 1: Codon Count

[Codon Count]

Write a program to find out how many times each codon occurs in a strand of DNA based on reading frames. A strand of DNA is made up of the symbols C, G, T, and A. A codon is three consecutive symbols in a strand of DNA such as ATT or TCC. A reading frame is a way of dividing a strand of DNA into consecutive codons. Consider the following strand of DNA = “CGTTCAAGTTCAA”.

There are three reading frames.

The first reading frame starts at position 0 and has the codons: “CGT”, “TCA”, “AGT” and “TCA”. Here TCA occurs twice and the others each occur once.
The second reading frame starts at position 1 (ignoring the first C character) and has the codons: “GTT”, “CAA”, “GTT”, “CAA”. Here both GTT and CAA occur twice.
The third reading frame starts at position 2 (ignoring the first two characters CG) and has the codons: “TTC”, “AAG”, “TTC”. Here TTC occurs twice and AAG occurs once.
A map of DNA codons to the number times each codon appears in a reading frame would be helpful in solving this problem.


Specifically, you should do the following:

Create a new class for this problem.
Create a private variable to store a HashMap to map DNA codons to their count.

Write a constructor to initialize the HashMap variable.

Write a void method named buildCodonMap that has two parameters, an int named start and a String named dna. This method will build a new map of codons mapped to their counts from the string dna with the reading frame with the position start (a value of 0, 1, or 2).

You will call this method several times, so make sure your map is empty before building it.
Write a method named getMostCommonCodon that has no parameters. This method returns a String, the codon in a reading frame that has the largest count. If there are several such codons, return any one of them. This method assumes the HashMap of codons to counts has already been built.

Write a void method named printCodonCounts that has two int parameters, start and end. This method prints all the codons in the HashMap along with their counts if their count is between start and end, inclusive.

Write a tester method that prompts the user for a file that contains a DNA strand (could be upper or lower case letters in the file, convert them all to uppercase, since case should not matter). Then for each of the three possible reading frames, this method builds a HashMap of codons to their number of occurrences in the DNA strand, prints the total number of unique codons in the reading frame, prints the most common codon and its count, and prints the codons and their number of occurrences for those codons whose number of occurrences in this reading frame are between two numbers inclusive.

For example, for the string above and here: “CGTTCAAGTTCAA,” also in smalldna.txt, if we run our program and print the output requested above and specify to print codons and counts for those codons whose counts are between 1 and 5 inclusive, we might get the output:

Reading frame starting with 0 results in 3 unique codons
and most common codon is TCA with count 2
Counts of codons between 1 and 5 inclusive are:

CGT 1
TCA 2
AGT 1

Reading frame starting with 1 results in 2 unique codons
and most common codon is CAA with count 2
Counts of codons between 1 and 5 inclusive are:

CAA 2
GTT 2

Reading frame starting with 2 results in 2 unique codons
and most common codon is TTC with count 2
Counts of codons between 1 and 5 inclusive are:

TTC 2
AAG 1


Note: The convention for text files is to end with a line break, so the above DNA string will have length 13 if directly defined as a String in your tester method, but length 14 if the text file containing it is read in as a FileResource. You can deal with this in several ways. One is to use the String method .trim() (http://docs.oracle.com/javase/7/docs/api/java/lang/String.html#trim() ) to get rid of white space. Another way to guard against identifying the final “AA “ as a codon would be adding a check that requires the last element of each codon be a letter before adding to the codon map.

Assignment 2: Words in Files

[WordInFiles]

Write a program to determine which words occur in the greatest number of files, and for each word, which files they occur in.

For example, consider you are given the four files: brief1.txt, brief2.txt, brief3.txt, and brief4.txt.

brief1.txt is:
cats are funny and cute

brief2.txt is:
dogs are silly
brief3.txt is:

love animals cats and dogs

brief4.txt is:
love birds and cats

The greatest number of files a word appears in is three, and there are two such words: “cats” and “and”.

“cats” appears in the files: brief1.txt, brief3.txt, brief4.txt
“and” appears in the files: brief1.txt, brief3.txt, brief4.txt

To solve this problem, you will create a map of words to the names of files they are in. That is, you will map a String to an ArrayList of Strings. Then you can determine which ArrayList value is the largest (has the most filenames) and its key is thus, a word that is in the most number of files.

Specifically, you should do the following:

Create a new class called WordsInFiles. Put all the remaining listed items in this class.
Create a private variable to store a HashMap that maps a word to an ArrayList of filenames.
Write a constructor to initialize the HashMap variable.

Write a private void method named addWordsFromFile that has one parameter f of type File.

This method should add all the words from f into the map. If a word is not in the map, then you must create a new ArrayList of type String with this word, and have the word map to this ArrayList. If a word is already in the map, then add the current filename to its ArrayList, unless the filename is already in the ArrayList. You can use the File method getName to get the filename of a file.

Write a void method named buildWordFileMap that has no parameters. This method first clears the map, and then uses a DirectoryResource to select a group of files. For each file, it puts all of its words into the map by calling the method addWordsFromFile. The remaining methods to write all assume that the HashMap has been built.

Write the method maxNumber that has no parameters. This method returns the maximum number of files any word appears in, considering all words from a group of files. In the example above, there are four files considered. No word appears in all four files. Two words appear in three of the files, so maxNumber on those four files would return 3. This method assumes that the HashMap has already been constructed.

Write the method wordsInNumFiles that has one integer parameter called number. This method returns an ArrayList of words that appear in exactly number files. In the example above, the call wordsInNumFiles(3) would return an ArrayList with the words “cats” and “and”, and the call wordsInNumFiles(2) would return an ArrayList with the words “love”, “are”, and “dogs”, all the words that appear in exactly two files.

Write the void method printFilesIn that has one String parameter named word. This method prints the names of the files this word appears in, one filename per line. For example, in the example above, the call printFilesIn(“cats”) would print the three filenames: brief1.txt, brief3.txt, and brief4.txt, each on a separate line.

Write the void method tester that has no parameters. This method should call buildWordFileMap to select a group of files and build a HashMap of words, with each word mapped to an ArrayList of the filenames this word appears in, determine the maximum number of files any word is in, considering all words, and determine all the words that are in the maximum number of files and for each such word, print the filenames of the files it is in. (optional) If the map is not too big, then you might want to print out the complete map, all the keys, and for each key its ArrayList. This might be helpful to make sure the map was built correctly.

Assignment 3: Maps Version of GladLibs

[GladLibMap]

Start with your GladLibs program you completed earlier in this lesson. Make a copy of it and call it GladLibMap.java. Now modify this program to use one HashMap that maps word types to ArrayList of possible words to select. Your program should still work for the additional categories verbs and fruits and should not use duplicate words from a category.

Specifically, you should make the following adjustments to this program:

Replace the ArrayLists for adjectiveList, nounList, colorList, countryList, nameList, animalList, timeList, verbList, and fruitList with one HashMap myMap that maps a String representing a category to an ArrayList of words in that category. Caution: Don’t replace the ArrayList representing the words that have already been used!
Create the new HashMap in the constructors.

Modify the method initializeFromSource to create an Array of categories and then iterate over this Array. For each category, read in the words from the associated file, create an ArrayList of the words (using the method readIt), and put the category and ArrayList into the HashMap.

Modify the method getSubstitute to replace all the if statements that use category labels with one call to randomFrom that passes the appropriate ArrayList from myMap.
Run your program to make sure it works.

Write a new method named totalWordsInMap with no parameters. This method returns the total number of words in all the ArrayLists in the HashMap. After printing the GladLib, call this method and print out the total number of words that were possible to pick from.

Write a new method named totalWordsConsidered with no parameters. This method returns the total number of words in the ArrayLists of the categories that were used for a particular GladLib. If only noun, color, and adjective were the categories used in a GladLib, then only calculate the sum of all the words in those three ArrayLists. Hint: You will need to keep track of the categories used in solving the GladLib, then compute this total.
