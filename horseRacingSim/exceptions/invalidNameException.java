package horseRacingSim.exceptions;

public class invalidNameException extends Exception {
    
    public invalidNameException() {
        super("Name cannot be null or empty.");
    }
}
