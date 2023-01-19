package com.epam.rd.autotasks.sequence;
import java.util.Scanner;

public class FindMaxInSeq {
    public static int max() {
        Scanner scnr = new Scanner(System.in);
        int currValue = scnr.nextInt();
        int maxSoFar=currValue;
        while (true) {
            currValue = scnr.nextInt();
            if(currValue==0)break;
            if (currValue >= maxSoFar ) {
                maxSoFar = currValue;
            }
        }
        return maxSoFar;
    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        FindMaxInSeq test = new FindMaxInSeq();

        System.out.println(max());
    }
}
