package ECS414U.Lab3.lab3q1;




public class Utils {

    final static double PI = 3.14;
    


    public static double circlePerimeter(int radius) {

        double doub_temp = ( 2 * PI * radius );
        doub_temp = doub_temp * 10;
        int int_temp = (int) doub_temp;
        double perimeter = (double) int_temp / 10.0;
        return perimeter;
    }

    public static double circleArea(int radius){
        
        double doub_temp = ( PI * radius * radius );
        doub_temp = doub_temp * 10;
        int int_temp = (int) doub_temp;
        double area= (double) int_temp / 10.0;
        return area;
    }
}
