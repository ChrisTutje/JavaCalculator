/**
 * @author chris - chtutje@dmacc.edu
 * CIS175 - Fall 2023
 * Nov 12, 2023
 * Overview: This is an unused class for the StringOperator
 */
package model;

public class StringOperator {
	
	public static String concatenate(String str1, String str2) {
	    return str1 + str2;
	}
	
	public static String substringSubtract(String base, String toRemove) {
        if (base == null || toRemove == null) {
            return "Invalid input";
        }

        int index = base.indexOf(toRemove);

        if (index != -1) {
            return base.substring(0, index) + base.substring(index + toRemove.length());
        } else {
            return base;
        }
    }
}

