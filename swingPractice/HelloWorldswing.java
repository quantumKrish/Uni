package swingPractice;

import java.awt.*;
import javax.swing.*;

public class HelloWorldswing {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setTitle("Hello World!");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}