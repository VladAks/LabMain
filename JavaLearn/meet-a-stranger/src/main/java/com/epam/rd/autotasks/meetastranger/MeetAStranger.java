package com.epam.rd.autotasks.meetastranger;

import java.util.Scanner;

public class MeetAStranger {
    public static void main(String[] args) {
        //Write a program, which read a String from System.in and print "Hello, <input string>"
        Scanner sc= new Scanner(System.in);
        String str= sc.nextLine();
        System.out.print("Hello, "+ str);
        int i = 3;
        byte b = 1;
        byte b1 = 1 + 2;                // line 1
        short s = 304111;               // line 2
        short s1 = (short) 304111;       // line 3
        b = b1 + 1;                     // line 4
        b = (byte)  (b1 + 1);           // line 5
        b = −b;                         // line 6
        b = (byte) −b;                  // line 7
        b1 *= 2;                       // line 8
        b = i;                          // line 9
        b = (byte)  i;
        b += i++;
        float f = 1.1f;
        b /= f;
    }
}
