package swingPractice;

import java.awt.Color;

import javax.swing.*;

public class JFramePractise {

    public static void main(String[] args) {

        JFrame frame = new JFrame("A JFrame with a JButton");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Use absolute positioning
        frame.setSize(300,300);

        JButton button = new JButton("Click me!");
        button.setSize(button.getPreferredSize());
        button.setBackground(Color.RED);
        button.setForeground(Color.WHITE);

        JTextField textField = new JTextField(15);
        textField.setSize(textField.getPreferredSize());
        textField.setLocation(40, 40);  
        button.setLocation(40, 90);
        frame.add(button);

        frame.setVisible(true);



    }
    
}
