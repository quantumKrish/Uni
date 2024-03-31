package ECS414U.Lab8;

public class lab8q3 {

    public static void main(String[] args) {
        
        System.out.println(getLength(null));

    }

    static int getLength(String s) {

        int length = 0;

        try {

            length = s.length();

        } catch (NullPointerException e) {

            System.out.println("NullPointerException: Null string");
            length = -1;

        } catch (IllegalArgumentException e) {

            System.out.println("IllegalArgumentException: Illegal argument");
            length = -1;
                 
        } catch (Exception e) {

            System.out.println("Exception: " + e.getMessage());
            length = -1;

        } finally {

            System.out.println("Finally block executed");
            return length;

        }
    }
    
}
