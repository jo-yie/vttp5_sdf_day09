package task10.src;

import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> listInt = new ArrayList<>();
    // List<Integer> copy = new ArrayList<>();

    static int current = 0;

    public static void main(String[] args) {

        // call generate()
        generate();

        // print "numbers generated" message
        System.out.println("Numbers generated");


        // System.out.println(listInt);


        // initialise console 
        Console cons = System.console();

        String keyboardInput = "";

        // while loop 
        while(true) {

            if (current == 9) {
                break;
            } 

            // show number 
            // show higher or lower for rest of array 
            show();

            keyboardInput = cons.readLine("Higher or lower?\n>>> ");
            
            if (keyboardInput.equals("quit")) {
                break;
            }

            // input: "h" or "l"
            check(keyboardInput);
            // System.out.println(current);
            // System.out.println(listInt.get(current));

        }

        System.out.println("Bye!");


    }
    


    // generate array of 10 random numbers 
    // between 1 and 100 
    public static void generate() {

        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            int temp = rand.nextInt(1, 100);

            // update listInt
            listInt.add(temp);
        }


    }

    // show number 
    // show higher or lower for rest of array 
    public static void show() {

        int higher = 0; 
        int lower = 0;

        // print listInt.get(current);
        System.out.println(listInt.get(current)); 

        // subList(current + 1, 10)
        List<Integer> sublist = listInt.subList(current + 1, 10);

        // loop through sublist 
        for (int i = 0; i < sublist.size(); i++) {
            
            // if num > listInt current, higher ++
            if (sublist.get(i) > listInt.get(current)) {
                higher++;
            }

            // else if num <= listInt current, lower ++ 
            else if (sublist.get(i) <= listInt.get(current)) {
                lower++;
            }

        }

        System.out.printf("%d higher, %d lower\n", higher, lower);

    }

    // check if number is higher or lower than next number 
    public static void check(String in) {

        String ans = "";

        if (listInt.get(current + 1) > listInt.get(current)) {
            ans = "h";
        } else if (listInt.get(current + 1) <= listInt.get(current)) {
            ans = "l";
        }

        if (ans.equals(in)) {
            // System.out.println(ans);

            // System.out.printf("comparing current: %d and next: %d\n", listInt.get(current), listInt.get(current + 1));
            // System.out.printf("input: %s, ans: %s\n", in, ans);
            System.out.println("CORRECT");
        } else {
            // System.out.println(ans);

            // System.out.printf("comparing current: %d and next: %d\n", listInt.get(current), listInt.get(current + 1));
            // System.out.printf("input: %s, ans: %s\n", in, ans);
            System.out.println("WRONG");
        }

        // increment current
        current++; 


    }


}
