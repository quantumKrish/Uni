package ECS414U.endTermPractice.practTest2.task2;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

import horseRacingSim.main;

public class task2 {

    public static void main(String[] args) {
        main();
    }

    public static void main() {
  
        analyseBooks();
    }


    

    public static void analyseBooks() {

        ArrayList<String> books = new ArrayList<String>();


        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\kiris\\OneDrive\\Documents\\GitHub\\Uni\\Code\\ECS414U\\endTermPractice\\practTest2\\task2\\books.txt"))) {
            String line;

            while((line = reader.readLine()) != null){

                books.add(line);

            }
        } catch (IOException e) {

            e.printStackTrace();
        }        

        try (PrintWriter writer = new PrintWriter("C:\\Users\\kiris\\OneDrive\\Documents\\GitHub\\Uni\\Code\\ECS414U\\endTermPractice\\practTest2\\task2\\results.txt")) {
            
            writer.println("Analysis Report:" );
            
        } catch (FileNotFoundException e) {

            System.out.println("File not found: " + e.getMessage());
            
        } catch (IOException e) {

            System.out.println("IOException: " + e.getMessage());
        }


        printAverage(books);
        printPopularGenre(books);
        printPopularAuthor(books);
    }

    public static void printAverage(ArrayList<String> books) {

        int total = 0;
        int count = 0;
        boolean error = false;

        for (int i = 0; i < books.size(); i++) {

            try {
                String[] bookRecord =  books.get(i).split(", ");
                total += Integer.parseInt(bookRecord[3]);
                count++; 

            } catch (Exception e) {
                System.out.println("Error: incorrect format in books.txt file in line " + i);
                error = true;
            }
        }

        if (!error) {
            System.out.println("Average publication year: " + total/count);
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter("C:\\Users\\kiris\\OneDrive\\Documents\\GitHub\\Uni\\Code\\ECS414U\\endTermPractice\\practTest2\\task2\\results.txt", true));) {
                    
            writer.println("Average publication year: " + total/count);
                    
        } catch (FileNotFoundException e) {

            System.out.println("File not found: " + e.getMessage());
                    
        } catch (IOException e) {

            System.out.println("IOException: " + e.getMessage());
        }
    }

    public static void printPopularGenre(ArrayList<String> books) {

        Map<String, Integer> genreFrequency = new HashMap<>();

        for (int i = 0; i < books.size(); i++) {

            String[] bookRecord =  books.get(i).split(", ");
            String genre = bookRecord[2];

            if (genreFrequency.containsKey(genre)) {

                genreFrequency.put(genre, genreFrequency.get(genre) + 1);

            } else {

                genreFrequency.put(genre, 1);  

            }        
        }

        Iterator<String> iterator = genreFrequency.keySet().iterator();
        int highestFrequency = 0;
        String highestFrequencyGenre =  "";

        
        while(iterator.hasNext()) {

            String key = iterator.next();
            int value = genreFrequency.get(key);

            if (value > highestFrequency) {
                highestFrequency = value;
                highestFrequencyGenre = key;

            }
        }
        System.out.println("Most popular genre: " + highestFrequencyGenre);

        try (PrintWriter writer = new PrintWriter(new FileWriter("C:\\Users\\kiris\\OneDrive\\Documents\\GitHub\\Uni\\Code\\ECS414U\\endTermPractice\\practTest2\\task2\\results.txt", true));) {
            
            writer.println("Most popular genre: " + highestFrequencyGenre);
            
        } catch (FileNotFoundException e) {

            System.out.println("File not found: " + e.getMessage());
            
        } catch (IOException e) {

            System.out.println("IOException: " + e.getMessage());
        }
    }
    


    public static void printPopularAuthor(ArrayList<String> books) {

        Map<String, Integer> authorFrequency = new HashMap<>();

        for (int i = 0; i < books.size(); i++) {

            String[] authorRecord =  books.get(i).split(", ");
            String author = authorRecord[1];

            if (authorFrequency.containsKey(author)) {

                authorFrequency.put(author, authorFrequency.get(author) + 1);

            } else {

                authorFrequency.put(author, 1);  

            }        
        }

        Iterator<String> iterator = authorFrequency.keySet().iterator();
        int highestFrequency = 0;
        String highestFrequencyGenre =  "";

        
        while(iterator.hasNext()) {

            String key = iterator.next();
            int value = authorFrequency.get(key);

            if (value > highestFrequency) {
                highestFrequency = value;
                highestFrequencyGenre = key;

            }
        }
        System.out.println("Most popular author: " + highestFrequencyGenre + " with " + highestFrequency + " books");

        try (PrintWriter writer = new PrintWriter(new FileWriter("C:\\Users\\kiris\\OneDrive\\Documents\\GitHub\\Uni\\Code\\ECS414U\\endTermPractice\\practTest2\\task2\\results.txt", true));) {
            
            writer.println("Most popular author: " + highestFrequencyGenre + " with " + highestFrequency + " books");
            
        } catch (FileNotFoundException e) {

            System.out.println("File not found: " + e.getMessage());
            
        } catch (IOException e) {

            System.out.println("IOException: " + e.getMessage());
        }
    }



    
}
