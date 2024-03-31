package ECS414U.Lab8;
    import java.util.Scanner;


public class lab8q2 {
    
    public static void main(String[] args) {

        System.out.println(getQuotient(25));
        
    }


    static int getQuotient(int dividend) {

        try {        

            Scanner s = new Scanner(System.in);
            System.out.print("divisor: ");
            int divisor = Integer.parseInt(s.nextLine());
            return dividend / divisor;

        } catch (ArithmeticException e) {

            System.out.println("ArithmeticException: Division by zero");
            return 0;

        } catch (NumberFormatException e) {

            System.out.println("NumberFormatException: Invalid input");
            return 0;

        } catch (Exception e) {

            System.out.println("Exception: " + e.getMessage());
            return 0;
        }
    } 


}
