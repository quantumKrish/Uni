import java.util.Scanner;

public class exam2018q1 {

    public static void main(String[] args) {

        patternMaker();
        
    }
    
    /*
     
        STEPS:

        get the size of the square
        get character for the triangle
        get character for the square

        for (int i = 0; i < size; i++)
            
            for (int j = 0; j < size; j++)

                print triCharacter 
                j++
        

        for (int i = 0; i < size; i++)

            for (int j)

     */


     public static void patternMaker () {

        final int size = intInputInRange("Enter the size of the square: ", 0, Integer.MAX_VALUE, true, false);
        final char triCharacter = charInput("Enter the character you want for the triangles: ");
        final char squCharacter = charInput("Enter the character you want for the square: ");

        form1stTriangle(size, triCharacter);
        formSquare(size, squCharacter);
        form2stTriangle(size, triCharacter);


    } 
    
    public static void form1stTriangle (int size, char triCharacter) {

        for (int i = 0; i < size; i++) {
            System.out.println("");

            for (int j = 0; j < i + 1; j++) {
                System.out.print(triCharacter);

            }
        }
    }

    public static void formSquare (int size, char squCharacter) {

        for (int i = 0; i < size; i++) {
            System.out.println("");

            for (int j = 0; j < size; j++) {
                System.out.print(squCharacter);

            }
        }
    }

    public static void form2stTriangle (int size, char triCharacter) {

        for (int i = 0; i < size; i++) {
            System.out.println("");

            for (int j = size; j > i ; j--) {
                System.out.print(triCharacter);

            }
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
                System.out.print(message);
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
