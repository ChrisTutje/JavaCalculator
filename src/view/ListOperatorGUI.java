/**
 * @author chris - chtutje@dmacc.edu
 * CIS175 - Fall 2023
 * Oct 28, 2023
 * Overview: Creates the GUI for the List Operator window. 
 * It contains logic for buttons, input field, action listeners, grid layout, tooltips, filestreaming, and main.  
 */

package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import model.ListOperator;

public class ListOperatorGUI { //JButtons
    private JFrame listFrame;
    private JTextField inputField;
    private JButton[] numberButtons;
    private JButton decimalButton;
    private JButton negativeButton;
    
    private JButton helpButton;
    private JButton removeAllButton;
    private JButton clearButton;
    private JButton displayButton;
    
    private JButton appendButton;
    private JButton popButton;
    
    private JButton sortButton;
    private JButton shuffleButton;
    
    private JButton meanButton;
    private JButton medianButton;
    private JButton modeButton;
    private JButton stdDevButton;
    
    private JButton sumButton;       
    private JButton differenceButton; 
    private JButton productButton;    
    private JButton quotientButton;
    private JButton deltaButton;
    
    private JButton minButton;
    private JButton maxButton;
    private JButton rangeButton;
    private JButton lengthButton;
    
    private ListOperator listOperator;

