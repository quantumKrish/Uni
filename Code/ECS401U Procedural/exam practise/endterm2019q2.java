import java.util.Scanner;

class rugbyStatsClass {

    String name = "";
    int score = 0;

}


public class endterm2019q2 {
    
    public static void main(String[] args) {
        
        rugbyMatchTracker();

    }

    public static void rugbyMatchTracker () {

        final int maxRecords = 6;
        rugbyStatsClass [] rugbyStatsArray = new rugbyStatsClass[maxRecords];

        getPlayerNames(rugbyStatsArray, maxRecords);
        setPlayerNames(rugbyStatsArray, maxRecords);
        sortArray(rugbyStatsArray, maxRecords);
        printScores(rugbyStatsArray, maxRecords);

    }

    // enters a loop collecting all player names 60 times, then storing them in an array of records
    //
    public static rugbyStatsClass[] getPlayerNames (rugbyStatsClass[] rugbyStatsArray, int maxRecords) {

        int count = 0;
        String userInput; 


        // loops and adds values to a record and adds that record to an array of records
        //
        while (count < maxRecords) {    

            userInput = stringInputNoNumbers("Please enter name of player " + (count + 1) + ": ");

            rugbyStatsClass rugbyStatsRecord = createRugbyStatsRecord(userInput);
            
            //adds to array of records
            rugbyStatsArray[count] = rugbyStatsRecord;    

            count++;

        } 
        
        return rugbyStatsArray;
    } 
    // end of getPlayerNames

    // loops through record of arrays to check if one value in the record exists then finds other details in that array
    //
    public static void setPlayerNames(rugbyStatsClass[] rugbyStatsArray, int maxRecords) {

        boolean stopFlag = false;
        int count = 0;
        String userInput = "";

        while (!stopFlag && count < maxRecords && !userInput.equals("END")) {


            userInput = stringInputNoNumbers("\nWho has scored (END to finish)? ");

            if (!userInput.equals("END")) {

                boolean flag = false;

                for (int i = 0; (i < maxRecords && flag == false); i++) {


                    // checks if value in field exists
                    if (rugbyStatsArray[i] != null && getName(rugbyStatsArray[i]).equals(userInput)) {
                        flag = true;

                        setScore(rugbyStatsArray[i], intInputInRange("enter score: ", 0, Integer.MAX_VALUE, true, false));

                    } 
                }

                // if value in record dont exist user can choose to try again or nor
                if (!flag) {
                    System.out.println("This person doesn't exist!!!");
                    count--;
        
                    if (!getYesOrNoInput("Do you want to try again? ")) {
                        stopFlag = true;
                    }
                }
            }
            
            count++;
        }
    }
    // end of doesExampleArrayHaveCertainField

    // sorts all the records in the array based of their score
    //
    public static rugbyStatsClass[] sortArray(rugbyStatsClass[] rugbyStatsArray, int maxRecords) {

        rugbyStatsClass tempRecord;
    
        // Outer loop for the number of passes
        for (int pass = 0; pass < maxRecords - 1; pass++) {

            // Inner loop for comparing and swapping elements
            for (int currentIdx = 0; currentIdx < maxRecords - 1 - pass; currentIdx++) {
                int nextIdx = currentIdx + 1;
    
                // Compare scores and swap if necessary
                if (getScore(rugbyStatsArray[currentIdx]) < getScore(rugbyStatsArray[nextIdx])) {

                    // Swap rugbyStatsArray[currentIdx] and rugbyStatsArray[nextIdx]
                    tempRecord = rugbyStatsArray[currentIdx];
                    rugbyStatsArray[currentIdx] = rugbyStatsArray[nextIdx];
                    rugbyStatsArray[nextIdx] = tempRecord;
                }
            }
        }
    
        return rugbyStatsArray;
    }

    public static void printScores (rugbyStatsClass[] rugbyStatsArray, int maxRecords) {

        System.out.println("/n");

        for (int i=0; i < maxRecords; i++) {

            System.out.println("#" + (i + 1) + "  " + getName(rugbyStatsArray[i]) + " "+ getScore(rugbyStatsArray[i]));
        }
        
    }


    public static rugbyStatsClass createRugbyStatsRecord(String playerName) {

        rugbyStatsClass rugbyStatsRecord = new rugbyStatsClass();
        setName(rugbyStatsRecord, playerName);
        return rugbyStatsRecord;

    }        

    public static String getName(rugbyStatsClass rugbyStatsRecord) {
        return rugbyStatsRecord.name;
    }

    public static rugbyStatsClass setName(rugbyStatsClass rugbyStatsRecord, String playerName ) {
        rugbyStatsRecord.name = playerName;
        return rugbyStatsRecord;
    }

    public static int getScore(rugbyStatsClass rugbyStatsRecord) {
        return rugbyStatsRecord.score;
    }

    public static rugbyStatsClass setScore(rugbyStatsClass rugbyStatsRecord, int playerScore ) {
        rugbyStatsRecord.score = playerScore;
        return rugbyStatsRecord;
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
