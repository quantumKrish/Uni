package ECS414U.Lab8;

class CustomException extends Exception {

    CustomException(String message) {

        super(message);
    }

    public String getMessage() {

        return "Custom Exception: " + super.getMessage();
    }
}

public class lab8q4 {

    public static void main(String[] args) {

        try {

            System.out.println(calculateSquare(5));
            System.out.println(calculateSquare(-5));

        } catch (CustomException e) {

            System.out.println(e.getMessage());
        }
    }

    public static int calculateSquare(int number) throws CustomException {

        if (number < 0) {
            
            throw new CustomException("Negative numbers are not allowed");
        }
        return number * number;
    }
}
