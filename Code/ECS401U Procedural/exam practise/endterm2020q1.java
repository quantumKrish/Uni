import java.util.Scanner;

class attackRecordClass{

    int medicationNumber = 0;
    String attackCause;
    int qualOfLife;

}

public class endterm2020q1 {

    public static void main(String[] args) {

        allergyAttackTracker();
        
    }


    public static void allergyAttackTracker () {

        final int maxRecords = 100;
        final int maxMedNumber = 60;
        attackRecordClass [] attackRecordArray = new attackRecordClass[maxRecords];

        getRecordDetails(attackRecordArray, maxRecords, maxMedNumber);

    }

    public static void printDetails (attackRecordClass[] attackRecordArray, int count) {

        System.out.println("\n");

        for (int i  = 0; i < count; i++) {

            System.out.println((getMedicationNumber(attackRecordArray[i])) + "    " + getAttackCause(attackRecordArray[i]) + "    " + getQualOfLife(attackRecordArray[i]));
        }
        
    }

    // enters a loop collecting all details until max medication number is over 60
    //
    public static attackRecordClass[] getRecordDetails (attackRecordClass[] attackRecordArray, int maxRecords, int maxMedNumber) {

        int count = 0;
        int userInput; 
        int totalMedicationNumber = 0;
        boolean flag = true;


        // loops and adds values to a record and adds that record to an array of records
        //
        while (count < maxRecords && totalMedicationNumber < maxMedNumber) {    // CHANGE THIS VALIDATION IF NEEDED

            userInput = intInputInRange("\nEnter how many times you took medication you had the attack (0 - 10): ", 0, 10, false, false);
            totalMedicationNumber = totalMedicationNumber + userInput;

            if (totalMedicationNumber < maxMedNumber || flag) {  



                attackRecordClass attackRecord = createAttackRecord(userInput);
                setMedicationNumber(attackRecord, userInput);
                setAttackCause(attackRecord, stringInputNoNumbers("What caused your allergy attack: "));
                setQualOfLife(attackRecord, intInputInRange("What would you rate your quality of life after the  (1 - 5)", 1, 5, false, false));

                //adds to array of records
                attackRecordArray[count] = attackRecord;    

                count++;
            } else {

                flag = false;
            }
        }

        printDetails(attackRecordArray, count);
        return attackRecordArray;
    }
    // end of getRecordDetails
    

// ----------------------------------------- ADT METHODS ----------------------------------------- //


    public static attackRecordClass createAttackRecord(int medicationNumber) {

        attackRecordClass attackRecord = new attackRecordClass();
        setMedicationNumber(attackRecord, medicationNumber);

        return attackRecord;
    }        

    public static int getMedicationNumber(attackRecordClass attackRecord) {
        return attackRecord.medicationNumber;
    }

    public static attackRecordClass setMedicationNumber(attackRecordClass attackRecord, int medicationNumber ) {
        attackRecord.medicationNumber = medicationNumber;
        return attackRecord;
    }

    public static String getAttackCause(attackRecordClass attackRecord) {
        return attackRecord.attackCause;
    }

    public static attackRecordClass setAttackCause(attackRecordClass attackRecord, String attackCause ) {
        attackRecord.attackCause = attackCause;
        return attackRecord;
    }

    public static int getQualOfLife(attackRecordClass attackRecord) {
        return attackRecord.qualOfLife;
    }

    public static attackRecordClass setQualOfLife(attackRecordClass attackRecord, int qualOfLife ) {
        attackRecord.qualOfLife = qualOfLife;
        return attackRecord;
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
