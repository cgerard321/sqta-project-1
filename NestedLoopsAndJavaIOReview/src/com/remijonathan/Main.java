package com.remijonathan;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        //Today's schedule Nested Loops, Objects and Print writer
        File inputFile = new File("inputFile.txt");
        File outputFile = new File("outputFile.txt");

        PrintWriter printWriter = new PrintWriter(outputFile);

        Scanner inputData = new Scanner(inputFile);

        while (inputData.hasNextInt()) {
            int size = inputData.nextInt();
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++)
                    if (i != j) {
                        printWriter.print("#");
                    } else {
                        printWriter.print("*");
                    }
                printWriter.println();
            }
            printWriter.println();
        }
        printWriter.close();
    }
}
