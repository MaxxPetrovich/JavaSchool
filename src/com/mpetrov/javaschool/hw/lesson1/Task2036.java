package com.mpetrov.javaschool.hw.lesson1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2036 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("[aeiouy]{3,}");

        int count = scanner.nextInt();
        ArrayList<String> output = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String input = scanner.next();
            Matcher matcher = pattern.matcher(input);

            if (!matcher.find()) {
                output.add(input);
            }
        }
        for (String s : output) {
            System.out.println(s);
        }
    }
}
