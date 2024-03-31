package ECS414U.Lab7;

import java.util.HashMap;
import java.util.LinkedList;

public class lab7q4 {
    
    public static void main(String[] args) {

        LinkedList<String> a = new LinkedList<>();
        a.add("Java");
        a.add("Python");
        a.add("Java");
        a.add("C++");

        System.out.println(getCounts(a).toString());

    }


    public static HashMap<String, Integer> getCounts(LinkedList<String> list) {

        HashMap<String, Integer> counts = new HashMap<>(); 
        int listSize = list.size();

        for (int i = 0; i < listSize; i++) {

            // gets value of the key if it exists in map and if it doesnt then it initalises it with 0
            int assignedNum = counts.getOrDefault(list.get(i), 0); 

            // overwrites previous key and value with an incremented value
            counts.put(list.get(i), assignedNum + 1);
        }

        return counts;
    }
}

