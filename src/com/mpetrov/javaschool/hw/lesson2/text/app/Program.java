package com.mpetrov.javaschool.hw.lesson2.text.app;

import java.util.*;

import static java.util.Collections.*;

public class Program {
    public static void main(String[] args) {
        System.out.println(countDiffWords(new Scanner(TextInitializer.initialize())));

        sortedDiffWords(new Scanner(TextInitializer.initialize()));
    }

    public static int countDiffWords(Scanner scanner) {
        Set<String> diffWords = new HashSet<>();
        while (scanner.hasNextLine()) diffWords.add(scanner.nextLine());
        return diffWords.size();
    }

    public static void sortedDiffWords(Scanner scanner) {
        Set<String> diffWords = new HashSet<>();
        while (scanner.hasNextLine()) diffWords.add(scanner.nextLine());
        List<String> sortedWords = new ArrayList<>(diffWords);
        sort(sortedWords);
        sortedWords.sort(new LengthComparator());
        for (String s : sortedWords) {
            System.out.println(s);
        }
    }
}
