import java.util.*;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;  // Import the FileWriter class

class Reading{
    int peakFlow;
    boolean day = false;
}

class Q22021 {
    
    public static void main(String[] Args){

        Reading[] readings = new Reading[31];
        initializeReadings(readings);

        System.out.println("Enter dangerous reading mentioned by doctor: ");
        final int dangerousReading = getValidIntegerInRange(0, 0, true, false);

        int choice = -1;
        while(choice != 0){
            System.out.print("Enter a day 1-31 or 0 to exit");
            choice = getValidIntegerInRange(0, 31, false, false);
            if(choice != 0){
                setDayReading(readings, dangerousReading, choice - 1);
            }
        }
        createFile(readings);

    }

    public static Reading[] initializeReadings(Reading[] readings){
        for(int i = 0; i < 31; i++){
            readings[i] = new Reading();
        }
        return readings;
    }

    public static void setDayReading(Reading[] readings, int danger, int currentDay){
        int highestReading = 0;
        int reading;


        for(int i = 0; i < 3; i++){
            System.out.println("Enter your reading");
            reading = getValidIntegerInRange(0, 0, true, false);
            if(reading>highestReading){
                highestReading=reading;
            }
            if(reading<danger){
                System.out.println("Dangerous reading");
            }
        }

        readings[currentDay].day = true;
        readings[currentDay].peakFlow = highestReading;

    }

    public static void createFile(Reading[] readings){
        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            for(int i = 0; i < 31; i++){
                if(readings[i].day == true){
                     myWriter.write("Day: " + readings[i].day + ". Reading: " + readings[i].peakFlow + "\n"); 
                }
            }
            myWriter.close();
        } 
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    

    public static int getValidIntegerInRange(int min, int max, boolean upperInfinity, boolean lowerInfinity) {
        Scanner scanner = new Scanner(System.in);
        int value = Integer.MIN_VALUE; // Initialize with a value outside any reasonable range
        boolean isInRange = false;

        while (!((upperInfinity && lowerInfinity) || (upperInfinity && value >= min) || (lowerInfinity && value <= max) || (!upperInfinity && !lowerInfinity && value >= min && value <= max))) {
            System.out.println("Please enter an integer:");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer:");
                scanner.next(); // discard the invalid input
            }
            value = scanner.nextInt();

            // Check range

            if (!((upperInfinity && lowerInfinity) || (upperInfinity && value >= min) || (lowerInfinity && value <= max) || (!upperInfinity && !lowerInfinity && value >= min && value <= max))) {
                System.out.println("Input not in range. Please try again.");
            }
        }

        return value;
    }

    public static String getValidStringNoNumbers(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        while (input.matches(".*\\d.*") || input.isEmpty()) {
            System.out.println("Invalid input. Please enter a string with no numbers:");
            input = scanner.nextLine().trim();
        }
        return input;
    }

}