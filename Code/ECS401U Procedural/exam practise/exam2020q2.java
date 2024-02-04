/*
    STEPS:

    1. start while loop (while counter is not 100 and stopFlag is false)
        1.1. ask user for train station name 
        1.2. ask user if station got step free access
        1.3. store both in record as String and boolean (true/false)
        1.4. store record in array
        1.5. ask user if they want to stop yes- stopFlag is true
    
    2. start while loop (while new stopFlag is false)

        2.1. ask if user wants to stop program yes- stopFlag is true
        2.2. ask user for a station

        2.3. search array of records to see if it exists
            2.3.2. if it does check if its got step free access
                2.3.2.1. if it does return statement
                2.3.2.2. if it dont return statement
            2.3.2. if it dont return statment

        2.4. loop through array of records and check step free access
            2.4.1 if station has step free access
                2.4.1.1. output the station name
*/


import java.util.Scanner;


class stations {
    String name = "";
    boolean stepAccess = true;
}
// end of stations class


public class exam2020q2 {

    public static void main(String[] args) {

        disabledTrains();

    }
    // end of main 


    public static void disabledTrains () {

        final int maxStations = 100; 
        int count = 0;
        stations[] stationsArray = new stations [maxStations];

        boolean stopFlag = false;
    
        while (stopFlag == false && count < maxStations) {
    
            stationsArray[count] = createStationRecord();
    
            if (getYesOrNoInput("Do you want to continue? ")) {
                count++;
            } else {
                stopFlag = true;
            }
        }        
        
        choicesLoop(count, stationsArray);


    }
    // end of disabledTrains


    // gets station details from the user using while loop and stores them in record and array of records
    //
    public static stations[] getStations(int maxStations, stations[] stationsArray, int count) {

        boolean stopFlag = false;
    
        while (stopFlag == false && count < maxStations) {
    
            stationsArray[count] = createStationRecord();
    
            if (getYesOrNoInput("Do you want to continue? ")) {
                count++;
            } else {
                stopFlag = true;
            }
        }
    
        return stationsArray;
    }
    
    // end of getStations


    // controls loops for the choices user can make- exit program, 
    //
    public static void choicesLoop (int count, stations[] stationsArray) {

        boolean stopFlag = false;

        stopFlag = getYesOrNoInput("Do you want to exit the program ? ");

        while(stopFlag == false) {

            if (getYesOrNoInput("Do you want to check if indivisual station has step free access? ")) {
                doesStationHaveAccess(count, stationsArray);

            }
        
            if (getYesOrNoInput("Do you want to see all train stations with step free access? ")) {
                getStepFreeStations(stationsArray, count);

            }

            stopFlag = getYesOrNoInput("Do you want to exit the program ? ");

        }
    }
    // end of choicesLoop


    // loops through record of arrays to check if station exists and if it does if it has step free access
    //
    public static void doesStationHaveAccess (int count, stations[] stationsArray) {

        boolean stopFlag = false;
        boolean flag = false;

        while (!stopFlag) {

            String station = getValidStringNoNumbers("Enter a station you want to check accessability: ");

            for (int i = 0; (i <= count && flag == false); i++) {


                // checks if station exists
                if ((stationsArray[i].name).equals(station)) {
                    flag = true;

                    // check if station has step free access
                    if (stationsArray[i].stepAccess) {
                        System.out.println("This station has step free access !!");

                    } else {
                        System.out.println("This station can't accomodate the crippled, bid sag :(");

                    }
                } 
            }

            // if station dont exist user can choose to try again or nor
            if (flag == false) {
                System.out.println("This station doesn't exist !!!");

            }

            if (!getYesOrNoInput("Do you want to try again? ")) {
                stopFlag = true;

            } else {
                flag = false;

            }
        }
    }
    // end of doesStationHaveAccess


    // gets the stations that have step free access from teh array of records
    //
    public static void getStepFreeStations (stations[] stationsArray, int count) {

        for(int i = 0; i <= count; i++) {

            if (stationsArray[i].stepAccess) {
                System.out.println(stationsArray[i].name);
            }
        }
    }
    // end of getStepFreeStations


    // creates the stations records using user inputs
    //
    public static stations createStationRecord () {

        stations stationRecord = new stations();

        stationRecord.name = getValidStringNoNumbers("\nEnter the name of the station: ");
        stationRecord.stepAccess = getYesOrNoInput("Does this station have step free access ?! ");

        return stationRecord;
    }
    // end of createStationRecords


// ----------------------------------------- INPUT METHODS ----------------------------------------- //


    // method to get a valid integer within a specified range, with optional infinity for upper and lower bounds
    //
    public static int getValidIntegerInRange(int min, int max, boolean upperInfinity, boolean lowerInfinity) {
        Scanner scanner = new Scanner(System.in);
        int value = Integer.MIN_VALUE; // Initialize with a value outside any reasonable range
        boolean isInRange = false;

        // continue loop until a valid input is received
        while (!((upperInfinity && lowerInfinity) || (upperInfinity && value >= min) || (lowerInfinity && value <= max) || (!upperInfinity && !lowerInfinity && value >= min && value <= max))) {

            System.out.println("Please enter an integer:");

            // inner loop to handle non-integer inputs
            while (!scanner.hasNextInt()) {

                System.out.println("Invalid input. Please enter an integer:");
                scanner.next(); // discard the invalid input

            }

            // get the integer input
            value = scanner.nextInt();

            // check if the input is within the specified range
            if (!((upperInfinity && lowerInfinity) || (upperInfinity && value >= min) || (lowerInfinity && value <= max) || (!upperInfinity && !lowerInfinity && value >= min && value <= max))) {
                System.out.println("Input not in range. Please try again.");
            }
        }

        return value;
    }
    // end of getValidIntegerInRange


    // method to get a valid string without any numbers
    //
    public static String getValidStringNoNumbers(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        String input = scanner.nextLine().trim();

        // continue loop until a valid input (no numbers) is received
        while (input.matches(".*\\d.*") || input.isEmpty()) {
            System.out.println("Invalid input. Please enter a string with no numbers:");
            input = scanner.nextLine().trim();
        }

        return input;
    }
    // end of getValidStringNoNumbersf


    // Method to get 'yes' or 'no' input with a custom message then returns true or false 
    //
    public static boolean getYesOrNoInput(String message) {
        Scanner scanner = new Scanner(System.in);
        String userInput = "";

        // Keep asking the user for input until a valid input is received
        while (!userInput.equals("yes") && !userInput.equals("no")) {
            System.out.print(message + " (enter 'yes' or 'no'): ");
            userInput = scanner.nextLine();

            // check if the input is valid
            if (!userInput.equals("yes") && !userInput.equals("no")) {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        }
        
        if (userInput.equals("yes")) {
            return true;

        } else {
            return false;
        }
    }
    // end of getYesOrNoInput

// ------------------------------------------------------------------------------------------------- //


}


