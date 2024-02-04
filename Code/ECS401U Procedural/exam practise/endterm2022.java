import java.util.Scanner;

class scoresClass {

    String name = "";
    int score;
}
// end of scoresClass



public class endterm2022 {
    public static void main(String[] args) {

        leaderBoard();
        
    }

    public static void leaderBoard() {

        final int maxRecords = 50;
        scoresClass [] scoresArray = new scoresClass[maxRecords];
        System.out.println("Options: (1) Enter a new score (2) Print top n scores (3) Exit\n");

        choices(scoresArray, maxRecords);

    }
    // end of leaderBoard

    
    // prints out a menu with 3 choices (first is to exit program, rest are customisable)
    //
    public static void choices (scoresClass[] scoresArray, int maxRecords) {

        int count = 0;
        boolean flag = true;

        while (flag) {

            int choice = intInputInRange("Select an option [1-3]:\n", 1, 3, false, false);
            
            if (choice == 1) {
                getRecordDetails(scoresArray, maxRecords, count);
                count++;

            } else if (choice == 2) {
                sortArray(scoresArray, count);
                printScores(scoresArray, count);

            } else {    
                flag = false;
            }
        }
    }
    // end of choices

    
    //
    //
    public static void printScores (scoresClass[] scoresArray, int count) {

        System.out.println("/n");

        for (int i=0; i < count; i++) {

            System.out.println("#" + i + "  " + getName(scoresArray[i]) + " "+ getScore(scoresArray[i]));
        }
        
    }
    

    // sorts all the records in the array based of their score
    //
    public static scoresClass[] sortArray(scoresClass[] scoresArray, int count) {

        scoresClass tempRecord;
    
        // Outer loop for the number of passes
        for (int pass = 0; pass < count - 1; pass++) {

            // Inner loop for comparing and swapping elements
            for (int currentIdx = 0; currentIdx < count - 1 - pass; currentIdx++) {
                int nextIdx = currentIdx + 1;
    
                // Compare scores and swap if necessary
                if (getScore(scoresArray[currentIdx]) < getScore(scoresArray[nextIdx])) {

                    // Swap scoresArray[currentIdx] and scoresArray[nextIdx]
                    tempRecord = scoresArray[currentIdx];
                    scoresArray[currentIdx] = scoresArray[nextIdx];
                    scoresArray[nextIdx] = tempRecord;
                }
            }
        }
    
        return scoresArray;
    }
        





    // enters a loop collecting all patients surnames until user enters XXx
    //
    public static scoresClass[] getRecordDetails (scoresClass[] scoresArray, int maxRecords, int count) {


        if (count < maxRecords) {

            String name = stringInputNoNumbers("Enter name: ");
            int score = intInputInRange("Enter score: ", 0, Integer.MAX_VALUE, true, false);

            scoresArray[count] = createScoresRecord(name, score);

            return scoresArray;

        } else {

            System.out.println("array full");
            return null;
        }
    }






// ----------------------------------------- ADT METHODS ----------------------------------------- //


    public static scoresClass createScoresRecord(String name, int score) {

        scoresClass scoresRecord = new scoresClass();

        setName(scoresRecord, name);
        setScore(scoresRecord, score);

        return scoresRecord;

    }        

    public static String getName(scoresClass scoresRecord) {
        return scoresRecord.name;
    }

    public static scoresClass setName(scoresClass scoresRecord, String name ) {
        scoresRecord.name = name;
        return scoresRecord;
    }

    public static int getScore(scoresClass scoresRecord) {
        return scoresRecord.score;
    }

    public static scoresClass setScore(scoresClass scoresRecord, int score ) {
        scoresRecord.score = score;
        return scoresRecord;
    }



    
// ----------------------------------------- INPUT METHODS ----------------------------------------- //

    // gets ANY string with custom message then returns it
    //
    public static String inputString(String message) {

    Scanner scanner = new Scanner(System.in);
    System.out.print(message);
    String textinput = scanner.nextLine();

    return textinput;
    } 
    // end inputString


    // gets 'yes' or 'no' input with a custom message then returns true or false
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


    // gets an input between a given range with custom message then returns it
    //
    public static int intInputInRange(String message, int min, int max, boolean isUpperInfinity, boolean isLowerInfinity) {
        Scanner scanner = new Scanner(System.in);
    
        int userInput = Integer.MIN_VALUE; // initialize with a value outside any reasonable range
    
        // continue loop until a valid input is received
        while (!((isUpperInfinity && isLowerInfinity) || (isUpperInfinity && userInput >= min) || (isLowerInfinity && userInput <= max) || (!isUpperInfinity && !isLowerInfinity && userInput >= min && userInput <= max))) {
    
            System.out.print(message);
    
            // inner loop to handle non-integer inputs
            while (!scanner.hasNextInt()) {
    
                System.out.println("Invalid input. Please enter an integer:");
                scanner.next(); // discard the invalid input
    
            }
    
            // get the integer input
            userInput = scanner.nextInt();
    
            // check if the input is within the specified range
            if (!((isUpperInfinity && isLowerInfinity) || (isUpperInfinity && userInput >= min) || (isLowerInfinity && userInput <= max) || (!isUpperInfinity && !isLowerInfinity && userInput >= min && userInput <= max))) {
                System.out.println("Input not in range. Please try again.");
            }
        }
    
        return userInput;
    }
    // end of intInputInRange
    

    // gets a string with NO NUMBERS with custom message then returns
    //
    public static String stringInputNoNumbers(String message) {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print(message);
    
        String userInput = scanner.nextLine().trim();
    
        // continue loop until a valid input (no numbers) is received
        while (userInput.matches (".*\\d.*") || userInput.isEmpty()) {
    
            System.out.print("Invalid input. Please enter a string with no numbers:");
            userInput = scanner.nextLine().trim();
    
        }
    
        return userInput;
    }
    // end of intStringNoNumbers


    // gets a single character input with a custom message and returns the character
    //
    public static char charInput(String message) {
        Scanner scanner = new Scanner(System.in);
        char userInput = '\0'; // Initialize with a value that doesn't represent a valid character

        // Keep asking the user for input until a valid input is received
        while (userInput == '\0') {
            System.out.print(message + ": ");
            String input = scanner.nextLine();

            // Check if the input is a single character
            if (input.length() == 1) {
                userInput = input.charAt(0);

            } else {
                System.out.println("Invalid input. Please enter a single character.");

            }
        }

        return userInput;
    }
    // end of getCharInput



    // checks if a number is even and returns true or false if it is
    //
    public static boolean isEven (int number) {

        if (number % 2 == 0) {
            return true;

        } else {
            return false;

        }
    }

    

// ------------------------------------------------------------------------------------------------- //
}
