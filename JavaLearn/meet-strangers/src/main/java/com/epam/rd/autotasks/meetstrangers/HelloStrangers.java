package com.epam.rd.autotasks.meetstrangers;

import java.io.IOException;
import java.util.Scanner;

public class HelloStrangers {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        scan.nextLine();
        if (number == 0)
        {
            System.out.println ("Oh, it looks like there is no one here");
        }
        if (number < 0) {
            System.out.println ("Seriously? Why so negative?");
        }

        for(int i = 0; i < number; i++) {
            String name = scan.nextLine();

            System.out.println ("Hello, " + name);
        }
    }
}
