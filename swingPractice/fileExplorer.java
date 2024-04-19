package swingPractice;

import javax.swing.*;
import java.awt.*;

public class fileExplorer {

    public static void main(String[] args) {
        
        main();
    }


    public static void main() {

        JFrame frame = new JFrame();
        frame.setTitle("Skibidoi File Explorer");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        //================================================= MENUv ============================================//

        // Creates a menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu viewMenu = new JMenu("View");
        JMenu helpMenu = new JMenu("Help");


        // Creates menu items for the file menu
        JMenuItem fileItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(fileItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        // Creates menu items for the edit menu
        JMenuItem cutItem = new JMenuItem("Cut");
        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem pasteItem = new JMenuItem("Paste");
        JMenuItem deleteItem = new JMenuItem("Delete");
        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);   
        editMenu.add(deleteItem);

        // Creates menu items for the view menu
        JMenuItem listItem = new JMenuItem("List View");
        JMenuItem iconItem = new JMenuItem("Icon View");
        viewMenu.add(listItem);
        viewMenu.add(iconItem);

        // Creates menu items for the help menu
        JMenuItem aboutItem = new JMenuItem("About");
        JMenuItem helpItem = new JMenuItem("Help Contents");
        helpMenu.add(aboutItem);
        helpMenu.add(helpItem);

        // Adds the menu items to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);
        menuBar.add(helpMenu);
        frame.setJMenuBar(menuBar);


        //============================================== MENU^ vTOOLBAR ============================================//


        JPanel toolBar = new JPanel();
        toolBar.setName("Toolbar: ");
        toolBar.setBackground(Color.lightGray);
        toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel label = new JLabel("Toolbar");
        toolBar.add(label);
        frame.getContentPane().add(toolBar, BorderLayout.NORTH);


        JButton open = new JButton("Open");
        JButton newFolder = new JButton("New Folder");
        JButton delete = new JButton("Delete");

        toolBar.add(open);
        toolBar.add(newFolder);
        toolBar.add(delete);

        JPanel folderPanelContainer = new JPanel();
        folderPanelContainer.setLayout(new BoxLayout(folderPanelContainer, BoxLayout.Y_AXIS));
        frame.getContentPane().add(folderPanelContainer, BorderLayout.CENTER);

        //============================================== TOOLBAR^ vNEW_FOLDER=========================================//


        newFolder.addActionListener(e -> {

            JFrame newFolderFrame = new JFrame();
            newFolderFrame.setTitle("New Folder");
            newFolderFrame.setSize(300, 200);
            newFolderFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            newFolderFrame.setLocationRelativeTo(null);

            JPanel newFolderPanel = new JPanel();
            newFolderPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

            JLabel folderNameLabel = new JLabel("Folder Name: ");
            JTextField folderNameField = new JTextField(15);
            JButton createButton = new JButton("Create");

            newFolderPanel.add(folderNameLabel);
            newFolderPanel.add(folderNameField);
            newFolderPanel.add(createButton);

            newFolderFrame.getContentPane().add(newFolderPanel);
            newFolderFrame.setVisible(true);

            createButton.addActionListener(e1 -> {
                String folderName = folderNameField.getText();
                if (folderName.isEmpty()) {
                    JOptionPane.showMessageDialog(newFolderFrame, "Please enter a folder name", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(newFolderFrame, "Folder created: " + folderName, "Success", JOptionPane.INFORMATION_MESSAGE);

                    // Create a panel for the folder
                    JPanel folderPanel = new JPanel();
                    folderPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                    JLabel folderLabel = new JLabel(folderName);
                    folderPanel.add(folderLabel);

                    // Add the folder panel to the container
                    folderPanelContainer.add(folderPanel);
                    folderPanelContainer.revalidate(); // Update the layout
                    folderPanelContainer.repaint();    // Repaint the container

                    newFolderFrame.dispose();
                }
            });

        });






        frame.setVisible(true);

    }
    
}
