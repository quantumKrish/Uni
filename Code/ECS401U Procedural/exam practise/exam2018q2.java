import java.util.Scanner;

class animalClass {

    String commonName;
    String latinName;
    int endangeredStatus;

}

public class exam2018q2 {

    public static void main(String[] args) {
        
        endangeredAnimalTracker();

    }
    

    public static void endangeredAnimalTracker () {

        final int maxRecords = 500;
        animalClass [] animalArray = new animalClass[maxRecords];

        getRecordDetails(animalArray, maxRecords);
        choices(animalArray);

    }


    // enters a loop collecting all patients surnames until user enters XXx
    //
    public static animalClass[] getRecordDetails (animalClass[] animalArray, int maxRecords) {

        int count = 0;
        String userInput = ""; 
    
            while (count < maxRecords && !userInput.equals("XXX")) {    
    
            userInput = stringInputNoNumbers("\nWhat's animal's common name: (Type XXX to stop collecting details): ");
            if (!userInput.equals("XXX")) {     
    
                animalClass animalRecord = createAnimalRecord(userInput);
                setCommonName(animalRecord, userInput);
                setLatinName (animalRecord, stringInputNoNumbers("What's animals latin name: "));
                setEndangeredStatus (animalRecord, intInputInRange("What's animal's endangerment status (0 for Critically Endangered, 1 for Endangered, 2 for Vulnerable and 3 for Least Concern): ", 0, 3, false, false));

                /// adds to array of records
                animalArray[count] = animalRecord;    
    
                count++;
            }
        }
    
        return animalArray;
    }
    // end of getRecordDetails


    // prints out a menu with 3 choices (first is to exit program, rest are customisable)
    //
    public static void choices (animalClass[] animalArray) {

        boolean flag = true;

        while (flag) {

            int choice = intInputInRange("\nSelect number to choose:\n\n1. Exit program\n2. Change details of animal\n3. Display details of indivisual animal\n\n", 1, 3, false, false);
            
            if (choice == 1) {
                flag = false;

            } else if (choice == 2) {
                changeDetails(animalArray);

            } else {    
                getAnimalDetails(animalArray);

            }
        }
    }
    // end of choices


    //
    //
    public static void changeDetails (animalClass[] animalArray) {

        boolean stopFlag = false;
        boolean flag = false;
        int recordNumber = animalArray.length;

        while (!stopFlag) {

            String commonName = stringInputNoNumbers("Enter the common name of the animal you want to change details of: ");

            for (int i = 0; (i < recordNumber && flag == false); i++) {   

                // checks if value in field exists
                if (animalArray[i] != null && getCommonName(animalArray[i]).equals(commonName)) {
                    flag = true;
                    stopFlag = true;

                    setCommonName(animalArray[i], stringInputNoNumbers("What's animals common name: "));
                    setLatinName (animalArray[i], stringInputNoNumbers("What's animals latin name: "));
                    setEndangeredStatus (animalArray[i], intInputInRange("What's animal's endangerment status (0 for Critically Endangered, 1 for Endangered, 2 for Vulnerable and 3 for Least Concern): ", 0, 3, false, false));
                } 
            }

            // if value in record dont exist user can choose to try again or not
            if (flag == false) {
                System.out.println("This person doesn't exist !!!");

                if (!getYesOrNoInput("Do you want to try again? ")) {
                    stopFlag = true;

                } else {
                    flag = false;

                }
            }
        }
    }
    // end of changeDetails


    public static void getAnimalDetails (animalClass[] animalArray) {

        boolean stopFlag = false;
        
        while (!stopFlag) {
            String commonName = stringInputNoNumbers("Enter the common name of the animal whose details you want: ");
            boolean flag = false;
    
            for (int i = 0; i < animalArray.length && !flag; i++) {

                // checks if the value in the specified field exists
                if (animalArray[i] != null && getCommonName(animalArray[i]).equals(commonName)) {
                    flag = true;
                    stopFlag = true;

                    String stringEndangeredStatus = getStringEndangeredStatus(animalArray, i);
                    System.out.println("" + getCommonName(animalArray[i]) + " (" + getLatinName(animalArray[i]) + ") : " + stringEndangeredStatus);
                    
                } 
            }
    
            // if the value in the record doesn't exist, ask if the user wants to try again
            if (!flag) {
                System.out.println("This person doesn't exist!!!");
    
                if (!getYesOrNoInput("Do you want to try again? ")) {
                    stopFlag = true;
                }
            }
        }
    }

    public static String getStringEndangeredStatus (animalClass[] animalArray, int i) {

        String stringEndangeredStatus = "";

        if (getEndangeredStatus(animalArray[i]) == 0) {
            stringEndangeredStatus = "Critically endangered";

        } else if (getEndangeredStatus(animalArray[i]) == 1) {
            stringEndangeredStatus = "Endangered";
        
        } else if (getEndangeredStatus(animalArray[i]) == 2) {
            stringEndangeredStatus = "Vulnerable";
        
        } else {
            stringEndangeredStatus = "Least concern";
            
        }

        return stringEndangeredStatus;

    }


        
// ----------------------------------------- ADT METHODS ----------------------------------------- //

    public static animalClass createAnimalRecord(String commonName) {

        animalClass animalRecord = new animalClass();
        setCommonName(animalRecord, commonName);
        return animalRecord;
    }        

    public static String getCommonName(animalClass animalRecord) {
        return animalRecord.commonName;
    }

    public static animalClass setCommonName(animalClass animalRecord, String commonName) {
        animalRecord.commonName = commonName;
        return animalRecord;
    }

    public static String getLatinName(animalClass animalRecord) {
        return animalRecord.latinName;
    }

    public static animalClass setLatinName(animalClass animalRecord, String latinName) {
        animalRecord.latinName = latinName;
        return animalRecord;
    }

    public static int getEndangeredStatus(animalClass animalRecord) {
        return animalRecord.endangeredStatus;
    }

    public static animalClass setEndangeredStatus(animalClass animalRecord, int endangeredStatus) {
        animalRecord.endangeredStatus = endangeredStatus;
        return animalRecord;
    }

// ------------------------------------------------------------------------------------------------- //



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
    
        int userInput = Integer.MIN_VALUE; // Initialize with a value outside any reasonable range
    
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
                System.out.println(message);

                System.out.print("Input not in range. Please try again.");
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