    public ListOperatorGUI() { 
        listFrame = new JFrame("List Operations");
        listFrame.setLayout(new BorderLayout());

        inputField = new JTextField(); //input field
        inputField.setFont(new Font("Arial", Font.PLAIN, 24));
        inputField.setHorizontalAlignment(SwingConstants.RIGHT);
        inputField.setEditable(false);

        listOperator = new ListOperator();

        numberButtons = new JButton[10]; //digit buttons
        for (int i = 0; i < 10; i++) {
        	numberButtons[i] = new JButton(String.valueOf(i));
        	numberButtons[i].setFont(new Font("Arial", Font.PLAIN, 24));

            int digit = i;
            numberButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    inputField.setText(inputField.getText() + digit);
                }
            });
        }
        
        JButton blankButton = new JButton(""); //blankButtons used as placeholder buttons for planning layout
        JButton blankButton1 = new JButton("");

        clearButton = new JButton("C"); //buttons and action listeners
        clearButton.setFont(new Font("Arial", Font.PLAIN, 24));
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inputField.setText("");
            }
        });

        displayButton = new JButton("Display");
        displayButton.setFont(new Font("Arial", Font.PLAIN, 24));
        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inputField.setText(listOperator.getListAsString());
            }
        });

        appendButton = new JButton("[]+");
        appendButton.setFont(new Font("Arial", Font.PLAIN, 24));
        appendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double value = Double.parseDouble(inputField.getText());
                    listOperator.append(value);
                    inputField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(listFrame, "Invalid input. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        popButton = new JButton("[]-");
        popButton.setFont(new Font("Arial", Font.PLAIN, 24));
        popButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listOperator.pop();
            }
        });

        meanButton = new JButton("μ");
        meanButton.setFont(new Font("Arial", Font.PLAIN, 24));
        meanButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double mean = listOperator.calculateMean();
                JOptionPane.showMessageDialog(listFrame, "Mean: " + mean, "Result", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        medianButton = new JButton("Med");
        medianButton.setFont(new Font("Arial", Font.PLAIN, 24));
        medianButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double median = listOperator.calculateMedian();
                JOptionPane.showMessageDialog(listFrame, "Median: " + median, "Result", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        modeButton = new JButton("Mode");
        modeButton.setFont(new Font("Arial", Font.PLAIN, 24));
        modeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Double> modeList = listOperator.calculateMode();
                JOptionPane.showMessageDialog(listFrame, "Mode: " + modeList, "Result", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        decimalButton = new JButton(".");
        decimalButton.setFont(new Font("Arial", Font.PLAIN, 24));
        decimalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!inputField.getText().contains(".")) {
                    inputField.setText(inputField.getText() + ".");
                }
            }
        });
        
        negativeButton = new JButton("(-)");
        negativeButton.setFont(new Font("Arial", Font.PLAIN, 24));
        negativeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!inputField.getText().isEmpty()) {
                    double currentValue = Double.parseDouble(inputField.getText());
                    inputField.setText(String.valueOf(-currentValue));
                }
            }
        });
        
        removeAllButton = new JButton("-r*");
        removeAllButton.setFont(new Font("Arial", Font.PLAIN, 24));
        removeAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listOperator.removeAll(); 
                inputField.setText(""); 
            }
        });
        
        helpButton = new JButton("?");
        helpButton.setFont(new Font("Arial", Font.PLAIN, 24));
        helpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String instructions = loadInstructionsFromFile("listHelp.txt");
                JOptionPane.showMessageDialog(listFrame, instructions, "Instructions", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        sumButton = new JButton("\u2211"); //unicode is fun                 
        sumButton.setFont(new Font("Arial", Font.PLAIN, 24));
        sumButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double sum = listOperator.calculateSum();
                JOptionPane.showMessageDialog(listFrame, "Sum: " + sum, "Result", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        differenceButton = new JButton("-*");   
        differenceButton.setFont(new Font("Arial", Font.PLAIN, 24));
        differenceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double difference = listOperator.calculateDifference();
                JOptionPane.showMessageDialog(listFrame, "Difference: " + difference, "Result", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        productButton = new JButton("\u220F");         
        productButton.setFont(new Font("Arial", Font.PLAIN, 24));
        productButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double product = listOperator.calculateProduct();
                    JOptionPane.showMessageDialog(listFrame, "Product: " + product, "Result", JOptionPane.INFORMATION_MESSAGE);
                } catch (ArithmeticException ex) {
                    JOptionPane.showMessageDialog(listFrame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        quotientButton = new JButton("/*");       
        quotientButton.setFont(new Font("Arial", Font.PLAIN, 24));
        quotientButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double quotient = listOperator.calculateQuotient();
                    JOptionPane.showMessageDialog(listFrame, "Quotient: " + quotient, "Result", JOptionPane.INFORMATION_MESSAGE);
                } catch (ArithmeticException ex) {
                    JOptionPane.showMessageDialog(listFrame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        sortButton = new JButton("Sort");
        sortButton.setFont(new Font("Arial", Font.PLAIN, 24));
        sortButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listOperator.sort();
                inputField.setText(listOperator.getListAsString());
            }
        });
        
        shuffleButton = new JButton("Shuffle");
        shuffleButton.setFont(new Font("Arial", Font.PLAIN, 24));
        shuffleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listOperator.shuffle();
                inputField.setText(listOperator.getListAsString());
            }
        });
        
        minButton = new JButton("Min");
        minButton.setFont(new Font("Arial", Font.PLAIN, 24));
        minButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double min = listOperator.getMin();
                JOptionPane.showMessageDialog(listFrame, "Min: " + min, "Result", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        maxButton = new JButton("Max");
        maxButton.setFont(new Font("Arial", Font.PLAIN, 24));
        maxButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double max = listOperator.getMax();
                JOptionPane.showMessageDialog(listFrame, "Max: " + max, "Result", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        rangeButton = new JButton("Range");
        rangeButton.setFont(new Font("Arial", Font.PLAIN, 24));
        rangeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double range = listOperator.getRange();
                JOptionPane.showMessageDialog(listFrame, "Range: " + range, "Result", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        lengthButton = new JButton("Len");
        lengthButton.setFont(new Font("Arial", Font.PLAIN, 24));
        lengthButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int length = listOperator.getLength();
                JOptionPane.showMessageDialog(listFrame, "Length: " + length, "Result", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        stdDevButton = new JButton("σ");
        stdDevButton.setFont(new Font("Arial", Font.PLAIN, 24));
        stdDevButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double stdDev = listOperator.calculateStandardDeviation();
                JOptionPane.showMessageDialog(listFrame, "Standard Deviation: " + stdDev, "Result", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        deltaButton = new JButton("Δ");
        deltaButton.setFont(new Font("Arial", Font.PLAIN, 24));
        deltaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String deltaResult = listOperator.calculateDelta();
                JOptionPane.showMessageDialog(listFrame, "Delta: " + deltaResult, "Result", JOptionPane.INFORMATION_MESSAGE);
            }
        });
//======================================================================================================================================================================        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(7, 5)); //grid layout
        
        buttonPanel.add(helpButton);
        buttonPanel.add(blankButton);
        buttonPanel.add(removeAllButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(displayButton);
        
        buttonPanel.add(numberButtons[7]);
        buttonPanel.add(numberButtons[8]);
        buttonPanel.add(numberButtons[9]);
        buttonPanel.add(appendButton);
        buttonPanel.add(popButton);
        
        buttonPanel.add(numberButtons[4]);
        buttonPanel.add(numberButtons[5]);
        buttonPanel.add(numberButtons[6]);
        buttonPanel.add(sortButton);
        buttonPanel.add(shuffleButton);
        
        buttonPanel.add(numberButtons[1]);
        buttonPanel.add(numberButtons[2]);
        buttonPanel.add(numberButtons[3]);
        buttonPanel.add(meanButton);
        buttonPanel.add(medianButton);
        
        buttonPanel.add(numberButtons[0]);
        buttonPanel.add(decimalButton);
        buttonPanel.add(negativeButton);
        buttonPanel.add(modeButton);
        buttonPanel.add(stdDevButton);
        
        buttonPanel.add(sumButton);             
        buttonPanel.add(differenceButton);
        buttonPanel.add(productButton);          
        buttonPanel.add(quotientButton);
        buttonPanel.add(deltaButton);
        
        buttonPanel.add(minButton);
        buttonPanel.add(maxButton);
        buttonPanel.add(rangeButton);         
        buttonPanel.add(lengthButton);
        buttonPanel.add(blankButton1);
        

        listFrame.add(inputField, BorderLayout.NORTH);
        listFrame.add(buttonPanel, BorderLayout.CENTER);
        
        setTooltipsWithDelay();

        listFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        listFrame.setSize(400, 400);
    }

    public void showListOperatorWindow() {
        listFrame.setVisible(true);
    }
//======================================================================================================================================================================    
    private void setTooltipsWithDelay() { //tooltips
    	setTooltipWithDelay(numberButtons[0], "Zero");
        setTooltipWithDelay(numberButtons[1], "One");
        setTooltipWithDelay(numberButtons[2], "Two");
        setTooltipWithDelay(numberButtons[3], "Three");
        setTooltipWithDelay(numberButtons[4], "Four");
        setTooltipWithDelay(numberButtons[5], "Five");
        setTooltipWithDelay(numberButtons[6], "Six");
        setTooltipWithDelay(numberButtons[7], "Seven");
        setTooltipWithDelay(numberButtons[8], "Eight");
        setTooltipWithDelay(numberButtons[9], "Nine");
        setTooltipWithDelay(helpButton, "Help");
        setTooltipWithDelay(removeAllButton, "Remove All");
        setTooltipWithDelay(clearButton, "Clear");
        setTooltipWithDelay(displayButton, "Display");
        setTooltipWithDelay(appendButton, "Append");
        setTooltipWithDelay(popButton, "Pop, Remove From End");
        setTooltipWithDelay(sortButton, "Numerical Sort");
        setTooltipWithDelay(shuffleButton, "Shuffle");
        setTooltipWithDelay(meanButton, "Mean, Average");
        setTooltipWithDelay(medianButton, "Median");
        setTooltipWithDelay(modeButton, "Mode");
        setTooltipWithDelay(stdDevButton, "Standard Deviation");
        setTooltipWithDelay(decimalButton, "Decimal");
        setTooltipWithDelay(negativeButton, "Negative");
        setTooltipWithDelay(sumButton, "Sum");
        setTooltipWithDelay(differenceButton, "Difference");
        setTooltipWithDelay(productButton, "Product");
        setTooltipWithDelay(quotientButton, "Quotient");
        setTooltipWithDelay(minButton, "Minimim");
        setTooltipWithDelay(maxButton, "Maximum");
        setTooltipWithDelay(rangeButton, "Range");
        setTooltipWithDelay(lengthButton, "Length, Size");
        setTooltipWithDelay(deltaButton, "Delta");
    }
    
    private void setTooltipWithDelay(JButton button, String tooltip) {
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.setToolTipText(tooltip);
            }
        });
        timer.setRepeats(true); 
        timer.start();
    }
    
    private String loadInstructionsFromFile(String fileName) { //file streaming
        try {
        	InputStream inputStream = ListOperatorGUI.class.getResourceAsStream(fileName);
            
            if (inputStream != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder instructions = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    instructions.append(line).append("\n");
                }
                reader.close();
                return instructions.toString();
            } else {
                return "Instructions not found.";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error loading instructions.";
        }
    }

    public static void main(String[] args) { //main
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ListOperatorGUI();
            }
        });
    }
}
