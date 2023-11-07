package gui;

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

public class ListOperatorGUI {
    private JFrame listFrame;
    private JTextField inputField;
    private JButton[] numberButtons;
    private JButton clearButton;
    private JButton displayButton;
    private JButton appendButton;
    private JButton popButton;
    private JButton meanButton;
    private JButton medianButton;
    private JButton modeButton;
    private JButton decimalButton;
    private JButton negativeButton;
    private JButton removeAllButton;
    private JButton helpButton;
    private JButton sumButton;       
    private JButton differenceButton; 
    private JButton productButton;    
    private JButton quotientButton;
    
    private ListOperator listOperator;

    public ListOperatorGUI() {
        listFrame = new JFrame("List Operations");
        listFrame.setLayout(new BorderLayout());

        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 24));
        inputField.setHorizontalAlignment(SwingConstants.RIGHT);
        inputField.setEditable(false);

        listOperator = new ListOperator();

        numberButtons = new JButton[10];
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
        
        JButton blankButton = new JButton("");
        JButton blankButton1 = new JButton("");
        JButton blankButton2 = new JButton("");
        JButton blankButton3 = new JButton("");
        JButton blankButton4 = new JButton("");
        JButton blankButton5 = new JButton("");
        JButton blankButton6 = new JButton("");
        JButton blankButton7 = new JButton("");
        JButton blankButton8 = new JButton("");
        JButton blankButton9 = new JButton("");
        JButton blankButton10 = new JButton("");
        JButton blankButton11 = new JButton("");
        JButton blankButton12 = new JButton("");
        JButton blankButton13 = new JButton("");
        JButton blankButton14 = new JButton("");

        clearButton = new JButton("C");
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

        meanButton = new JButton("AVG");
        meanButton.setFont(new Font("Arial", Font.PLAIN, 24));
        meanButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double mean = listOperator.Mean();
                JOptionPane.showMessageDialog(listFrame, "Mean: " + mean, "Result", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        medianButton = new JButton("MED");
        medianButton.setFont(new Font("Arial", Font.PLAIN, 24));
        medianButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double median = listOperator.Median();
                JOptionPane.showMessageDialog(listFrame, "Median: " + median, "Result", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        modeButton = new JButton("Mode");
        modeButton.setFont(new Font("Arial", Font.PLAIN, 24));
        modeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                List<Double> modeList = listOperator.Mode();
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
        
        sumButton = new JButton("+ *");                 
        sumButton.setFont(new Font("Arial", Font.PLAIN, 24));
        sumButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double sum = listOperator.Sum();
                JOptionPane.showMessageDialog(listFrame, "Sum: " + sum, "Result", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        differenceButton = new JButton("- *");   
        differenceButton.setFont(new Font("Arial", Font.PLAIN, 24));
        differenceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double difference = listOperator.Difference();
                JOptionPane.showMessageDialog(listFrame, "Difference: " + difference, "Result", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        productButton = new JButton("* *");         
        productButton.setFont(new Font("Arial", Font.PLAIN, 24));
        productButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double product = listOperator.Product();
                JOptionPane.showMessageDialog(listFrame, "Product: " + product, "Result", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        quotientButton = new JButton("/ *");       
        quotientButton.setFont(new Font("Arial", Font.PLAIN, 24));
        quotientButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double quotient = listOperator.Quotient();
                JOptionPane.showMessageDialog(listFrame, "Quotient: " + quotient, "Result", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 5));
        
        buttonPanel.add(helpButton);
        buttonPanel.add(blankButton1);
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
        buttonPanel.add(blankButton7);
        buttonPanel.add(blankButton8);
        
        buttonPanel.add(numberButtons[1]);
        buttonPanel.add(numberButtons[2]);
        buttonPanel.add(numberButtons[3]);
        buttonPanel.add(meanButton);
        buttonPanel.add(medianButton);
        
        buttonPanel.add(numberButtons[0]);
        buttonPanel.add(decimalButton);
        buttonPanel.add(negativeButton);
        buttonPanel.add(modeButton);
        buttonPanel.add(blankButton14);
        
        buttonPanel.add(sumButton);             
        buttonPanel.add(differenceButton);
        buttonPanel.add(productButton);          
        buttonPanel.add(quotientButton);
        buttonPanel.add(blankButton13);
        

        listFrame.add(inputField, BorderLayout.NORTH);
        listFrame.add(buttonPanel, BorderLayout.CENTER);

        listFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        listFrame.setSize(400, 400);
    }

    public void showListOperatorWindow() {
        listFrame.setVisible(true);
    }
    
    private String loadInstructionsFromFile(String fileName) {
        try {
            InputStream inputStream = CalculatorGUI.class.getResourceAsStream(fileName);
            
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ListOperatorGUI();
            }
        });
    }
}
