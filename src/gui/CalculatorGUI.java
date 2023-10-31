/**
 * @author chris - chtutje@dmacc.edu
 * CIS175 - Fall 2023
 * Oct 30, 2023
 */
package gui;

import model.Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI {
    private JFrame frame;
    private JTextField inputField;
    private JButton[] numberButtons;
    private JButton[] operationButtons;
    private JButton equalsButton;
    private JButton clearButton;

    private double num1 = 0;
    private String operator = "";
    private boolean startNewInput = true;

    public CalculatorGUI() {
        frame = new JFrame("Calculator");
        frame.setLayout(new BorderLayout());

        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 24));
        inputField.setHorizontalAlignment(SwingConstants.RIGHT);
        inputField.setEditable(false);

        frame.add(inputField, BorderLayout.NORTH);

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.PLAIN, 24));
        }

        operationButtons = new JButton[9];  // Adjust the array size to accommodate new operations
        operationButtons[0] = new JButton("+");
        operationButtons[1] = new JButton("-");
        operationButtons[2] = new JButton("*");
        operationButtons[3] = new JButton("/");
        operationButtons[4] = new JButton("**");  // Exponents
        operationButtons[5] = new JButton("-**");  // Reciprocal Exponents
        operationButtons[6] = new JButton("//");  // Floor Division
        operationButtons[7] = new JButton("%");  // Modulo
        operationButtons[8] = new JButton("=");  // Equals

        for (JButton button : operationButtons) {
            button.setFont(new Font("Arial", Font.PLAIN, 24));
        }

        clearButton = new JButton("C");
        clearButton.setFont(new Font("Arial", Font.PLAIN, 24));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 5));

        buttonPanel.add(numberButtons[7]);
        buttonPanel.add(numberButtons[8]);
        buttonPanel.add(numberButtons[9]);
        buttonPanel.add(operationButtons[0]); //+
        buttonPanel.add(operationButtons[1]); //-

        buttonPanel.add(numberButtons[4]);
        buttonPanel.add(numberButtons[5]);
        buttonPanel.add(numberButtons[6]);
        buttonPanel.add(operationButtons[2]); //*
        buttonPanel.add(operationButtons[3]); // /

        buttonPanel.add(numberButtons[1]);
        buttonPanel.add(numberButtons[2]);
        buttonPanel.add(numberButtons[3]);
        buttonPanel.add(operationButtons[6]); // //
        buttonPanel.add(operationButtons[7]); // %

        buttonPanel.add(numberButtons[0]);
        buttonPanel.add(clearButton); //C
        buttonPanel.add(operationButtons[8]); // =
        buttonPanel.add(operationButtons[4]); // **
        buttonPanel.add(operationButtons[5]); // -**

        frame.add(buttonPanel, BorderLayout.CENTER);

        for (JButton button : numberButtons) {
            button.addActionListener(new NumberButtonListener());
        }
        for (JButton button : operationButtons) {
            button.addActionListener(new OperationButtonListener());
        }

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inputField.setText("");
                num1 = 0;
                operator = "";
                startNewInput = true;
            }
        });

        equalsButton = new JButton("=");
        equalsButton.setFont(new Font("Arial", Font.PLAIN, 24));
        //frame.add(equalsButton, BorderLayout.SOUTH);
        equalsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                if (!input.isEmpty() && !operator.isEmpty()) {
                    double num2 = Double.parseDouble(input);
                    double result = 0;
                    switch (operator) {
                        case "+":
                            result = Calculator.add(num1, num2);
                            break;
                        case "-":
                            result = Calculator.subtract(num1, num2);
                            break;
                        case "*":
                            result = Calculator.multiply(num1, num2);
                            break;
                        case "/":
                            result = Calculator.divide(num1, num2);
                            break;
                        case "**":
                            result = Calculator.exponent(num1, num2);
                            break;
                        case "-**":
                            result = Calculator.reciprocal(num1, num2);
                            break;
                        case "//":
                            result = Calculator.floorDivide(num1, num2);
                            break;
                        case "%":
                            result = Calculator.modulo(num1, num2);
                            break;
                    }
                    inputField.setText(String.valueOf(result));
                    num1 = result;
                    operator = "";
                    startNewInput = true;
                }
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    class NumberButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String buttonText = button.getText();
            if (startNewInput) {
                inputField.setText(buttonText);
                startNewInput = false;
            } else {
                inputField.setText(inputField.getText() + buttonText);
            }
        }
    }

    class OperationButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String buttonText = button.getText();
            if (!operator.isEmpty() && !startNewInput) {
                equalsButton.doClick();
            }
            operator = buttonText;
            num1 = Double.parseDouble(inputField.getText());
            startNewInput = true;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalculatorGUI();
            }
        });
    }
}



