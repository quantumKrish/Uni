package ECS414U.Lab4.lab4q1;

import java.util.Random;

public class lab4q1 {

    public static void main(String[] args) {

        Main();
        
    }

    public static void Main () {

        Random random = new Random();
        final int arraySize = random.nextInt(10);

        populateArray(arraySize);
    }

    public static void populateArray (int arraySize) {

        Animal[] animals = new Animal[arraySize];

        for (int i = 0; i < arraySize; i++) {

            Random random = new Random();
            int randomInt = random.nextInt(2); // 0 or 1

            if (randomInt == 0) {

                animals[i] = new Cat();

            } else {

                animals[i] = new Dog();
            }
        }

        printArray(animals);
    }

    private static void printArray(Animal[] animals) {
   
        for (int i = 0; i < animals.length; i++) {

            System.out.println(animals[i]);
        }
    }
    
}
