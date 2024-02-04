import java.util.Scanner;

public class exam2022q1 {
    private static int XEnd = 0;


    public static void main(String[] args) {
        timesTablesTest();
        
    }
    // end of main 


    public static void timesTablesTest () {

        final int XStart = getXStart();
        final int XEnd = getXEnd(XStart);
        int questionCount = 0;
        int score = 0;

        // controls the number user multiplies (x)
        for (int i = XStart; i <= XEnd; i++) {

            // controls the number user multiplies (y)
            for (int j = 1; j <= 12; j++) {
                score = askQuestion(i, j, score); // previous score passed through, updated then overwrites score variable
                questionCount ++;

            }
        }
        // end for loops

        double percent = calculatePercent(questionCount, score);
        String grade = calculateGrade(percent);
        outputScores(questionCount, score, percent, grade);

    }


    // takes all display data and concatenates it into a final message
    //
    public static void outputScores (int questionCount, int score, double percent, String grade) {
        System.out.println("You scored " + score + "/" + questionCount + " (" + percent + "%) " + grade + " grade");

    } 
    // end of outputScore


    // passes in percentage and checks them against grading criteria to return grade
    //
    public static String calculateGrade(double percent) {

        if (percent >= 70) {
            return "A";

        } else if (percent >= 60) {
            return "B";

        } else if (percent >= 50) {
            return "C";

        } else if (percent >= 40) {
            return "D";

        } else {
            return "F";
            
        }
        // end if else
    }
    // end calculateGrade




    // calculates percentage of what user scored
    //
    public static double calculatePercent (int questionCount, int score) {

        double percent = Math.round((((double) score / questionCount) * 100));
        return percent; 
    }
    // end of calculatePercent


    // asks user question and takes input, calculates real answer, compares and increments score
    //
    public static int askQuestion (int i, int j, int score) {

        int answer = inputInt("What is " + i + " * " + j + "? ");
        
        if (answer == (i * j)) {
            System.out.println("Correct.");
            score ++;

        } else {
            System.out.println("Incorrect !!!");

        }
        // end if else

        return score;
    }
    // end of askQuestion


    // gets the starting value from the user
    //
    public static int getXStart () {
        int XStart = inputInt("Enter x start (x>0): ");

        return XStart;
    }
    // end of getXStart


    // gets the ending value from the user, if its less than starting it asks again
    //
    public static int getXEnd (int XStart) {

        while (true) {
            XEnd = inputInt("Enter x end (x>=start): ");

            if (XEnd >= XStart) {
                break;
            } else {
                System.out.println("Error !!! x end is less than x start, try again !!!");
            }
            // end if else
        }
        // end while 
        return XEnd;
    }
    // end of getXEnd



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
                validInput = true; // Valid input, exit the loop
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Consume the invalid input to avoid an infinite loop
            }
        }
         return answer;
    }
    // end inputInt


    // take user input and checks if its an int value- loops if it isn't
    //
    public static int inputIntCheck (String message, int XStart) {

        Scanner scanner = new Scanner(System.in);
        int answer = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print(message);

            if (scanner.hasNextInt()) { // checks if input in an integer
                answer = scanner.nextInt();
                validInput = true; // Valid input, exit the loop
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Consume the invalid input to avoid an infinite loop
            }
        }
         return answer;
    }
    // end inputInt

// ------------------------------------------------------------------------------------------------- //
}
// end of exam2022q1 class
