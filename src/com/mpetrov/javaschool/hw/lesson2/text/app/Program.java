package com.mpetrov.javaschool.hw.lesson2.text.app;

import java.util.*;

import static java.util.Collections.*;

public class Program {
    public static void main(String[] args) {
        System.out.println(countDiffWords(new Scanner(TextInitializer.initialize())));

        sortedDiffWords(new Scanner(TextInitializer.initialize()));

        countSameWords(new Scanner(TextInitializer.initialize()));
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

    public static void countSameWords(Scanner scanner) {
        Map<String, Integer> diffWords = new HashMap<>();
        while (scanner.hasNextLine()) {
            String word = scanner.nextLine();
            if (diffWords.containsKey(word)) {
                diffWords.put(word, diffWords.get(word) + 1);
            } else diffWords.put(word, 1);
        }
        for (Map.Entry<String, Integer> e : diffWords.entrySet()) {
            System.out.println(e.getKey() + "= " + e.getValue());
        }

    }

}
