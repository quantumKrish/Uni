package horseRacingSim.exceptions;

public class invalidSymbolException extends Exception{

    public invalidSymbolException() {
        super("Symbol cannot be null, empty or more than one character.");
    }
    
}
