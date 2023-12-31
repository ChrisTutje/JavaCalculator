/**
 * @author chris - chtutje@dmacc.edu
 * CIS175 - Fall 2023
 * Oct 28, 2023
 * Overview: This class contains several methods for arithmetic operations. 
 */
package model;

import java.util.List;
import java.util.ArrayList;

public class Calculator {
	public static double add(double... numbers) {
	    double result = 0;
	    for (double number : numbers) {
	        if (result == Double.POSITIVE_INFINITY || result > Double.MAX_VALUE - number) {
	            throw new ArithmeticException("Error: Result exceeds max value");
	        }
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
	        if (result == Double.NEGATIVE_INFINITY || result < Double.MIN_VALUE + numbers[i]) {
	            throw new ArithmeticException("Error: Result exceeds min value");
	        }
	        result -= numbers[i];
	    }

	    return result;
	}

    public static double multiply(double... numbers) {
        double result = 1;
        for (double number : numbers) {
            if (result > Double.MAX_VALUE / Math.abs(number)) {
                throw new ArithmeticException("Error: Result exceeds max value");
            }
            result *= number;
        }
        return result;
    }

    
    public static double divide(double... numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("No numbers provided.");
        }

        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                throw new IllegalArgumentException("Error: Dividing by 0");
            }
            result /= numbers[i];
        }
        return result;
    }

    public static double exponent(double base, double power) {
        double result = Math.pow(base, power);

        if (Double.isInfinite(result) || Double.isNaN(result)) {
            throw new ArithmeticException("Error: Max value exceeded");
        }

        return result;
    }

    public static double reciprocal(double base, double power) {
        return Math.pow(base, -power);
    }

    public static double floorDivide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Error: Dividing by 0");
        }
        return (double) Math.floor(a / b);
    }


    public static double modulo(double a, double b) {
        if (b == 0) {
        	throw new IllegalArgumentException("Error: Modulo by 0");
        }
        return a % b;
    }
    
    public static double negative(double number) {
        return -number;
    }
    
    public static double factorial(double num) {
        if (Double.isInfinite(num)) {
            throw new IllegalArgumentException("Stop it. Get some help :(");
        }

        if (num < 0) {
            throw new IllegalArgumentException("Error: Negative factorials are hard :(");
        }
        
        if (num == Double.MAX_VALUE) {
        	throw new ArithmeticException("Factorial result too large");
        }

        double result = 1;
        for (int i = 1; i <= num; i++) {
            if (result * i > Double.MAX_VALUE) {
                throw new ArithmeticException("Error: Number too big");
            }
            result *= i;
        }
        return result;
    }
    
    public static double Root(double num, double rootDegree) {
        if (num < 0 && rootDegree % 2 == 0) {
            throw new IllegalArgumentException("Error: imaginary numbers are too complex");
        }
        return Math.pow(num, 1.0 / rootDegree);
    }
    
    public static double permutate(double num) {
        if (Double.isInfinite(num)) {
            throw new IllegalArgumentException("Stop it. Get some help :(");
        }

        if (num < 0) {
            throw new IllegalArgumentException("Error: Negative permutations r 2 hard :(");
        }

        double result = 0;
        for (int i = 1; i <= num; i++) {
            if (result + i > Double.MAX_VALUE) {
                throw new ArithmeticException("Error: Result too big");
            }
            result += i;
        }
        return result;
    }
    
    public static List<Integer> primeFactorization(int number) {
        List<Integer> primeFactors = new ArrayList<>();

        if (number < 2) {
            throw new IllegalArgumentException("Prime factorization is not defined for numbers less than 2.");
        }

        for (int i = 2; i <= number; i++) {
            while (number % i == 0) {
                primeFactors.add(i);
                number /= i;
            }
        }

        return primeFactors;
    }
}


