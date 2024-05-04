package swingPractice.lab10;

import javax.swing.*;
import java.awt.*;

public class lab10q1 {

    public static void main(String[] args) {

        calc();
        
    }

    public static void calc() {

        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextField display = new JTextField();
        display.setPreferredSize(new Dimension(300, 50));
        display.setEditable(true);
        display.setHorizontalAlignment(JTextField.RIGHT);
        panel.add(display, BorderLayout.NORTH);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(5, 4, 5, 5));

        String[] buttonLabels = {
                "Ans", "&", "^", "%",
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "C", "0", "=", "+"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            buttonsPanel.add(button);

            button.addActionListener(e -> {
                String text = display.getText();
                String buttonText = button.getText();

                if (buttonText.equals("C")) {
                    display.setText("");
                } else if (buttonText.equals("=")) {
                    display.setText("Calulating...");

                } else {
                    display.setText(text + buttonText);
                }
            });

        }

        panel.add(buttonsPanel, BorderLayout.CENTER);


        frame.getContentPane().add(panel);
        frame.setVisible(true);

    }

}
