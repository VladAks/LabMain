package com.epam.rd.autotasks;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Use Scanner methods to read input
        Scanner scan = new Scanner(System.in);
        int sum =0;
        int k =0;
        int number = scan.nextInt();
        sum = sum + number;
        while (number != 0)
        {
            number  = scan.nextInt();
            sum = sum + number;
            k++;
        }
        System.out.println (sum/k);
    }
}