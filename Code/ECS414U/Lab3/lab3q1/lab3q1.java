package ECS414U.Lab3.lab3q1;



import java.util.Scanner;


public class lab3q1 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the radius of your circle? ");
        int radius = scanner.nextInt();


        System.out.println("The value of pi is 3.14");
        System.out.println("The perimeter of your circle is " + Utils.circlePerimeter(radius)+" units");
        System.out.println("The Area of your circle is " + Utils.circleArea(radius)+" square units");
    }

    
}
