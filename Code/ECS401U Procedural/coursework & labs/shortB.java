import java.util.Scanner;

public class shortB {

    public static void main(String[] a) {
        lapCalculator();
    } // end of main

    // prints out introductory message and initializes variables
    public static void lapCalculator() {
        int loops = 1;
        int currTime = 0;
        int prevTime = 0;
        int totalTime = 0;
        String input = "";

        System.out.println("Training Run Data");
        System.out.println("-----------------");

        lapTimes(loops, currTime, prevTime, totalTime, input);
    }// end of lapCalculator

    // controls the while loop and manipulates all the data for the lap times
    public static void lapTimes(int loops, int currTime, int prevTime, int totalTime, String input) {
        String stopText = "XXX";
        Scanner scanner = new Scanner(System.in);

        // keeps looping as long as the input is not equal to the stop text
        while (!input.equals(stopText)) {

            // collects lap times from the user
            System.out.println("What was the lap time " + loops + " (in s): ");
            input = scanner.next();

            // checks if input is equal to the stop text
            if (!input.equals(stopText)) {

                // checks if input is a valid integer before proceeding
                if (isValidInput(input)) {

                    // if the input is not equal to the stop text, it casts the input to an integer then assigns it to currTime
                    // also increments totalTime by the lap time
                    currTime = Integer.parseInt(input);
                    totalTime += currTime;

                    // as the first loop has no previous time, the difference is not calculated
                    if (loops > 1) {
                        int diff = diffCalculator(prevTime, currTime);
                        System.out.println("Difference " + diff + " seconds");
                    } // end of if statement

                    // prevTime becomes currTime for calculations in the next loop
                    // loops is incremented by 1
                    prevTime = currTime;
                    loops++;

                // displays an error message if invalid input
                } else {
                    System.out.println("Invalid input. Please enter a valid integer or " + stopText + " to stop.");
                } // end of if-else statement

            // end the loop if the input is equal to the stop text
            } else {
                break;
            }

        } // end of while loop

        System.out.println("You did " + (loops - 1) + " laps. Your total time today was " + totalTime);

    } // end of lapTimes

    // calculates the difference between times
    public static int diffCalculator(int prevTime, int currTime) {
        return Math.abs(prevTime - currTime);
    } // end of diffCalculator

    public static boolean isValidInput(String input) {

        // iterate through each character in the input
        for (char c : input.toCharArray()) {

            // check if the character is not a digit
            if (!Character.isDigit(c)) {

                // if input contains a non-digit character its not a valid integer
                return false; 
            }
        }
        // check if the input is not empty
        return !input.isEmpty();
    }
}
