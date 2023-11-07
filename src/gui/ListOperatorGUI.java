package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
                    listOperator.appendToList(value);
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
                listOperator.popFromList();
            }
        });

        meanButton = new JButton("Mean");
        meanButton.setFont(new Font("Arial", Font.PLAIN, 24));
        meanButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double mean = listOperator.calculateMean();
                JOptionPane.showMessageDialog(listFrame, "Mean: " + mean, "Result", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        medianButton = new JButton("Median");
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
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 5));
        
        buttonPanel.add(blankButton);
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
        

        listFrame.add(inputField, BorderLayout.NORTH);
        listFrame.add(buttonPanel, BorderLayout.CENTER);

        listFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        listFrame.setSize(400, 400);
    }

    public void showListOperatorWindow() {
        listFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ListOperatorGUI();
            }
        });
    }
}
