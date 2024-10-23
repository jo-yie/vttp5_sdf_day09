package task11.src;

import java.util.*;

public class App {

    public static void main(String[] args) {

        String[] suits = {"SPADE", "HEART", "CLUB", "DIAMOND"};
        String[] ranks = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    
        // 52 cards in a deck 
        int numberOfDeckCards = suits.length * ranks.length;
    
        /** ArrayList Method
        // using ArrayList because it has Collections.shuffle(deck)
        List<String> deck = new ArrayList<>();
    
        // create a deck of 52 cards in sequence 
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
    
                deck.add(suits[i] + " " + ranks[j]);
    
            }
    
        }

        // shuffle cards 
        Collections.shuffle(deck);

        // print the shuffled deck 
        for (String card : deck) {
            System.out.println(card);
        }
        */

        // ^ alternate method 
        String[] deck = new String[numberOfDeckCards]; 

        // create a deck of 52 cards in sequence 
        int temp = 0; 
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                
                deck[temp] = suits[i] + " " + ranks[j];
                temp ++;
            }
        }

        // shuffle cards 

        // new random
        Random rand = new Random(); 

        // hash set to store indexes used (no duplicated) 
        Set<Integer> uniqueIntegers = new HashSet<>();

        // new String[] to store shuffled cards 
        String[] shuffledDeck = new String[numberOfDeckCards];

        int randInt = 0;
        for (int i = 0; i < numberOfDeckCards; i++) {

            // keep generating randInt until it is no longer in uniqueIntegers
            while(uniqueIntegers.contains(randInt)) {
                randInt = rand.nextInt(numberOfDeckCards);
            }

            // add randInt to hash set uniqueIntegers
            uniqueIntegers.add(randInt);

            // assign random pos in new deck to current card 
            shuffledDeck[randInt] = deck[i];

        }

        for (String s : shuffledDeck) {
            System.out.println(s);
        }

        // try enum method 

    }



}
