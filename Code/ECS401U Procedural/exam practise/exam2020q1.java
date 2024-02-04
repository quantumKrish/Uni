import java.util.Scanner;

public class exam2020q1 {

    public static void main(String[] args) {
        
        patternFormer();

    }

    /*
        STEPS:
        1. ask user for dimensions and special character
        2. initialise lines (d), leftX (0) and rightX (d-1)
        3. start loop (int i = 0; i <= lines; i++)

            3.1. start loop (int j = 0; j < leftX; j++)
                3.1.1. print the Xs
            3.2. increment leftX

            3.3. print the special character

            3.4. start loop (int k = 0; k < rightX; k++)
                3.4.1 print the Xs
            3.5. decrement rightX
    */

    public static void patternFormer () {

        final int dim = getDim();
        final String specChar = getSpecChar();

        final int lines = dim;
        int leftX = 0;
        int rightX = dim - 1;

        for (int i = 0; i <= lines; i++) {

            formLeft(leftX);
            leftX ++;
            System.out.print(specChar);
            formRight(rightX);
            rightX--;
            System.out.println(""); 
        }
    }
    // end of patternFormer

    
    // prints the Xs on the left side of the special character
    //
    public static void formLeft (int leftX) {

        for (int j = 0; j < leftX; j++) {
            System.out.print("X");
        }

    }
    // end of formLeft


    // prints the Xs on the right side of the special character 
    //
    public static void formRight (int rightX) {

        for (int k = 0; k < rightX; k++) {
            System.out.print("X");
        }

    }
    // end of formRight


    // gets the dimensions of the pattern from the user
    //
    public static int getDim () {

        final int dim = inputInt("Enter the dimention you want the pattern to be !! ");
        return dim;
    }


    // gets the special character for the pattern from the user
    //
    public static String getSpecChar () {

        final String specChar = inputStr("Enter the special character you want to me in the pattern !! ");
        return specChar;
    }





// ----------------------------------------- INPUT METHODS ----------------------------------------- //

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
                validInput = true; // valid input, exit the loop
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // consume the invalid input to avoid an infinite loop
            }
        }
         return answer;
    }
    // end inputInt
    

    public static String inputStr (String message) {

        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        String textinput = scanner.nextLine();
        
        return textinput;
    }
    // end inputString

// ------------------------------------------------------------------------------------------------- //

}
