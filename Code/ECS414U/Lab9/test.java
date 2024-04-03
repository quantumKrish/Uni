package ECS414U.Lab9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class test {

    public static void main(String[] args) {
        
        loadLevel();
    }

    
    public static void loadLevel() {

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\kiris\\OneDrive\\Documents\\GitHub\\Uni\\Code\\ECS414U\\Lab9\\levelSave.txt"))) {
            
            String line;

            while ((line = reader.readLine()) != null) {

                System.out.println(line);
            }

        } catch (FileNotFoundException e) {

            System.out.println("File not found: " + e.getMessage());
            
        } catch (IOException e) {

            System.out.println("IOException: " + e.getMessage());
        }



    }
    
}
