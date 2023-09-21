package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(new File("input.txt"));

        int a = in.nextInt();

        in.close();

        PrintWriter out = new PrintWriter("output.txt");
        out.print(howMuchNumbers(a));

        out.close();

    }

    public static int howMuchNumbers (int a){
        generateStrings(a, "");
        return list.size();
    }

    private static void generateStrings(int length, String currentString) {

        if (length == 0) {
            list.add(currentString);
            return;
        }

        if (hasThreeConsecutive(currentString + "5")) {
            generateStrings(length - 1, currentString + "5");
        }
        if (hasThreeConsecutive(currentString + "9")) {
            generateStrings(length - 1, currentString + "9");
        }
    }

    public static boolean hasThreeConsecutive(String str) {
        int n = str.length();
        if (n < 3) {
            return true;
        }

        for (int i = 2; i < n; i++) {
            if (str.charAt(i) == str.charAt(i - 1) && str.charAt(i) == str.charAt(i - 2)) {
                return false;
            }
        }

        return true;
    }

}