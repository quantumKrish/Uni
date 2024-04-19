package horseRacingSim;

public class HorseTest {

    public static void main(String[] args) {
        testConstructor();
        testSetConfidenceOutOfRange();
        testSetNameNull();
    }

    public static void testConstructor() {
        char symbol = '\uD83D';
        String name = "testHorse";
        double confidence = 0.8;

        Horse horse = new Horse(symbol, name, confidence);

        // Check if constructor initializes the Horse object correctly
        if (horse.getSymbol() == symbol && horse.getName().equals(name)
                && horse.getConfidence() == confidence && horse.getDistanceTravelled() == 0
                && !horse.hasFallen()) {

            System.out.println("Test passed: Constructor initializes the Horse object correctly.");

        } else {

            System.out.println("Test failed: Constructor does not initialize the Horse object correctly.");
        }
    }
    

    public static void testSetConfidenceOutOfRange() {

        Horse horse = new Horse('\uD83D', "Shadowfax", 0.8);

        try {

            horse.setConfidence(1.5); // attempt to set confidence outside the valid range
            System.out.println("Test failed: Confidence outside range accepted.");

        } catch (IllegalArgumentException e) {

            System.out.println("Test passed: Confidence outside range correctly rejected.");
        }
    }

    public static void testSetNameNull() {

        Horse horse = new Horse('\uD83D', "Shadowfax", 0.8);

        try {

            horse.setName(null); // attempt to set name to null
            System.out.println("Test failed: Null name accepted.");
            
        } catch (IllegalArgumentException e) {

            System.out.println("Test passed: Null name correctly rejected.");
        }
    }
}
