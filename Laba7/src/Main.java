//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example;

import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Scanner;



public class Main {
    public Main() {
    }

    public static void main(String[] args) throws IncorrectFileNameException {
        boolean Work = true;

        while(Work) {
            double answer = 0.0;
            Scanner reader = new Scanner(System.in);
            System.out.print("Enter number one: ");
            double number1 = reader.nextDouble();
            System.out.print("Enter number two: ");
            double number2 = reader.nextDouble();
            System.out.print("\nEnter an operator (+, -, *, /): ");
            char operator = reader.next().charAt(0);

            try {
                answer = calculate(number1, number2, operator);
            } catch (Exception var) {
                System.out.println(var.getMessage());
                continue;
            }

            System.out.print("\nResult:\n");
            System.out.println("" + number1 + " " + operator + " " + number2 + " = " + answer);
            System.out.println("Continue?(+,-)");
            String Want = reader.next();
            if (!Objects.equals(Want, "+")){
                break;
            }
        }

    }

    public static double calculate(double number1, double number2, char operator) throws Exception {
        double answer = 0.0;
        switch (operator) {
            case '*':
                answer = number1 * number2;
                return answer;
            case '+':
                answer = number1 + number2;
                return answer;
            case ',':
            case '.':
            default:
                throw new Exception("Error! Enter correct operator");
            case '-':
                answer = number1 - number2;
                return answer;
            case '/':
                if (number2 == 0.0) {
                    throw new Exception("Error! Division by zero !");
                } else {
                    answer = number1 / number2;
                    return answer;
                }
        }
    }
}
