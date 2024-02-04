import java.util.Scanner;

public class shortC {
    public static void main(String [] a) 
    {
        int[] grades = gradeCollection();
        String finalGrade = gradeCalculation(grades);
        outputGrade(finalGrade);

    } // end of main

    public static int[] gradeCollection() {

        // initalises array with 7 indexes
        int[] grades = {0, 0, 0, 0, 0, 0, 0};

        // initalises array with letter grades
        String[] letterGrades = {"A+", "A", "B", "C", "D", "G", "F"};

        Scanner scanner = new Scanner(System.in);

        // loops 8 times
        for (int i = 0; i < grades.length; i++) {
            boolean validInput = false;

            // checks if input is valid before adding to array
            while (!validInput) {
                System.out.print("Enter the count of grade " + letterGrades[i] + ": ");

                if (scanner.hasNextInt()) {
                    grades[i] = scanner.nextInt();
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    scanner.nextLine(); // Consume the invalid input
                }
            } // end of while loop

        } // end of for loop

        return grades;
    }


        // compares the grades against the ruleset and takes an array as a parameter
        public static String gradeCalculation(int[] grades) {

            // assigns every element in the array into a variable for comparison later
            int aPlusCount = grades[0];
            int aCount = grades[1];
            int bCount = grades[2];
            int cCount = grades[3];
            int dCount = grades[4];
            int fCount = grades[5];
            int gCount = grades[6];


            // compares the number of times grade was recieved against the ruleset and returns the final grade
            if (aPlusCount >= 8) {
                return "A*";

            } else if (aPlusCount >= 7 && (aPlusCount + aCount >= 8)) {
                return "A++";

            } else if (aPlusCount >= 6 && (aPlusCount + aCount >= 8)) {
                return "A+";

            } else if (aPlusCount + aCount >= 6 && (aPlusCount + aCount + bCount >= 8)) {
                return "A";

            } else if (aPlusCount + aCount + bCount >= 6 && (aPlusCount + aCount + bCount + cCount >= 8)) {
                return "B";

            } else if (aPlusCount + aCount + bCount + cCount >= 6 && (aPlusCount + aCount + bCount + cCount + dCount >= 8)) {
                return "C";

            } else if (aPlusCount + aCount + bCount + cCount + dCount >= 6 && (aPlusCount + aCount + bCount + cCount + dCount + fCount >= 8)) {
                return "D";

            } else if (aPlusCount + aCount + bCount + cCount + dCount + fCount >= 6 && (aPlusCount + aCount + bCount + cCount + dCount + fCount + gCount >= 8)) {
                return "F";

            } else if (aPlusCount + aCount + bCount + cCount + dCount + fCount + gCount == 8) {
                return "G";

            } else {
                return "Q";
            }
        }

        // returns the final grade along with additional statements
        public static void outputGrade(String finalGrade) {

            System.out.println("You consistently gained a " + finalGrade + " or better.");
            System.out.println("Therefore you gained a " + finalGrade + " overall.");

        }

} // end of main class
