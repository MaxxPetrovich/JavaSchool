package com.mpetrov.javaschool.hw.lesson1;

import java.util.Scanner;

public class Task2024 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        int[] arr = new int[count];
        int result = 0;

        for (int i = 0; i < count; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < count / 2; i++) {
            if (arr[i] != arr[count - i - 1]) result++;
        }

        System.out.println(result);
    }
}
