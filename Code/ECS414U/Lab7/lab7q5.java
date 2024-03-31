package ECS414U.Lab7;

import java.util.Stack;

public class lab7q5 {

    public static void main(String[] args) {

        System.out.println(matchingBrackets("{[()]}"));             // true
        System.out.println(matchingBrackets("((({{{[[]]}}})))"));   // true
        System.out.println(matchingBrackets("()"));                 // true
        System.out.println(matchingBrackets("[]"));                 // true
        System.out.println(matchingBrackets("{}"));                 // true
        System.out.println();
        System.out.println(matchingBrackets("{[(])}"));             // false
        System.out.println(matchingBrackets("[(){}"));              // false
        System.out.println(matchingBrackets(")"));                  // false
        System.out.println(matchingBrackets("({)}"));               // false
    }
    

    public static boolean matchingBrackets (String brackets) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < brackets.length(); i++) {

            char bracket = brackets.charAt(i);

            // pushes open brackets onto stack
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                stack.push(bracket);

            } else {

                // if stack is empty then theres no opening brackets so unbalanced
                if (stack.isEmpty()) {

                    return false;
                }

                // gets opposite bracket
                char top = stack.pop();

                // compares the closing bracket and if they not corresponding then unbalanced
                if ((bracket == ')' && top != '(') || (bracket == ']' && top != '[') ||
                    (bracket == '}' && top != '{')) {

                    return false;
                }
            }
        }

        // return true when stack is empty meaning they all corrensponding
        return stack.isEmpty();
    }
}