package horseRacingSim;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class horseRacingGUI extends JFrame {
    private JTextArea consoleTextArea;
    private JScrollPane scrollPane;
    private JButton startButton;
    private Race race;

    public horseRacingGUI() {
        setTitle("Horse Racing Simulator");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        consoleTextArea = new JTextArea();
        consoleTextArea.setEditable(false);

        scrollPane = new JScrollPane(consoleTextArea);
        add(scrollPane, BorderLayout.CENTER);

        startButton = new JButton("Start Race");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startButton.setEnabled(false); // Disable button while race is running
                startRace();
            }
        });
        add(startButton, BorderLayout.SOUTH);
    }

    private void startRace() {
        // Redirect console output to JTextArea
        PrintStream printStream = new PrintStream(new CustomOutputStream(consoleTextArea));
        System.setOut(printStream);

        // Create a race object and start the race in a separate thread
        race = new Race(10); // Set race length to 100 for example
        Horse horse1 = new Horse("A", "Horse 1", 0.8);
        Horse horse2 = new Horse("B", "Horse 2", 0.7);
        Horse horse3 = new Horse("C", "Horse 3", 0.6);
        race.addHorse(horse1, 1);
        race.addHorse(horse2, 2);
        race.addHorse(horse3, 3);

        // Create a separate thread for the race
        Thread raceThread = new Thread(new Runnable() {
            public void run() {
                race.startRace();
                startButton.setEnabled(true); // Re-enable button after race is finished
            }
        });
        raceThread.start();
    }

    // Custom OutputStream to redirect console output to JTextArea
    private class CustomOutputStream extends OutputStream {
        private JTextArea textArea;

        public CustomOutputStream(JTextArea textArea) {
            this.textArea = textArea;
        }

        @Override
        public void write(int b) throws IOException {
            // Redirect data to the text area
            textArea.append(String.valueOf((char) b));
            // Move caret to the end of the text area to automatically scroll
            textArea.setCaretPosition(textArea.getDocument().getLength());
        }
    }

    public static void main(String[] args) {
        // Create and display the GUI
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                horseRacingGUI gui = new horseRacingGUI();
                gui.setVisible(true);
            }
        });
    }
}
