import java.util.Scanner;

class exam2023q1
{

    public static void main(String [] a)
    {
        full_program();
    } // end of main method


     
    public static void full_program() {

        int points = get_points();
        calculate_midpoint(points);

    }

    // gets the points from the user
    //
    public static int get_points() {
        int points;
    
        while (true) {
            points = inputInt("How many points? (>0) ");
    
            if (points > 0) {
                break; // Break out of the loop if points are greater than 0
            }
    
            System.out.println("Please enter a number greater than 0.");
        }
    
        return points;

    } // end of get_points


    // calculates the midpoint through looping to get all coords then calucating the midpoint using the formala: 
    // ((x1 + ... + xn) / n) , ((y1 + ... + yn) / n)
    //
    public static void calculate_midpoint(int points) {

        double total_x = 0;
        double total_y = 0;


        for (int i = 1; i < points + 1; i++) {

            total_x = total_x + get_xcoord(i, total_x);
            total_y = total_y + get_ycoord(i, total_y);

        } // end of for loop


        double x_midpoint = calc_xmidpoint(points, total_x);
        double y_midpoint = calc_ymidpoint(points, total_y);

        String output = make_message(x_midpoint, y_midpoint);

        System.out.println(output); 

    } // end of calcMidpoint


    //  takes input for value of x coord and increments it onto total_x
    //
    public static double get_xcoord(int i, double total_x) {

        double xcoord = inputInt("Enter x_" + i + ": ");
        return xcoord;

    }   // end get_xoord


    //  takes input for value of y coord and increments it onto total_y
    //   
    public static double get_ycoord(int i, double total_y) {

        double ycoord = inputInt("Enter y_" + i + ": ");
        return ycoord;

    }   // end get_ycoord


    // takes points and total_x and divides them to get the midpoint of the x values
    //
    public static double calc_xmidpoint(int points, double total_x){

        double x_midpoint = total_x / points;
        return x_midpoint;

    } // end calc_xmidpoint


    // takes points and total_y and divides them to get the midpoint of the y values
    //
    public static double calc_ymidpoint(int points, double total_y){

        double y_midpoint = total_y / points;
        return y_midpoint;

    } // end calc_ymidpoint


    // takes the two midpoints and contructs the output message
    //
    public static String make_message (double x_midpoint, double y_midpoint) {

        String message = ("The mid-point is: (" + x_midpoint + ", " + y_midpoint + ")");
        return message;

    } // end make message

    // takes a message as a parameter, outputs it and then takes an integer as an input and returns it
    //
    public static int inputInt(String message) {

        Scanner scanner = new Scanner(System.in);

        System.out.print(message);
        int integerinput = scanner.nextInt();

        return integerinput;

    } // end inputString


} // end of exam2023q1 class