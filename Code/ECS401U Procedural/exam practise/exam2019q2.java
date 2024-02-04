import java.util.Scanner;

class patientDetails{

    String name;
    boolean diabetic = false;
    String regime = "false";

}

public class exam2019q2 {

    public static void main(String[] args) {

        patientData();

    }

    /*
    STEPS:
    1.  loop 300 times or until XXX is typed in
        1.1. ask for user's surname increment count and store in array of records

    2. set a flag to true
    3. loop while flag is true
        3.1. give users 3 choices as a menu

        3.2. if user picks 1
            set flag to false

        3.3. if user picks 2
            ask user if they have diabetes or not- store in record
            ask user what regime they on and show menu

            if they picked 1
                store diet in record

            if they picked 2
                store exercise in record

            if they picked 3
                store drugs in record

        3.4. if user picks 3
            go through every array and print out all details of all patients
     */


     // controls other functions and holds important data structures/ values
     //
     public static void patientData () {

        final int maxRecords = 300;
        patientDetails[] detailsArray = new patientDetails[maxRecords];

        getPatientNames(detailsArray, maxRecords);
        choices(detailsArray);

     }
     // end of patientDetails


     // enters a loop collecting all patients surnames until user enters XXX
     //
     public static patientDetails[] getPatientNames (patientDetails[] detailsArray, int maxRecords) {

        int count = 0;
        String userInput = ""; 

        System.out.println("Type XXX to stop collecting names");

            while (count < maxRecords && !userInput.equals("XXX")) {

            userInput = intStringNoNumbers("\nWhat's patient's surname: ");
            if (!userInput.equals("XXX")) {

                patientDetails patientRecord = createPatientRecord(userInput);
                setName(patientRecord, userInput);

                detailsArray[count] = patientRecord;

                count++;
            }
        }

        return detailsArray;
    }
    // end of getPatientNames

    
    public static void choices (patientDetails[] detailsArray) {

        boolean flag = true;

        while (flag) {

            int choice = intInputInRange("\nSelect number to choose\n1. Exit program\n2. Add further details to patients\n3. print all patient details\n", 1, 3, false, false);
            
            if (choice == 1) {
                flag = false;

            } else if (choice == 2) {
                getFurtherDetails(detailsArray);

            } else {    
                listPatienDetails(detailsArray);
            }
        }
    }
    // end of choices


    public static void listPatienDetails (patientDetails[] detailsArray) {

        final int arrayLength = detailsArray.length;

        for (int i = 0; (i < arrayLength); i++) {

            if (detailsArray[i] != null) {

                System.out.println("Name: " + getName(detailsArray[i]));
                System.out.println("Diabetic: " + getDiabetic(detailsArray[i]));
                System.out.println("Improvement regime: " + getRegime(detailsArray[i]));
            }
        }
    }


    public static patientDetails[] getFurtherDetails(patientDetails[] detailsArray) {

        boolean stopFlag = false;
        boolean flag = false;
        final int arrayLength = detailsArray.length;

        while (!stopFlag) {

            String patientName = intStringNoNumbers("Enter the name of the patient you want to add details to ");

            for (int i = 0; (i < arrayLength && flag == false); i++) {

                // checks if person exists and is not null
                if (detailsArray[i] != null && (detailsArray[i].name).equals(patientName)) {
                    flag = true;
                    stopFlag = true;

                    if (getYesOrNoInput("Is patient diabetic? ")) {
                        setDiabetic(detailsArray[i], true);

                        if(getYesOrNoInput("Does patient have an improvement regime? ")) {
                            chooseRegimes(detailsArray, i);

                        } else {
                            setRegime(detailsArray[i], "false");
                        }

                    } else {
                        setDiabetic(detailsArray[i], false);
                        
                    }
                } 
            }

            // if station dont exist user can choose to try again or nor
            if (flag == false) {
                System.out.println("This person doesn't exist !!!");

                if (!getYesOrNoInput("Do you want to try again? ")) {
                    stopFlag = true;

                } else {
                    flag = false;

                }
            }
        }   
        return detailsArray;   
    }



    public static patientDetails[] chooseRegimes (patientDetails[] detailsArray, int i) {

        System.out.println("What regime are you on");

            int choice = intInputInRange("\nSelect number to choose\n1. Diet\n2. Exercise\n3. Drugs\n", 1, 3, false, false);
            
            if (choice == 1) {
                setRegime(detailsArray[i], "Diet");

            } else if (choice == 2) {
                setRegime(detailsArray[i], "Exercise");

            } else {    
                setRegime(detailsArray[i], "Drugs");

            }

        return detailsArray;
    }





// ----------------------------------------- ADT METHODS ----------------------------------------- //

    /*
     * createPatientRecord
     * 
     * getName
     * setName
     * 
     * getDiabetic
     * setDiabetic
     * 
     * getRegime
     * setRegime
     */


    public static patientDetails createPatientRecord(String patientName) {

        patientDetails patientRecord = new patientDetails();

        setName(patientRecord, patientName);

        return patientRecord;

    }

    public static String getName(patientDetails patientRecord) {
        return patientRecord.name;
    }

    public static patientDetails setName(patientDetails patientRecord, String patientName ) {
        patientRecord.name = patientName;
        return patientRecord;
    }

    public static boolean getDiabetic(patientDetails patientRecord) {
        return patientRecord.diabetic;
    }

    public static patientDetails setDiabetic(patientDetails patientRecord, boolean patientDiabetic) {
        patientRecord.diabetic = patientDiabetic;
        return patientRecord;
    }

    public static String getRegime(patientDetails patientRecord) {
        return patientRecord.regime;
    }

    public static patientDetails setRegime(patientDetails patientRecord, String patientRegime) {
        patientRecord.regime = patientRegime;
        return patientRecord;
    }

// ----------------------------------------------------------------------------------------------- //





// ----------------------------------------- INPUT METHODS ----------------------------------------- //


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
            System.out.println("Input not in range. Please try again.");
        }
    }

    return userInput;
}

public static String intStringNoNumbers(String message) {
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