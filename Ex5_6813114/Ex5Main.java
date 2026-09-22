/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ex5_6813114;

import java.util.Scanner;

/**
 * @author Rawiphon Yaiying 6813114
 */

public class Ex5Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number of threads = ");
        int numThreads = scanner.nextInt();
        System.out.print("Max rounds = ");
        int maxRounds = scanner.nextInt();
        for(int i=0; i<numThreads; i++){
            DigitCheckerThread thread = new DigitCheckerThread(maxRounds);
            thread.setName("T" + i);
            thread.start();
        }
    
        scanner.close();
    }
}