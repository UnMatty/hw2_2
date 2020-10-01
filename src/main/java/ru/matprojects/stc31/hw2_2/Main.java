package ru.matprojects.stc31.hw2_2;

import java.util.InputMismatchException;
import java.util.PrimitiveIterator;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private final static int MIN_RAND = -100;
    private final static int MAX_RAND = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean check = false;
        int n = 0;
        do {
            try {
                System.out.println("Enter amount of random numbers:");
                n = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("need to enter int value");
                continue;
            }

            if (n < 0) {
                System.out.println("neet to enter value above zero");
                continue;
            }

            check = true;
        } while (!check);

        PrimitiveIterator.OfInt iterator = (new Random()).ints(n, MIN_RAND, MAX_RAND).iterator();
        while (iterator.hasNext()) {
            int k = iterator.nextInt();
            try {
                if (k < 0) {
                    throw new Exception(k + " is below zero");
                }

                int sqrt = (int) Math.round(Math.sqrt(k));
                if (k == sqrt*sqrt) {
                    System.out.println("k = " + k);
                }
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }
}
