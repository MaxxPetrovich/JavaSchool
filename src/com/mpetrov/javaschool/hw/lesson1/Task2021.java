package com.mpetrov.javaschool.hw.lesson1;

import java.util.Scanner;

public class Task2021 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        int max = 0;
        int max2 = 0;
        int[] arr = new int[count];
        String result = "";
        for (int i = 0; i < count; i++) {
            arr[i] = scanner.nextInt();
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        for (int i = 0; i < count; i++) {
            if (arr[i] == max) {
                arr[i] = max / 2;
            }
            if (arr[i] > max2) {
                max2 = arr[i];
            }
        }
        for (int i = 0; i < count; i++) {
            if (arr[i] == max2) {
                arr[i] = max2 / 2;
            }
            result = result + arr[i] + " ";
        }
        System.out.println(result.trim());
    }
}
