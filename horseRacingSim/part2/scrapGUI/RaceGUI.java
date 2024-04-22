package horseRacingSim.part2.scrapGUI;

import javax.swing.*;

import horseRacingSim.part1.Horse;
import horseRacingSim.part1.Race;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RaceGUI extends JFrame {

    private JTextField raceDistanceField;
    private JTextField horse1NameField;
    private JTextField horse1SymbolField;
    private JTextField horse1ConfidenceField;
    private JTextField horse2NameField;
    private JTextField horse2SymbolField;
    private JTextField horse2ConfidenceField;
    private JTextField horse3NameField;
    private JTextField horse3SymbolField;
    private JTextField horse3ConfidenceField;
    private JTextArea raceResultsArea;

    private Race race;

    public RaceGUI() {
        super("Horse Racing Simulation");
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Enter Race Details"));

        raceDistanceField = new JTextField();
        inputPanel.add(new JLabel("Race Distance (meters):"));
        inputPanel.add(raceDistanceField);

        horse1NameField = new JTextField();
        inputPanel.add(new JLabel("Horse 1 Name:"));
        inputPanel.add(horse1NameField);

        horse1SymbolField = new JTextField();
        inputPanel.add(new JLabel("Horse 1 Symbol:"));
        inputPanel.add(horse1SymbolField);

        horse1ConfidenceField = new JTextField();
        inputPanel.add(new JLabel("Horse 1 Confidence (0-1):"));
        inputPanel.add(horse1ConfidenceField);

        horse2NameField = new JTextField();
        inputPanel.add(new JLabel("Horse 2 Name:"));
        inputPanel.add(horse2NameField);

        horse2SymbolField = new JTextField();
        inputPanel.add(new JLabel("Horse 2 Symbol:"));
        inputPanel.add(horse2SymbolField);

        horse2ConfidenceField = new JTextField();
        inputPanel.add(new JLabel("Horse 2 Confidence (0-1):"));
        inputPanel.add(horse2ConfidenceField);

        horse3NameField = new JTextField();
        inputPanel.add(new JLabel("Horse 3 Name:"));
        inputPanel.add(horse3NameField);

        horse3SymbolField = new JTextField();
        inputPanel.add(new JLabel("Horse 3 Symbol:"));
        inputPanel.add(horse3SymbolField);

        horse3ConfidenceField = new JTextField();
        inputPanel.add(new JLabel("Horse 3 Confidence (0-1):"));
        inputPanel.add(horse3ConfidenceField);

        JButton startRaceButton = new JButton("Start Race");
        startRaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startRace();
            }
        });

        raceResultsArea = new JTextArea(20, 50);
        raceResultsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(raceResultsArea);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(startRaceButton);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void startRace() {
        try {
            int raceDistance = Integer.parseInt(raceDistanceField.getText());

            Horse horse1 = new Horse(horse1SymbolField.getText().charAt(0), horse1NameField.getText(), Double.parseDouble(horse1ConfidenceField.getText()));
            Horse horse2 = new Horse(horse2SymbolField.getText().charAt(0), horse2NameField.getText(), Double.parseDouble(horse2ConfidenceField.getText()));
            Horse horse3 = new Horse(horse3SymbolField.getText().charAt(0), horse3NameField.getText(), Double.parseDouble(horse3ConfidenceField.getText()));

            race = new Race(raceDistance);
            race.addHorse(horse1, 1);
            race.addHorse(horse2, 2);
            race.addHorse(horse3, 3);

            // Clear previous race results
            raceResultsArea.setText("");

            // Start the race
            race.startRace();

            // Print final results
            raceResultsArea.append("Final Race Results:\n");
            raceResultsArea.append("----------------------------\n");
            raceResultsArea.append("Winner: " + race.getWinnerName() + "\n");

        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input! Please enter valid values.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RaceGUI();
            }
        });
    }
}
