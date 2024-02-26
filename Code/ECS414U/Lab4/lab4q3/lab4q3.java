package ECS414U.Lab4.lab4q3;

import java.util.Random;

public class lab4q3 {

    public static void main(String[] args) {

        Main();
        
    }

    public static void Main () {

        Random random = new Random();
        final int arraySize = random.nextInt(10);

        countAnimalInstances(populateArray(arraySize));

    }

    public static Animal[] populateArray (int arraySize) {

        Animal[] animals = new Animal[arraySize];

        for (int i = 0; i < arraySize; i++) {

            Random random = new Random();
            int randomInt = random.nextInt(5); // 0, 1, 2, 3 or 4

            if (randomInt == 0) {

                animals[i] = new Cat();

            } else if (randomInt == 1) {

                animals[i] = new Dog();

            } else if (randomInt == 2) {

                animals[i] = new Pig();
            } else {

                animals[i] = new Cow();
            }
        }

        printArray(animals);
        return animals;
    }


    public static int[] countAnimalInstances(Animal[] animals) {

        int[] animalCount = new int[4];

        for (int i = 0; i < animals.length; i++) {

            if (animals[i] instanceof Cat) {

                animalCount[0]++;

            } else if (animals[i] instanceof Dog) {

                animalCount[1]++;

            } else if (animals[i] instanceof Pig) {

                animalCount[2]++;

            } else {

                animalCount[3]++;
            }
        }

        printCountArray(animalCount);
        return animalCount;
    }


    private static void printCountArray(int[] animalCount) {
    
        String message = "{";

        for (int i = 0; i < animalCount.length; i++) {

            message += animalCount[i] + ", ";
        }

        message = message + "}";
        System.out.println("\n\n" + message);
    }

    private static void printArray(Animal[] animals) {
    
        for (int i = 0; i < animals.length; i++) {
            System.out.println(animals[i]);
        }

        System.out.println("\n\n");
    }



    
}
