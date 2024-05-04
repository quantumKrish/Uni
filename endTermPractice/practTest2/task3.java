package endTermPractice.practTest2;

import java.util.*;
import java.util.regex.*;

public class task3 {
    
    public static void main(String[] args) {

         if (isPalindrome("Madam, in Eden, I'm Adam")) {

            System.out.println("true");
         } else {

            System.out.println("false");
         }
        
    }

    public static boolean isPalindrome(String text) {

        text = text.toLowerCase();
        text = text.replaceAll("[^a-zA-Z0-9]", "");

        Stack<Character> stack = new Stack<Character>();

        int length = text.length();

        String firstHalf = text.substring(0, length / 2);
        String secondHalf = text.substring((length / 2) + 1, length);

        for (int i = 0; i < firstHalf.length(); i++) {
            stack.push(firstHalf.charAt(i));
        }

        for (int i = 0; i < secondHalf.length(); i++) {

            if (stack.pop() != secondHalf.charAt(i)) {
                return false ; //retuen false

            }
        }

        return true;
    }
}
