import java.util.Scanner;

public class usefulMethods {

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




    exampleClass [] exampleArray = new exampleClass[10];



    public static exampleClass createExampleRecord(String exampleName) {

        exampleClass exampleRecord = new exampleClass("100");
        setName(exampleRecord, exampleName);
        return exampleRecord;

    }        

    public static String getName(exampleClass patientRecord) {
        return patientRecord.name;
    }

    public static exampleClass setName(exampleClass exampleRecord, String exampleName ) {
        exampleRecord.name = exampleName;
        return exampleRecord;
    }


    // enters a loop collecting all patients surnames until user enters XXx
    //
    public static exampleClass[] getRecordDetails (exampleClass[] exampleArray, int maxRecords) {

        int count = 0;
        String userInput = ""; 


        // loops and adds values to a record and adds that record to an array of records
        //
        System.out.println("Type XXX to stop collecting names");

            while (count < maxRecords && !userInput.equals("XXX")) {    // CHANGE THIS VALIDATION IF NEEDED

                userInput = stringInputNoNumbers("\nWhat's patient's surname: ");
                if (!userInput.equals("XXX")) {     // AND THIS ONE

                    exampleClass exampleRecord = createExampleRecord(userInput);
                    setName(exampleRecord, userInput);
                    // ADD MORE SET METHODS HERE LIKE BELOW:
                    // setAge(exampleRecord, stringInputNoNumbers("What's the age: "))

                    /// adds to array of records
                    exampleArray[count] = exampleRecord;    

                    count++;
                }
            }

        return exampleArray;
    }

    // end of getRecordDetails

    // loops through record of arrays to check if one value in the record exists then finds other details in that array
    //
    public static void doesExampleArrayHaveCertainField (exampleClass[] exampleArray) {

        boolean stopFlag = false;

        while (!stopFlag) {

            boolean flag = false;
            String exampleValueInRecord = ("Enter a value in record you want to check: ");

            for (int i = 0; (i <= exampleArray.length && flag == false); i++) {


                // checks if value in field exists
                if (exampleArray[i] != null && getName(exampleArray[i]).equals(exampleValueInRecord)) {
                    flag = true;
                    stopFlag = true;

                    // ENTER PROCESS YOU WANT TO DO AFTER YOU FOUND RIGHT RECORD HERE
                } 
            }

            // if value in record dont exist user can choose to try again or nor
            if (!flag) {
                System.out.println("This person doesn't exist!!!");
    
                if (!getYesOrNoInput("Do you want to try again? ")) {
                    stopFlag = true;
                }
            }
        }
    }
    // end of doesExampleArrayHaveCertainField


    // sorts all the records in the array based of their score
    //
    public static exampleClass[] sortArray(exampleClass[] scoresArray, int count) {

        exampleClass tempRecord;
    
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

    public static void printScores (scoresClass[] scoresArray, int count) {

        System.out.println("/n");

        for (int i=0; i < count; i++) {

            System.out.println("#" + (i + 1) + "  " + getName(scoresArray[i]) + " "+ getScore(scoresArray[i]));
        }
        
    }


//----------------------------------------------------------------------------------//
//----------------------         INPUT OUTPUT METHODS          ---------------------//
//----------------------------------------------------------------------------------//

    // prints out a menu with 3 choices (first is to exit program, rest are customisable)
    //
    public static void choices () {

        boolean flag = true;

        while (flag) {

            int choice = intInputInRange("\nSelect number to choose:\n\n1. Exit program\n2. Add further details to patients\n3. print all patient details\n", 1, 3, false, false);
            
            if (choice == 1) {
                flag = false;

            } else if (choice == 2) {
                // METHOD FOR CHOICE 2 GOES HERE

            } else {    
                // METHOD FOR CHOICE 3 GOES HERE
            }
        }
    }
    // end of choices


}

class exampleClass{

    public exampleClass(String string) {
        //TODO Auto-generated constructor stub  
    }
    String name;
    String surname;

}
    
