package ECS414U.Lab1;

import java.util.Scanner;

public class lab1q1 {

    public static void main(String[] args) {

        classificationFinder();
        
    }

    public static void classificationFinder () {

        double percentage = getPercentage();
        System.out.println(comparePercentages(percentage));

    }

    public static double getPercentage () {

        double percentage = doubleInputInRange("Whats your average perctentage: ", 0, 100, false, false);
        return percentage;
        
    }


    public static String comparePercentages (double percentage) {

        if (percentage >= 70) {
            return "Congratulations! You are on a track to graduate with a 1st";

        } else if (percentage >= 60) {
            return "Congratulations! You are on a track to graduate with a 2:2";

        } else if (percentage >= 50) {
            return "Congratulations! You are on a track to graduate with a 2:2";

        } else if (percentage >= 45) {
            return "Congratulations! You are on a track to graduate with a 3rd";

        } else if (percentage >= 40) {
            return "You are on a track to graduate with a Pass";

        } else {
            return "Unfortunately, your current classification is a Fail";

        }
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
        public static double doubleInputInRange(String message, int min, int max, boolean isUpperInfinity, boolean isLowerInfinity) {
            Scanner scanner = new Scanner(System.in);
        
            double userInput = Integer.MIN_VALUE; // initialize with a value outside any reasonable range
        
            // continue loop until a valid input is received
            while (!((isUpperInfinity && isLowerInfinity) || (isUpperInfinity && userInput >= min) || (isLowerInfinity && userInput <= max) || (!isUpperInfinity && !isLowerInfinity && userInput >= min && userInput <= max))) {
        
                System.out.print(message);
        
                // inner loop to handle non-integer inputs
                while (!scanner.hasNextDouble()) {
        
                    System.out.println("Invalid input. Please enter an double:");
                    scanner.next(); // discard the invalid input
        
                }
        
                // get the integer input
                userInput = scanner.nextDouble();
        
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
