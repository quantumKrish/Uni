import java.util.Scanner;

public class endterm {

    public static void main(String [] a)
    {
        stringMapper();
    } // end of main method

    public static void stringMapper() {

        // intialise variables
        final int maxSpace = 100;
        int index = 0;
        String[] keys = new String[maxSpace];
        String[] values = new String[maxSpace];
    
            while (index < maxSpace) {

                // assigns input to key through inputString method
                String key = inputString("Enter new map key or XXX to end: ");
                
                // if the input value is equal to "XXX" then it will exit the loop
                if (key.equals("XXX")) {
                    break;
                }
                
                // assigns input to value through inputString method
                String value = inputString("Enter map value for key " + key + ": ");
    
                // corresponding key and value are added to arrays at the same index 
                keys[index] = key;
                values[index] = value;

                index++;

            } // end while loop
    
            System.out.println("Map contents:");

            // contents of array are printed using for loop
            for (int i = 0; i < index; i++) {
                System.out.println(keys[i] + " -> " + values[i]);

            } // end for loop
    
        } // end stringMapper
        

        // method that takes message as parameter and returns an input
        public static String inputString(String message) {

        Scanner scanner = new Scanner(System.in);
        String textinput;
        System.out.print(message);
        textinput = scanner.nextLine();

        return textinput;

        } // end inputString

} // end class

