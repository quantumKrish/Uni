package endTermPractice.practTest2;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.*;

class task1 {

    public static void main(String[] args) {
        
        String message = "QMUL is a renowned institution located in London, offering diverse academic programs and fostering a vibrant learning community," ;
        calculateWordFrequency(message);
    }

    public static void calculateWordFrequency(String message) {

        Map<String, Integer> frequency = new HashMap<>();
        String[] words = message.split(" ");
        String[] cleanWords = new String[words.length];


        Pattern pattern = Pattern.compile("[a-zA-Z0-9]+");
        Matcher matcher = pattern.matcher(message);

        int j = 0;
        while (matcher.find()) {
            cleanWords[j] = matcher.group();
            j++;
        }

        for (String word : cleanWords) {

            if (frequency.containsKey(word)) {

                frequency.put(word, frequency.get(word) + 1);

            } else {

                frequency.put(word, 1);  

            }
        }

        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
