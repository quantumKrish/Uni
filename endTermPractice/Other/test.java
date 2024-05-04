package endTermPractice.Other;
import java.io.*;

public class test{
    public static void main(String [] a)
    {
        printFile();
    }

    public static void printFile()
    {
        // File object to represent the file in the program
        File inp = new File("C:\\Users\\kiris\\OneDrive\\Documents\\GitHub\\Uni\\Code\\ECS414U\\endTermPractice\\Other\\input.txt");

        try (// FileReader object to read the file
        FileReader fileReader = new FileReader(inp)) {
            // Wrap FileReader in BufferedReader to read the file line by line
            BufferedReader reader = new BufferedReader(fileReader);

            // String to store the line read from the file
            String line = "";

            // For each reader.readLine() call, reader advances to next line untill null is returned (end of file)
            while ((line = reader.readLine()) != null) 
            {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}