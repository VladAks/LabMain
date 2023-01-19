package com.epam.rd.autotasks.pizzasplit;

import java.util.Scanner;

public class PizzaSplit {
    public static void main(String[] args) {
        //Write a program, reading number of people and number of pieces per pizza and then
        //printing minimum number of pizzas to order to split all the pizzas equally and with no remainder
        Scanner scanner = new Scanner(System.in);
        int people = scanner.nextInt();
        int pieces = scanner.nextInt();
        int pizza = 1;
        int countOfPiec = pieces;

        while(people > 0) {
            pieces = countOfPiec;
            pieces *= pizza;
            if(pieces % people == 0){
                break;
            }
            pizza++;
        }
        System.out.println(pizza);
    }
}
