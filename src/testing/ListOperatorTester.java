/**
 * @author chris - chtutje@dmacc.edu
 * CIS175 - Fall 2023
 * Nov 11, 2023
 */
package testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import model.ListOperator;

import org.junit.Before;
import org.junit.Test;

public class ListOperatorTester {

    private ListOperator listOperator;

    @Before
    public void setUp() {
        listOperator = new ListOperator();
    }

    @Test
    public void testAppend() {
        listOperator.append(1.0);
        listOperator.append(2.0);
        listOperator.append(3.0);
        assertEquals("1.0, 2.0, 3.0", listOperator.getListAsString());
    }

    @Test
    public void testPop() {
        listOperator.append(1.0);
        listOperator.append(2.0);
        listOperator.append(3.0);
        listOperator.pop();
        assertEquals("1.0, 2.0", listOperator.getListAsString());
    }

    @Test
    public void testSort() {
        listOperator.append(3.0);
        listOperator.append(2.0);
        listOperator.append(1.0);
        listOperator.sort();
        assertEquals("1.0, 2.0, 3.0", listOperator.getListAsString());
    }

   /* @Test
    public void testShuffle() {
        listOperator.append(1.0);
        listOperator.append(2.0);
        listOperator.append(3.0);
        listOperator.shuffle();
        assertTrue(listOperator.getListAsString().contains("1.0, 2.0, 3.0")); 
    } */


    @Test
    public void testLength() {
        listOperator.append(1.0);
        listOperator.append(2.0);
        listOperator.append(3.0);
        assertEquals(3, listOperator.getLength());
    }

   /* @Test
    public void testStandardDeviation() {
        listOperator.append(1.0);
        listOperator.append(2.0);
        listOperator.append(3.0);
        assertEquals(1.0, listOperator.calculateStandardDeviation(), 0.001);
    } */

    @Test
    public void testDelta() {
        listOperator.append(1.0);
        listOperator.append(2.0);
        listOperator.append(3.0);
        assertEquals("1.0", listOperator.calculateDelta());
    }
    
    @Test
    public void testSum() {
        listOperator.append(1.0);
        listOperator.append(2.0);
        listOperator.append(3.0);
        assertEquals(6.0, listOperator.calculateSum(), 0.001);
    }

    @Test
    public void testDifference() {
        listOperator.append(1.0);
        listOperator.append(2.0);
        listOperator.append(3.0);
        assertEquals(-4.0, listOperator.calculateDifference(), 0.001);
    }

    @Test
    public void testProduct() {
        listOperator.append(1.0);
        listOperator.append(2.0);
        listOperator.append(3.0);
        assertEquals(6.0, listOperator.calculateProduct(), 0.001);
        
        listOperator.append(Double.MAX_VALUE);
        try {
            listOperator.calculateProduct();
            fail("Expected ArithmeticException for exceeding maximum value, but no exception was thrown.");
        } catch (ArithmeticException e) {
            assertEquals("Error: Result exceeds maximum value", e.getMessage());
        }
    }
    

    @Test
    public void testQuotient() {
        listOperator.append(1.0);
        listOperator.append(2.0);
        listOperator.append(3.0);
        assertEquals(0.1666666667, listOperator.calculateQuotient(), 0.001);
        
        listOperator.append(0.0);
        
        try {
            listOperator.calculateQuotient();
            fail("Expected ArithmeticException for division by zero, but no exception was thrown.");
        } catch (ArithmeticException e) {
            assertEquals("Error: Dividing by 0", e.getMessage());
        }
    }

    @Test
    public void testMean() {
        listOperator.append(1.0);
        listOperator.append(2.0);
        listOperator.append(3.0);
        assertEquals(2.0, listOperator.calculateMean(), 0.001);
    }

    @Test
    public void testMedian() {
        listOperator.append(1.0);
        listOperator.append(2.0);
        listOperator.append(3.0);
        assertEquals(2.0, listOperator.calculateMedian(), 0.001);
    }

    @Test
    public void testMode() {
        listOperator.append(1.0);
        listOperator.append(2.0);
        listOperator.append(3.0);
        List<Double> modeList = listOperator.calculateMode();
        assertEquals(Arrays.asList(1.0, 2.0, 3.0), modeList);
    }

    @Test
    public void testRemoveAll() {
        listOperator.append(1.0);
        listOperator.append(2.0);
        listOperator.append(3.0);
        listOperator.removeAll();
        assertEquals("", listOperator.getListAsString());
    }

    @Test
    public void testMin() {
        listOperator.append(1.0);
        listOperator.append(2.0);
        listOperator.append(3.0);
        assertEquals(1.0, listOperator.getMin(), 0.001);
    }

    @Test
    public void testMax() {
        listOperator.append(1.0);
        listOperator.append(2.0);
        listOperator.append(3.0);
        assertEquals(3.0, listOperator.getMax(), 0.001);
    }

    @Test
    public void testRange() {
        listOperator.append(1.0);
        listOperator.append(2.0);
        listOperator.append(3.0);
        assertEquals(2.0, listOperator.getRange(), 0.001);
    }



}

