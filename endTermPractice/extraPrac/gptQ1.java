package endTermPractice.extraPrac;

import java.util.HashMap;
import java.util.logging.Handler;

public class gptQ1 {

    public static void main(String[] args) {
        
    }
    
    public static boolean isAnagram(String text1, String text2) {

        text1 = text1.toLowerCase();
        text2 = text2.toLowerCase();

        text1 = text1.replaceAll("[^a-zA-Z0-9]", "");
        text2 = text2.replaceAll("[^a-zA-Z0-9]", "");

        HashMap<String, Integer> text1Details = new HashMap<>();
        HashMap<String, Integer> text2Details = new HashMap<>();


    }


}
