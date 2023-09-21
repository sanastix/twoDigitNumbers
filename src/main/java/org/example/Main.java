package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        int a = in.nextInt();
        in.close();

        int result = howMuchNumbers(a);

        PrintWriter out = new PrintWriter("output.txt");
        out.print(result);
        out.close();
    }

    public static int howMuchNumbers(int a) {
        return generateStrings(a);
    }

    private static int generateStrings(int length) {
        char[] currentString = new char[length];
        return generateStringsHelper(length, currentString, 0, ' ');
    }

    public static int generateStringsHelper(int length, char[] currentString, int index, char lastChar) {
        if (length == 0) {
            return 1;
        }

        int count = 0;

        for (char digit : "59".toCharArray()) {
            if (index < 2 || (lastChar != digit || currentString[index - 1] != digit || currentString[index - 2] != digit)) {
                currentString[index] = digit;
                count += generateStringsHelper(length - 1, currentString, index + 1, digit);
            }
        }

        return count;
    }
}
