/**
 * @author chris - chtutje@dmacc.edu
 * CIS175 - Fall 2023
 * Oct 28, 2023
 */
package main;
import java.util.Scanner;
import model.Calculator;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Simple Calculator");
        System.out.println("Enter two numbers: ");
        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();

        System.out.println("Select operation (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        double result;

        switch (operator) {
            case '+':
                result = Calculator.add(num1, num2);
                break;
            case '-':
                result = Calculator.subtract(num1, num2);
                break;
            case '*':
                result = Calculator.multiply(num1, num2);
                break;
            case '/':
                result = Calculator.divide(num1, num2);
                break;
            default:
                System.out.println("Invalid operator.");
                return;
        }

        System.out.println("Result: " + result);
    }
}