package gui;

import model.StringOperator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StringOperatorGUI {

    private JFrame frame;
    private JTextField inputField;
    private JButton helpButton;
    private JButton clearButton;


    public StringOperatorGUI() {
        frame = new JFrame("String Operations");
        frame.setLayout(new BorderLayout());

        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 24));
        inputField.setHorizontalAlignment(SwingConstants.RIGHT);

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
        JButton blankButton15 = new JButton("");
        JButton blankButton16 = new JButton("");
        JButton blankButton17 = new JButton("");
        JButton blankButton18 = new JButton("");
        JButton blankButton19 = new JButton("");
        JButton blankButton20 = new JButton("");
        JButton blankButton21 = new JButton("");
        JButton blankButton22 = new JButton("");
        JButton blankButton23 = new JButton("");
        JButton blankButton24 = new JButton("");
        
        helpButton = new JButton("?");
        helpButton.setFont(new Font("Arial", Font.PLAIN, 24));
        helpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String instructions = loadInstructionsFromFile("stringOperatorHelp.txt");
                JOptionPane.showMessageDialog(frame, instructions, "Instructions", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        clearButton = new JButton("C");
        clearButton.setFont(new Font("Arial", Font.PLAIN, 24));
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inputField.setText("");
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 5));
        
        buttonPanel.add(helpButton);
        buttonPanel.add(blankButton1);
        buttonPanel.add(blankButton2);
        buttonPanel.add(clearButton);
        buttonPanel.add(blankButton4);
        
        buttonPanel.add(blankButton5);
        buttonPanel.add(blankButton6);
        buttonPanel.add(blankButton7);
        buttonPanel.add(blankButton8);
        buttonPanel.add(blankButton9);
        
        buttonPanel.add(blankButton10);
        buttonPanel.add(blankButton11);
        buttonPanel.add(blankButton12);
        buttonPanel.add(blankButton13);
        buttonPanel.add(blankButton14);
        
        buttonPanel.add(blankButton15);
        buttonPanel.add(blankButton16);
        buttonPanel.add(blankButton17);
        buttonPanel.add(blankButton18);
        buttonPanel.add(blankButton19);
        
        buttonPanel.add(blankButton20);
        buttonPanel.add(blankButton21);
        buttonPanel.add(blankButton22);
        buttonPanel.add(blankButton23);
        buttonPanel.add(blankButton24);



        frame.add(inputField, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        
        setTooltipsWithDelay();

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 400);
    }

    public void showStringOperatorWindow() {
        frame.setVisible(true);
    }
    
    private void setTooltipsWithDelay() {
    	setTooltipWithDelay(helpButton, "Help");
    	setTooltipWithDelay(clearButton, "Clear");

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
    
    private String loadInstructionsFromFile(String fileName) {
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StringOperatorGUI();
            }
        });
    }
}
