/**
 * @author chris - chtutje@dmacc.edu
 * CIS175 - Fall 2023
 * Nov 2, 2023
 */
package testing;

import static org.junit.Assert.*;
import org.junit.Test;
import model.Calculator;

public class CalculatorTester {

    @Test
    public void testAdd() {
        assertEquals(4.0, Calculator.add(2.0, 2.0), 0.001);
        try {
            Calculator.add(Double.POSITIVE_INFINITY, 1.0);
            fail("Expected ArithmeticException for adding infinity, but no exception was thrown.");
        } catch (ArithmeticException e) {
            assertEquals("Error: Result exceeds max value", e.getMessage());
        }
    }

    @Test
    public void testSubtract() {
        assertEquals(0.0, Calculator.subtract(2.0, 2.0), 0.001);
    }

    @Test
    public void testMultiply() {
        assertEquals(4.0, Calculator.multiply(2.0, 2.0), 0.001);
        try {
        Calculator.multiply(Double.MAX_VALUE, 2.0);
        fail("Expected ArithmeticException for exceeding maximum value, but no exception was thrown.");
    } catch (ArithmeticException e) {
        assertEquals("Error: Result exceeds max value", e.getMessage());
    }
    }

    @Test
    public void testDivide() {
        assertEquals(1.0, Calculator.divide(2.0, 2.0), 0.001);
        try {
            Calculator.divide(2.0, 0.0);
            fail("Expected IllegalArgumentException for dividing by zero, but no exception was thrown.");
        } catch (IllegalArgumentException e) {
            assertEquals("Error: Dividing by 0", e.getMessage());
        }
    }

    @Test
    public void testExponent() {
        assertEquals(4.0, Calculator.exponent(2.0, 2.0), 0.001);
        try {
            Calculator.exponent(Double.MAX_VALUE, 2.0);
            fail("Expected ArithmeticException for infinite result, but no exception was thrown.");
        } catch (ArithmeticException e) {
            assertEquals("Error: Max value exceeded", e.getMessage());
        }
    }

    @Test
    public void testReciprocal() {
        assertEquals(0.25, Calculator.reciprocal(2.0, 2.0), 0.001);
    }

    @Test
    public void testFloorDivide() {
        assertEquals(1.0, Calculator.floorDivide(2.0, 2.0), 0.001);
        try {
            Calculator.floorDivide(2.0, 0.0);
            fail("Expected IllegalArgumentException for dividing by zero, but no exception was thrown.");
        } catch (IllegalArgumentException e) {
            assertEquals("Error: Dividing by 0", e.getMessage());
        }
    }

    @Test
    public void testModulo() {
        assertEquals(0.0, Calculator.modulo(2.0, 2.0), 0.001);
        try {
            Calculator.modulo(2.0, 0.0);
            fail("Expected IllegalArgumentException for division by zero");
        } catch (IllegalArgumentException e) {
            assertEquals("Error: Modulo by 0", e.getMessage());
        }
    }

    @Test
    public void testNegative() {
        assertEquals(-2.0, Calculator.negative(2.0), 0.001);
    }
    
    @Test
    public void testFactorial() {
        double result = Calculator.factorial(3);
        assertEquals(6, result, 0);
        
        assertThrows(IllegalArgumentException.class, () -> {
            Calculator.factorial(Double.POSITIVE_INFINITY);
        });
            
        assertThrows(ArithmeticException.class, () -> {
            Calculator.factorial(Double.MAX_VALUE);
            });
    }
    @Test
    public void testRoot() {
        assertEquals(2.0, Calculator.Root(4.0, 2.0), 0.001);
        
        try {
            Calculator.Root(-1.0, 2.0);
            fail("Expected IllegalArgumentException for i");
        } catch (IllegalArgumentException e) {
            assertEquals("Error: imaginary numbers are too complex", e.getMessage());
        }
    }
    
    @Test
    public void testPermutate() {
        Calculator calculator = new Calculator();
        double result = calculator.permutate(2);
        assertEquals(3, result, 0);
        
        try {
            Calculator.permutate(-2.0);
            fail("Expected IllegalArgumentException for negative permutation");
        } catch (IllegalArgumentException e) {
            assertEquals("Error: Negative permutations r 2 hard :(", e.getMessage());
        }
    }
}

	
