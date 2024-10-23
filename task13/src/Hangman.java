package task13.src;

import java.io.*;
import java.util.*;

public class Hangman {

    String word = "";
    List<String> wordArray;

    File file = new File("hangmanFiles/hangmanWords.txt");
    File newFile = new File("hangmanFiles/usedWords.txt");
    String[] guess;


    // empty constructor
    public Hangman() {
    }

    // selects random word from file
    public void selectWord() throws IOException { 

        // initialise FileReader and BufferedReader for file
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        // empty wordArray 
        wordArray = new ArrayList<>();

        // read all words in file into wordArray 
        String temp = "";
        while ((temp = br.readLine()) != null) {
            wordArray.add(temp);
        }

        br.close();

        // select random word from wordArray 
        Random rand = new Random(); 
        int randInt = rand.nextInt(wordArray.size());

        // assign random word to word variable
        word = wordArray.get(randInt);

        // // for testing
        // System.out.println(word);


        // create guess variable (dotted lines)
        guess = new String[word.length()];
        for (int i = 0; i < word.length(); i++) {
            guess[i] = "_";

        }

    }

    // check if keyboardInput is in word
    public void check(String str) {

        if (word.contains(str)) {

            char temp = str.charAt(0);
            for (int i = 0; i < word.length(); i++) {
                
                if (temp == word.charAt(i)) {
                    guess[i] = str;

                }
            }

        }


    }
    
    // shows dotted lines 
    public void returnGuess() {

        String temp = "";
        for (String s : guess) {
            temp += s;

        }

        System.out.println(temp);

    }

    // checks if word is guessed 
    public boolean wordGuessed() {

        for (String s : guess) {
            if (s.equals("_")) {
                return false;
            }
        }

        return true;

    }

    // remove word from file and write into new file 
    public void removeFromFile() throws IOException {

        FileWriter fw = new FileWriter(file, false);
        BufferedWriter bw = new BufferedWriter(fw);

        for (String s : wordArray) {
            if (s.equals(word)) {


                // write to newFile
                FileWriter fwNew = new FileWriter(newFile, true);
                BufferedWriter bwNew = new BufferedWriter(fwNew);

                bwNew.write(s);
                bwNew.newLine();
                bwNew.close();

            } else {
                bw.write(s);
                bw.newLine();
            }

        }

        bw.close();

    }
    
}
