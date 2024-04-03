package ECS414U.Lab9;

import java.io.*;
import java.util.Scanner;

class Level {
    private int level; 
    
    private Level(int level) {
        this.level = level;
    }

    public Level() {
        this.level = 0;
    }

    public void nextLevel() {
        this.level++;
    }

    public int getLevel() {
        return this.level;
    }

    public static Level loadLevel() {

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\kiris\\OneDrive\\Documents\\GitHub\\Uni\\Code\\ECS414U\\Lab9\\levelSave.txt"))) {
            
            String line = reader.readLine();

            return new Level(Integer.parseInt(line));            

        } catch (FileNotFoundException e) {

            System.out.println("File not found: " + e.getMessage());
            return new Level();

            
        } catch (IOException e) {

            System.out.println("IOException: " + e.getMessage());
            return new Level();

        }


    }

    public void saveLevel() {


        try (PrintWriter writer = new PrintWriter("C:\\Users\\kiris\\OneDrive\\Documents\\GitHub\\Uni\\Code\\ECS414U\\Lab9\\levelSave.txt")) {
            
            writer.println(this.level);
            
        } catch (FileNotFoundException e) {

            System.out.println("File not found: " + e.getMessage());
            
        } catch (IOException e) {

            System.out.println("IOException: " + e.getMessage());
        }
    }
    
}


public class lab9q1 {
    public static void main(String[] args) {
        String option = inputString("1) New Game\n2) Load Game");

        Level level = option.equals("1") ? new Level() : loadGame();

        String answer;
        do {
            answer = inputString("Do you want to progress to the next level? y/n?");

            if (answer.equals("y")) {
                level.nextLevel();
                System.out.println("You are on level " + level.getLevel());
            }
            else {
                level.saveLevel();
            }
        } while (answer.equals("y")); 
    }

    public static Level loadGame() {
        return Level.loadLevel();
    }

    public static String inputString(String message) {
        System.out.println(message);
        return new Scanner(System.in).nextLine();
    }



}