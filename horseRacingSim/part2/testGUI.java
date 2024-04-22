package horseRacingSim.part2;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class testGUI extends JFrame {

    public testGUI
() {
        setTitle("Simulator");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton startButton = new JButton("Start Simulator");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkAndCreateFiles()) {
                    JOptionPane.showMessageDialog(testGUI
                .this, "Files checked and created successfully.");
                    // Close current window and open a new one
                    dispose();
                    openMainMenu();
                } else {
                    JOptionPane.showMessageDialog(testGUI
                .this, "Failed to check or create files.");
                }
            }
        });

        add(startButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private boolean checkAndCreateFiles() {

        String folderPath = "C:\\HorseRaceSimulator\\part2\\saveFiles";
        File horseFile = new File(folderPath + "\\horseDetails.txt");
        File raceFile = new File(folderPath + "\\raceDetails.txt");

        try {

            // Create the directory if it doesn't exist
            File folder = new File(folderPath);
            if (!folder.exists()) {
                if (folder.mkdirs()) {
                    System.out.println("Folder created: " + folder.getAbsolutePath());
                } else {
                    System.out.println("Failed to create folder: " + folder.getAbsolutePath());
                    return false;
                }
            }

            if (!horseFile.exists()) {
                if (horseFile.createNewFile()) {
                    System.out.println("Horse file created: " + horseFile.getAbsolutePath());
                } else {
                    System.out.println("Failed to create horse file: " + horseFile.getAbsolutePath());
                    return false;
                }
            }

            if (!raceFile.exists()) {
                if (raceFile.createNewFile()) {
                    System.out.println("Race file created: " + raceFile.getAbsolutePath());
                } else {
                    System.out.println("Failed to create race file: " + raceFile.getAbsolutePath());
                    return false;
                }
            }

            return true;
            
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void openMainMenu() {
        JFrame newFrame = new JFrame("Horse Racing Simulator");
        newFrame.setSize(400, 300);
        newFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        newFrame.setLocationRelativeTo(null);
        newFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new testGUI
            ();
            }
        });
    }
}
