package horseRacingSim;

/**
 * Horse class contains the fields and methods for the horse object
 * 
 * @author Kirishanth Pirathapan 
 * @version (18/03/2024)
 */
public class Horse {
    
    //Fields of class Horse
    private String name;
    private String symbol;
    private int distance;
    private boolean fallen;
    private double confidence;
    
      
    //Constructor for objects of class Horse     
    public Horse (String symbol, String name, double confidence) {

        setSymbol(symbol);
        setName(name);
        setConfidence(confidence);
        goBackToStart(); 
        fallen = false;
    }
    
    
    //Other methods of class Horse
    public boolean fall() {
        fallen = true;
        return fallen;
    }

    public boolean hasFallen() {

        if (fallen) {
            return true;
            
        } else {
            return false;
        }
    }

    public double getConfidence() {
        return confidence;
    }

    public int getDistanceTravelled() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void goBackToStart() {
        distance = 0;
    }

    public void moveForward() {
        distance++;
    }

    public void setConfidence(double confidence) {

        // ensure confidence is within valid range (0 to 1)
        if (confidence >= 0 && confidence <= 1) {

            this.confidence = confidence;

        } else {

            throw new IllegalArgumentException("Confidence must be between 0 and 1");
        }
    }

    public void setSymbol(String symbol) {

        // ensure symbol is not null and is a single character
        if (symbol != null && symbol.length() == 1 && Character.isLetter(symbol.charAt(0))) {

            this.symbol = symbol;

        } else {

            throw new IllegalArgumentException("Symbol must be a single letter");
        }
    }


    
    public void setName(String name) {

        // ensure name is not null or empty
        if (name != null && !name.isEmpty()) {

            this.name = name;

        } else {

            throw new IllegalArgumentException("Name cannot be null or empty");
        }
    }
    
}
