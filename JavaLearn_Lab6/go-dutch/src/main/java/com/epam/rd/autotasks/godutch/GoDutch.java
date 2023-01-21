package com.epam.rd.autotasks.godutch;

import java.util.Scanner;

public class GoDutch {

    public static void main(String[] args) {
        //Write code here
        Scanner scan = new Scanner( System.in );

        int sum = scan.nextInt();
        if (sum < 0) {

            System.out.println("Bill total amount cannot be negative");

            return;

        }

        int people = scan.nextInt();

        if (people <= 0) {

            System.out.println("Number of friends cannot be negative or zero");

            return;

        }

        int total = sum / people;
        int resultSum = total + total / 10;
        if(resultSum == 0 && sum != 0)
            resultSum = 1;

        System.out.println(resultSum);


    }
}
