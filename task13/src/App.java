package task13.src;

import java.io.Console;
import java.io.IOException;

public class App {
    
    public static void main(String[] args) throws IOException {

        // initialise hangman
        Hangman h = new Hangman();
        
        // initialise console
        Console cons = System.console();

        // initialise keyboardInput
        String keyboardInput = "";

        while (true) {

            // select word from file for guessing 
            h.selectWord();

            while (!h.wordGuessed()) {

                System.out.println();
                System.out.println("Word to guess: ");

                // show dotted lines 
                h.returnGuess();
    
                // accept user input 
                keyboardInput = cons.readLine(">>> Guess Letter: ");

                if (keyboardInput.equalsIgnoreCase("quit")) {
                    break;
                }
    
                // check if user input is in word 
                h.check(keyboardInput);
    
            }
            
            if (keyboardInput.equals("quit")) {
                break;
            }
            
            System.out.printf("Correct! The word was: ");
            h.returnGuess();

            // remove word from file 
            h.removeFromFile();

        }

    
        // exit game
        System.out.println("Bye!");


    }

}
