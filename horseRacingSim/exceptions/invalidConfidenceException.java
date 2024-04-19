package horseRacingSim.exceptions;

public class invalidConfidenceException extends Exception {

    public invalidConfidenceException() {
        super("Confidence value must be between 0 and 1.");
    }
    
}
