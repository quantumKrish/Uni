import java.util.Scanner;

public class shortD {

    public static void main(String [] a) 
    {
        qualityCollection();
    } // end of main

// finds average CFU value by dividing the total by 5 then rounding it
//
public static void qualityAverage( int totalCFU)
{
    final int divisor = 5;
    int averageCFU = Math.round(totalCFU / divisor);
    System.out.println("Average water quality is " + averageCFU);
     return;
    
} // END compareGrades


// calls method that records and stores grade data
//
public static String qualityGrading(double averageCFU)
{

    String p = "";

     // comparison for theory
     if (averageCFU >= 400) {
        p = "The water quality is POOR";

     } else if (averageCFU >= 200) {
        p = "The water quality is SUFFICIENT";
         
     } else {
        p = "The water quality is GOOD";
     } 
        
     return p;
    
} // END qualityGrading


// calls method that records and stores grade data
//
public static void qualityCollection() {

    Scanner scanner = new Scanner(System.in);

    // initalize the variables used to hold all values, methods (scanner) and an array to hold all Letter grades
    //
    int currentCFU = 0;
    int totalCFU;
    int highestCFU;

    highestCFU = 0;
    totalCFU = 0;

    // loops it 5 times from 1 to 6 as it would be zero indexed if it were from 0 to 5
    for (int counter = 1; counter < 6; counter++) {

        boolean validInput = false;

        while (!validInput) {
            System.out.println("Sample " + counter + ": What was the water quality measurement in CFU/ml?");

            // Check if the next input is an integer
            if (scanner.hasNextInt()) {
                currentCFU = scanner.nextInt();
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Consume the invalid input to avoid an infinite loop
            }
        }

        // total is collected by adding the previous CFU value to overall CFU value
        totalCFU = totalCFU + currentCFU;

        // if the current CFU value is larger than the highest CFU value already in the program it will override the value in the variable
        if (currentCFU > highestCFU) {
            highestCFU = currentCFU;
        }
    }

    System.out.println("\nThe worst water quality today was " + highestCFU + " CFU/ml.");

    int averageCFU = totalCFU / 5;

    qualityAverage(totalCFU);
    System.out.println(qualityGrading(highestCFU));
} // END qualityCollection
    
    
} // end of shortD classk

