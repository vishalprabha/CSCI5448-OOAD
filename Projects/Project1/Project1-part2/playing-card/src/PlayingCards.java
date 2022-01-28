/*
Author: Vishal Prabhachandar
Section: CSCI 5448-001
JDK version: Open JDK Amazon Corretto-11.0.13.8.1
Playing cards program

Assumptions:
1. The program ends when the user inputs 0.
2. Deck is reinitialized after selection
        - Example: when 5 random cards are shown from the deck. Before next random selection based on input
                    the deck is reset.
3. Arraylist is used to store the deck of cards.
4. Used Static variables and methods to hold card deck, so only single object is shared among all objects.
5. No code was copied, looked up documentation to perform operations.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

// Class to hold card details
class Deck{
    static String[] SUIT = {
            "Club", "Diamond", "Heart", "Spade"
    };

    static String[] FACE_VALUE = {
            "A", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "J", "Q", "K"
    };
    static int DECK_SIZE = 54;
    // Used to store the cards
    static ArrayList<String> DECK = new ArrayList<>();
    // Function to initialize the DECK of cards
    static void initialize(){
        DECK.clear();
        for (String s : FACE_VALUE) {
            for (String value : SUIT) {
                DECK.add(s + "-" + value);
            }
        }
        // Adding the two jokers
        DECK.add("Joker-1");
        DECK.add("Joker-2");
    }
    // Function to shuffle the DECK for more randomness
    static void shuffleDeck(){
        Collections.shuffle(DECK);
    }
}
// Class to hold methods to perform random selection from DECK
class randomCardSelector{
    void printRandomCard(int number){
        // Random generator
        Random randomIndex = new Random();
        int deckIndex;
        for (int cardNumber = 0; cardNumber < number; cardNumber++) {
            // find random index in arraylist to print
            deckIndex = randomIndex.nextInt(Deck.DECK_SIZE - cardNumber);
            System.out.println(Deck.DECK.get(deckIndex));
            // Remove the shown card from arraylist so there is no repetition
            Deck.DECK.remove(deckIndex);
        }
    }
}
// Driver class
public class PlayingCards {
    public static void main(String[] args) {
        // Initializing deck - there is no need to create an object to initialize as all the values are static
        Deck.initialize();
        // Shuffling deck
        Deck.shuffleDeck();
        // Object creation for randomCardSelector
        randomCardSelector operation = new randomCardSelector();
        int inputNumber = -1;
        Scanner input = new Scanner(System.in);
        // Accepting input until 0
        do{
            System.out.println("Enter a number: ");
            // Try catch for handling inputs other than numbers
            try{
                inputNumber = input.nextInt();
                // Checking for valid input range
                if (inputNumber < 0 || inputNumber > 54){
                    System.out.println("Enter a valid integer between 0 and 54!");
                }
                // Check if number is not 0 and perform random selection
                else if (inputNumber != 0 ){
                    operation.printRandomCard(inputNumber);
                    Deck.initialize();
                }
            }
            catch (Exception e){
                System.out.println("Enter a valid integer between 0 and 54!");
                input.next();
            }
        }while(inputNumber != 0);

    }
}
