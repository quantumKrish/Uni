package ECS414U.Lab7;

import java.util.ArrayList;
import java.util.LinkedList;

public class lab7q3 {

    public static void main(String[] args) {

        LinkedList<String> a = new LinkedList<>();
        a.add("Alice");
        a.add("Bob");
        a.add("Charlie");

        System.out.println(toReversedArrayList(a).toString());
    }
    
    public static ArrayList<String> toReversedArrayList (LinkedList<String> list) {

        int listSize = list.size();
        String temp = "";
        ArrayList <String> newArrayList = new ArrayList<>();


        for (int i = 0; i < listSize; i++) {

            temp = list.removeLast();
            newArrayList.add(temp);
        }

        return newArrayList;
    }
}
