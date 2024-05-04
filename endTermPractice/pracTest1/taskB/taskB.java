package endTermPractice.pracTest1.taskB;

import java.io.*;

public class taskB {

    public static void main(String[] args) {


        calcAverage();
    }

    public static void calcAverage() {

        double total = 0;
        int lines = 0;


        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\kiris\\OneDrive\\Documents\\GitHub\\Uni\\Code\\ECS414U\\endTermPractice\\taskB\\grades.txt"))) {
            
            String line;

            while((line = reader.readLine()) != null){

                String[] characters = line.split(" ");
                total += Double.parseDouble(characters[2]);
                lines++;
            }            

        } catch (FileNotFoundException e) {

            System.out.println("File not found: " + e.getMessage());

            
        } catch (IOException e) {

            System.out.println("IOException: " + e.getMessage());

        }

        try (PrintWriter writer = new PrintWriter("C:\\Users\\kiris\\OneDrive\\Documents\\GitHub\\Uni\\Code\\ECS414U\\endTermPractice\\taskB\\average.txt")) {
            
            writer.println("Average: " + total/lines);
            
        } catch (FileNotFoundException e) {

            System.out.println("File not found: " + e.getMessage());
            
        } catch (IOException e) {

            System.out.println("IOException: " + e.getMessage());
        }

    }

}