package endTermPractice.pracTest1;

import java.util.Scanner;
import java.util.Stack;

public class taskC {

    public static void main(String[] args) {

        String expression =  "(1 / 9) - 3 * (5 - 2)";
        double result = evaluateExpression(expression);

        System.out.println("Result: " + result);

        
    }


    public static double evaluateExpression(String expression) {

        expression = expression.trim();
        int result = 0;

        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++ ) {

            if (expression.charAt(i) == '1' || expression.charAt(i) == '2' || expression.charAt(i) == '3'
                || expression.charAt(i) == '4' || expression.charAt(i) == '5' || expression.charAt(i) == '6' 
                || expression.charAt(i) == '7' || expression.charAt(i) == '8' || expression.charAt(i) == '9' 
                || expression.charAt(i) == '0') {


                int number = Character.getNumericValue(expression.charAt(i));

                numbers.push(number);
                
            } else if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*' 
                    || expression.charAt(i) == '/') {

                operators.push(expression.charAt(i));

            } else if (expression.charAt(i) == '(') {

                operators.push(expression.charAt(i));

            } else if (expression.charAt(i) == ')') {

                while (operators.peek() != '(') {

                    int number1 = numbers.pop();
                    int number2 = numbers.pop();
                    char operator = operators.pop();

                    if (operator == '+') {

                        numbers.push(number1 + number2);

                    } else if (operator == '-') {

                        numbers.push(number1 - number2);

                    } else if (operator == '*') {

                        numbers.push(number1 * number2);

                    } else if (operator == '/') {

                        numbers.push(number1 / number2);

                    }

                }

                operators.pop();
  
            }
        }

        while (!operators.isEmpty()) {

            int number1 = numbers.pop();
            int number2 = numbers.pop();
            char operator = operators.pop();

            if (operator == '+') {

                numbers.push(number1 + number2);

            } else if (operator == '-') {

                numbers.push(number1 - number2);

            } else if (operator == '*') {

                numbers.push(number1 * number2);

            } else if (operator == '/') {

                numbers.push(number1 / number2);

            }

        }

        return numbers.pop();

    }
}
