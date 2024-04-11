package ECS414U.endTermPractice.pracTest1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class taskA {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String message = inputString("Please enter a message: ");
        countVowelsAndConsonants(message);
        
    }


    public static void countVowelsAndConsonants (String message) {

        message = message.trim();

        Map<String, Integer> counts = new HashMap<>();

        int vowels = 0;
        int consonants = 0;
   

        char charArray[] = message.toCharArray();


        for (int i = 0; i < charArray.length; i++) {

            if (Character.isLetter(charArray[i])) {

                if (charArray[i] == 'a' || charArray[i] == 'e' || charArray[i] == 'i' || charArray[i] == 'o' || charArray[i] == 'u') {
                    
                    vowels++;

                } else {

                    consonants++;
                }
            }
        }    

        counts.put("Vowels", vowels);
        counts.put("Consonants", consonants);

        System.out.println(counts);

    }

    public static String inputString(String message) {

        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        String textinput = scanner.nextLine();  
    
        return textinput;
    } 

}
