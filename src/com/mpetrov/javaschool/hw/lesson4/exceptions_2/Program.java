package com.mpetrov.javaschool.hw.lesson4.exceptions_2;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Input url");
            String url = scanner.next();

            try {
                readContent(url);
                break;
            } catch (MalformedURLException e) {
                System.out.println("Malformed URL");
            } catch (UnknownHostException e) {
                System.out.println("Unknown host!");
            } catch (IOException e) {
                System.out.println("Unable to get content. " + e.getMessage());
                throw e;
            }

            System.out.println("Try again");
        }
    }

    private static void readContent(String url) throws IOException {
        Object content = new URL(url).getContent();

        if (content instanceof InputStream) {
            InputStream contentStream = (InputStream) content;
            try (Scanner scanner = new Scanner(contentStream)) {
                while (scanner.hasNext()) {
                    System.out.println(scanner.next());
                }
            }
        } else {
            throw new IOException("Unsupported content");
        }
    }

}
