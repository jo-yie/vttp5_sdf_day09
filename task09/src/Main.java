package task09.src;

import java.util.*;
import java.io.*;

public class Main {

    private static int randInt = 0;
    private static List<String> userInputArray = new ArrayList<>();
    private static File file = new File("gameFiles/userHistory");

    public static void main(String[] args) throws IOException {

        // generate random number
        generateNum();
        System.out.println(randInt);
        System.out.println("Random number generated!");
        
        // read user input
        Console cons = System.console(); 
        String userInput = "";

        while (true) {

            hint();
            userInput = cons.readLine(">>> Guess: ");

            // if user inputs "quit", end program 
            if (userInput.equals("quit")) {
                break;
            }

            // compare userInput with randInt
            System.out.println(compare(userInput));

            // add userInput to array 
            userInputArray.add(userInput);

            // if user wins, end program
            if (compare(userInput).equals("You win!")) {
                break;
            }


        }
        
        // save to file
        save();

        System.out.println("Bye bye!");

    }

    // generate number between 1111 to 9999
    public static void generateNum() { 

        Random rand = new Random(); 
        String randNumString = "";

        for (int i = 0; i < 4; i++) {
            int randInt = rand.nextInt(1, 10);
            randNumString += String.valueOf(randInt);

        }

        randInt = Integer.parseInt(randNumString);

    }

    // compare userInput to randInt
    public static String compare(String input) {

        int inputInt = Integer.parseInt(input);

        // if inputInt < randInt
        // return "Higher!"
        if (inputInt < randInt) {
            return("Higher!");
        } 

        // if inputInt == randInt
        // return "You win!"
        else if (inputInt == randInt) {
            return("You win!");
        }

        // if inputInt > randInt
        // return "Lower!"
        else if (inputInt > randInt) {
            return("Lower!");
        }

        return "";

    }

    // closest value in userInputArray are used as hints
    public static void hint() { 

        int smallVal = 1111; 
        int largeVal = 9999;

        // loop through all values 
        for (int i = 0; i < userInputArray.size(); i++) {

            int temp = Integer.parseInt(userInputArray.get(i));

            // small val max 
            if (temp < randInt) {

                if (temp > smallVal) {
                    smallVal = temp; 

                }

            } 
            
            // large val min 
            else if (temp > randInt) {

                if (temp < largeVal) {
                    largeVal = temp;

                }

            }

        }

        System.out.printf("Greater than or equals to %d, less than or equals to %d\n", smallVal, largeVal);

    }

    public static void save() throws IOException {

        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);

        for (String s : userInputArray) {

            bw.write(s);
            bw.write("\n");

        }

        bw.flush(); 
        bw.close();

    }

}