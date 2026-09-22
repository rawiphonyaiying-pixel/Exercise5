/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package Ex5_6813114;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


class DigitCheckerThread extends Thread {
    private static String path = "Ex5_6813114/"; // change to Ex5_xx
    private PrintWriter out;
    private ArrayList<Integer> monoDigitNumbers;
    private int maxrounds;

    public DigitCheckerThread(int maxrounds){
        this.maxrounds = maxrounds;
        this.monoDigitNumbers = new ArrayList<>();
    }

    private boolean isMonoDigit(int v){
        int lastDigit = v % 10;
        v = v / 10;

        while(v > 0){
            if(v % 10 != lastDigit)
                return false;
            v = v / 10;
        }
    return true;
    }
    

    @Override
    public void run() {
        try{
            // Create PrintWriter object to write result to a separate file
            String fileName = path + this.getName() + "_output.txt"; 
            out = new PrintWriter(new FileWriter(fileName));
            Random rand = new Random();
        
            // Execute steps 1-3 in loop for maxrounds:
            // 1. Random a value v in range [10, 999]. Check whether it is a mono-digit number
            for(int i = 1; i <= maxrounds; i++){
                int v = rand.nextInt(990)+10;

                // (i.e. a number consisting of a single repeating digit). If it is, keep it in   
                if(isMonoDigit(v)){

                    // the ArrayList.
                    monoDigitNumbers.add(v);

                    //2. Print round number, v, and mono-digit count if it is a mono-digit number to
                    out.printf("Round %4d >> value = %5d --> mono digit %d%n", i, v, monoDigitNumbers.size());
                }
                else
                    out.printf("Round %4d >> value = %5d%n", i, v);
            }
            out.close();

            // After the loop, print thread name & all mono-digit numbers (sorted in increasingorder) to the screen.
            Collections.sort(monoDigitNumbers);
            System.out.printf("Thread %s >> mono-digit numbers = %s%n", this.getName(), monoDigitNumbers);
        }catch(IOException e){
            System.out.println("Error: Cannot write to file in thread " + this.getName());
            e.printStackTrace();
        }
    }
}