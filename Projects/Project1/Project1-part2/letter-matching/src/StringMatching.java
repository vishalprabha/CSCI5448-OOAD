/*

Author: Vishal Prabhachandar
Section: CSCI 5448-001
JDK version: Open JDK Amazon Corretto-11.0.13.8.1
String matching program

Assumptions:
1. The program ends when the user inputs a null/empty string or the input word matches the randomly selected word.
2. Static arrays is used to store the predefined 12 five-letter words.
3. All the predefined words are assumed to be in upper case and have non-repeating characters.
4. Only the input string is upper-cased.
*/

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

// Class to hold list of predefined words
class WordList{
    // Storing the 12 words
    static String[] WORD_SET = { "BRUCE", "DWIGH", "MAXDO", "ROSHN", "GAPBN", "FRANK",
            "PHONE", "WORDS", "CREAM", "PASTE", "DOUGH", "DOGIE"};

    String getWord(){
        // Random generator
        Random randomIndex = new Random();
        int cardIndex = randomIndex.nextInt(WORD_SET.length);
        return WORD_SET[cardIndex];
    }
}

/* Class to perform the string comparison
    1. Hash set is used to store the characters of the randomly selected word (the random word doesn't contain repeating characters)
    2. Both input string and randomly selected word are converted to character array, so they are iterable
    3. We first check if there is an exact match of characters
    4. Otherwise, we look up the hashset using contains function to find if a character is present
    5. Finally, we conclude the character is not present

*/

class CompareStrings {

    boolean run(String randomWord, String inputString) {

        HashSet<Character> charLocation = new HashSet<>();
        int countMatch = 0;
        char[] randomWordChars = randomWord.toCharArray();
        char[] inputStringChars = inputString.toUpperCase().toCharArray();
        for (char c : randomWordChars) {
            charLocation.add(c);
        }
        for (int index = 0; index < inputString.length(); index++) {
            if (randomWordChars[index] == inputStringChars[index]) {
                ++countMatch;
                System.out.println("\"" + inputStringChars[index] + "\"" + " is a match in the correct location");
            } else if (charLocation.contains(inputStringChars[index])) {
                System.out.println("\"" + inputStringChars[index] + "\"" + " is in the word but in a different location");
            } else {
                System.out.println("\"" + inputStringChars[index] + "\"" + " is not in the word");
            }
        }
        // Code to return boolean value, if all characters match inorder to exit the program
        return countMatch == inputString.length();
    }
}
// Class for custom exception
// Reference - https://stackoverflow.com/questions/8423700/how-to-create-a-custom-exception-type-in-java
class wordException extends Exception{

    public wordException(String message){
        super(message);
    }
}

// Driver class
public class StringMatching {

    public static void main(String[] args){

        // getting random word
        WordList words = new WordList();
        String randomWord;
        // Object for CompareStrings class
        CompareStrings compare = new CompareStrings();
        // Flag variable to denote end of program or complete word match
        boolean isEnd;
        String inputString;
        Scanner input = new Scanner(System.in);
        // Accepting input until empty or word matches random word
        do{
            // Setting isEnd flag to false
            isEnd = false;
            // Set random word
            randomWord = words.getWord();
            System.out.println("Enter a 5-letter word: ");
            // Try catch for handling inputs other than numbers

            inputString = input.nextLine();
            // Checking for empty input
            if (inputString.isBlank() || inputString.isEmpty()){
                isEnd = true;
            }
            // Check if words are alphabets only
            // Reference - https://www.tutorialkart.com/java/how-to-check-if-string-contains-only-alphabets-in-java/
            else if(!inputString.matches("[a-zA-Z]+")){
                try{
                    throw new wordException("Enter a valid 5-letter word!");
                }
                catch(wordException we){
                    System.out.println(we.getMessage());
                }
            }
            // Checking for valid input length
            else if (inputString.length() != 5){
                try{
                    throw new wordException("Enter a valid 5-letter word!");
                }
                catch(wordException we){
                    System.out.println(we.getMessage());
                }
            }
            // Perform comparison
            else{
                isEnd = compare.run(randomWord, inputString);
            }

        }while(!isEnd);
    }
}
