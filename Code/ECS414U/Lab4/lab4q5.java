package Code.ECS414U.Lab4;
public class lab4q5 {

    public static void main(String[] args) {

        highestCycle();
        
    }
    
    public static void highestCycle () {

        double highestCycleLength = 0;
        final double limit = 10;
        double result = 0;
        
        // loops through all the denominators
        for (double denominator = 2; denominator < limit; denominator++) {

            double remainder = 1;
            double position = 1;
            boolean foundCycle = false;

            // loops through the remainder until a cycle is found (when remainder == 1 or the position is greater than the denominator) 
            while (position < denominator && !foundCycle) {

                remainder = (remainder * 10) % denominator;

                if (remainder == 1) {
                    foundCycle = true;
                }

                position++;
            }

            // check if the cycle is the highest and store it if it is
            if (foundCycle) {

                double cycleLength = position - 1; // Subtract 1 to get the cycle length

                if (cycleLength > highestCycleLength) {
                    
                    highestCycleLength = cycleLength;
                    result = denominator;
                }
            }

        }

        System.out.println("The value of d < " + limit + " for which 1/d contains the longest recurring cycle is " + result + ".");

    }
}
