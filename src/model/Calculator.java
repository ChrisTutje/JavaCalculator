/**
 * @author chris - chtutje@dmacc.edu
 * CIS175 - Fall 2023
 * Oct 28, 2023
 */
package model;

public class Calculator {
    public static double add(double... numbers) {
        double result = 0;
        for (double number : numbers) {
            result += number;
        }
        return result;
    }

    public static double subtract(double... numbers) {
        if (numbers.length == 0) {
            return 0;
        }
        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result -= numbers[i];
        }
        return result;
    }

    public static double multiply(double... numbers) {
        double result = 1;
        for (double number : numbers) {
            result *= number;
        }
        return result;
    }

    public static double divide(double... numbers) {
        if (numbers.length == 0) {
            System.out.println("No numbers provided.");
            return 0;
        }

        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                System.out.println("Cannot divide by zero.");
                return 0;
            }
            result /= numbers[i];
        }
        return result;
    }

    public static double exponent(double base, double power) {
        return Math.pow(base, power);
    }

    public static double reciprocal(double base, double power) {
        return Math.pow(base, -power);
    }

    public static double floorDivide(double a, double b) {
        return (double) Math.floor(a / b);
    }

    public static double modulo(double a, double b) {
        if (b == 0) {
            System.out.println("Cannot perform modulo with a divisor of zero.");
            return 0;
        }
        return a % b;
    }
    
    public static double negative(double number) {
        return -number;
    }
}


