import java.util.Scanner;

public class exam2021q1 {
    public static void main(String[] args) {

        textPyramid();

    }

    public static void textPyramid () {

        final int lowerBound = takeLower();
        final int upperBound = takeUpper(lowerBound);

        // formala to get the amount of line dependand on the upper and lower bounds

        final int lines = ((upperBound - lowerBound) / 2) + 1;
        final int spaces = lines - 1;

        formpyramid(lowerBound, spaces, lines);
    }


    // uses for loops and the bounds to form the pyramid shape using spaces and equal signs
    //
    public static void formpyramid(int lowerBound, int spaces, int lines) {

        // iterates the amount of lines there are
        for (int i = 0; i < lines; i++) {

            // omits a new line for the first line
            if (i != 0) {
                System.out.println(" ");

            }

            // prints the spaces to align the =
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }

            // decrements the spaces to get pyramid shape
            spaces = spaces - 1;

            // prints equal signs equivalent to the lower bound
            for (int n = 1; n <= lowerBound; n++) {
                System.out.print("=");
            }

            // increments by 2 to increase base by 2
            lowerBound = lowerBound + 2;

        }

        return;

    }
    // end of formPyramid

    
    // take an input as the lower bound and ensures its an odd number
    //
    public static int takeLower () {

        int lowerBound = 0;

        while (isEven(lowerBound)) {

            lowerBound = inputInt("Enter the lower bound number (has to be odd): ");

            if (isEven(lowerBound)) {
                System.out.println("Error lower bound has to be odd !!!");
            } 

        }
        // end of while

        return lowerBound;
    }
    // end of takeLower


    public static int takeUpper (int lowerBound) {

        int upperBound = 0;

        while (isEven(upperBound) || !isBigger(upperBound, lowerBound)) {

            upperBound = inputInt("Enter the upper bound number (has to be odd): ");

            if (isEven(upperBound)) {
                System.out.println("Error upper bound has to be odd !!!");
            }

            if (!isBigger(upperBound, lowerBound)) {
                System.out.println("Error upper bound has to be at least 2 larger than the lower bound !!!");
            }

        }
        // end of while
        
        return upperBound;
    }


    // checks if upper bound is 2 bigger than lower bound and returns true if it is
    //
    public static boolean isBigger (int upperBound, int lowerBound) {

        if (upperBound >= (lowerBound + 2)) {
            return true;

        } else {    
            return false;
        }

    }


    // checks if a number is even and returns true or false if it is
    //
    public static boolean isEven (int number) {

        if (number % 2 == 0) {
            return true;

        } else {
            return false;

        }
    }


// -------------------------------------------------- INPUT METHODS -------------------------------------------------- //

    // take user input and checks if its an int value- loops if it isn't
    //
    public static int inputInt (String message) {

        Scanner scanner = new Scanner(System.in);
        int answer = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print(message);

            if (scanner.hasNextInt()) { // checks if input in an integer
                answer = scanner.nextInt();
                validInput = true; // Valid input, exit the loop
            } else {
                System.out.println("Invalid input !!! Enter a valid integer !!!");
                scanner.next(); // Consume the invalid input to avoid an infinite loop
            }
        }
        // end of while

         return answer;
    }
    // end inputInt

// ------------------------------------------------------------------------------------------------------------------- //


}
// end of class exam2021q1
