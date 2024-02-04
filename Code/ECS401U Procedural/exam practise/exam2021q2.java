/*
    STEPS:
    
    1. ask user for danger level with message (between 0 and 800)
    2. start while loop that ends when 0 is typed
        2.1 ask for day of month (between 1 and 31)
        2.2 ask for reading 1 and store in record
        2.3 ask for reading 2 and store in record
        2.4 ask for reading 3 and store in record
        2.5 find highest number and store in record
        2.6 print warning message is its lower than danger level
        2.7 store that record into an array
        2.8 write the highest reading and day into a csv file
    3. loop through the array of records and print the 

*/


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class readings {
    int reading1;
    int reading2;
    int reading3;
    int highest;
    int day;
}
// end of readings class



public class exam2021q2 {

    public static void main (String[] args) throws IOException {

        asthmaDiary();

    }
    // end of main



    // controls loop and all functions
    //
    public static void asthmaDiary () throws IOException {

        // maximum number of days
        final int maxDays = 31;

        // create an array to store the records
        readings[] readingArray = new readings[maxDays];

        final int minBoundary = 0;
        final int maxBoundary = 31;
        final int dangerLvl = getDangerLvl ();

        int count = 0;

        int day = inputInt("What is the day (enter 0 to exit diary): ", minBoundary, maxBoundary); // asks for day- lets loop start or not

        while (day != 0 && count <= 31) {

            readingArray[count] = createDayRecord (day);
            checkDangerLvl(dangerLvl, count, readingArray);
            
            day = inputInt("What is the day (enter 0 to exit diary): ", minBoundary, maxBoundary); // lets loop continue or not
            count ++;
        }

        printReadings(count, readingArray);
        writeToCSV(readingArray, count);
        
    }
    // end of asthmaDiary



    // gets the danger level from the user
    //
    public static int getDangerLvl () {

        final int minBoundary = 1;
        final int maxBoundary = 800;
        int dangerLvl = inputInt("What is the number your doctor has given to you as being a dangerous reading? ", minBoundary, maxBoundary);
        
        return dangerLvl;
    }
    // end of getDangerLvl



    // To create a record for a single day
    //
    public static readings createDayRecord (int day) {

        final int minBoundary = 1;
        final int maxBoundary = 800;

        readings dayReadings = new readings();

        dayReadings.reading1 = inputInt ("First reading: ", minBoundary, maxBoundary);
        dayReadings.reading2 = inputInt ("Second reading: ", minBoundary, maxBoundary);
        dayReadings.reading3 = inputInt ("Third reading: ", minBoundary, maxBoundary);
        dayReadings.day = day;

        return dayReadings;
    }
    // end createEpisode



    // takes record, finds highest reading and stores it in the record
    //
    public static int getHighest (int dangerLvl, int count, readings[] readingArray) {

        int highest = 0;
        
        // finds the highest reading
        if (readingArray[count].reading1 > readingArray[count].reading2) {
            highest = readingArray[count].reading1;

        } else if (readingArray[count].reading2 > readingArray[count].reading3) {
            highest = readingArray[count].reading2;

        } else {
            highest = readingArray[count].reading3;
        }

        readingArray[count].highest = highest;

        return highest;
    }
    // end of getHighest



    // takes in the danger level and checks it against the highest reading, then outputs the appropiate response
    //
    public static void checkDangerLvl (int dangerLvl, int count, readings[] readingArray) {

        if (getHighest (dangerLvl, count, readingArray) > dangerLvl) {
            System.out.println ("You're good for this day :)");
        } else {
            System.out.println ("GO TO THE DOCTORS!!!");
        }
    }
    // end of checkDangerLvl


    // takes the day number and the highest reading and prints them into a csv file using a for loop
    //
    public static void writeToCSV (readings[] readingArray, int count) throws IOException { 

        PrintWriter reading_file = new PrintWriter (new FileWriter("asthma_dairy.csv")); // creates file if it don't exist

        for (int i=0; i < count; i++) {

            reading_file.println(readingArray[i].day + "," + readingArray[i].highest);
        }

        reading_file.close();
    } 
    // end of writeToCSV


    // loops through array of records taking the day value and highest reading value and outputs them to the user as a list
    //
    public static void printReadings (int count, readings[] readingArray) {

        System.out.println("/n");

        for (int i=0; i < count; i++) {

            System.out.println("Day: " + readingArray[i].day + "     Reading: " + readingArray[i].highest);
        }
    }
    // end of printReadings


// ----------------------------------------- INPUT METHODS ----------------------------------------- //

    // take user input and checks if its an int value- loops if it isn't
    //
    public static int inputInt (String message, int minBoundary, int maxBoundary) {

        Scanner scanner = new Scanner (System.in);
        int answer = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print(message);

            if (scanner.hasNextInt()) {
                answer = scanner.nextInt();
                if (answer >= minBoundary && answer <= maxBoundary) { // checks if input is an integer and between the boundaries (inclusive)
                    validInput = true; // valid input, exit the loop
                } else {
                    System.out.println("Invalid input. Please enter a valid integer within the specified range.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // consume the invalid input to avoid an infinite loop
            }
        }
        return answer;
    }
    // end inputInt
        

    public static String inputStr (String message) {

        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        String textinput = scanner.nextLine();
        
        return textinput;
    }
    // end inputString

// ------------------------------------------------------------------------------------------------- //
    
}
// end of exam2021q2 class
