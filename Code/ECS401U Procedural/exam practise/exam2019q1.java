import java.util.Scanner;

public class exam2019q1 {

    public static void main(String[] args) {
        
        flagMaker();
    }
    
    /*
     * STEPS
     * get all data points (width, height, charPerStripe)
     * for i in lines
     * 
     *      println
     * 
     *      for x in width
     * 
     *          if width MOD charPerStripe != 0
     * 
     *              print O
     * 
     *          else
     *              
     *              print *
     */

     public static void flagMaker () {

        int width = intInputInRange("Enter the width of the flag! ", 1, Integer.MAX_VALUE, true, false);
        int height = intInputInRange("Enter the height of the flag! ", 1, Integer.MAX_VALUE, true, false);
        int charPerStripe = getCharPerStripe(width);

        for (int i = 0; i < height; i++) {
            System.out.println("");

            for (int j = 1; j <= width; j++) {

                if ( (j % charPerStripe) != 0) {
                    System.out.print("O");

                } else {
                    System.out.print("*");

                }

            }
        }
     }

     public static int getCharPerStripe (int width) {
        Scanner scanner = new Scanner(System.in);

        int userInput = Integer.MAX_VALUE;

        while ( userInput > width) {

            userInput = intInputInRange("\nEnter the amount of characters between the stripes!! ", 1, Integer.MAX_VALUE, false, false);

            if (userInput > width) {
                System.out.println("Enter a number less than " + width + " (your width)");

            }
        }
        return userInput;
    }




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

public static String getStringWithoutNumbers(String message) {
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
