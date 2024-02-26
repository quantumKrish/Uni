package ECS414U.Lab4.lab4q2;

import java.util.Random;

public class lab4q2 {

    public static void main(String[] args) {

        Main();
        
    }

    public static void Main () {

        Random random = new Random();
        final int arraySize = random.nextInt(10);

        separateArray(populateArray(arraySize), arraySize);
    }

    public static Animal[] populateArray (int arraySize) {

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
        return animals;
    }




    public static Animal[][] separateArray (Animal[] animals, int arraySize) {

        int catCount = 0;
        int dogCount = 0;

        for (int i = 0; i < arraySize; i++) {

            if (animals[i] instanceof Cat) {

                catCount++;

            } else {

                dogCount++; 
            }
        }

        Animal[][] superArray = new Animal[2][];

        superArray[0] = new Animal [catCount];
        superArray[1] = new Animal [dogCount];

        for (int i = 0; i < catCount; i++) {

            superArray[0][i] = new Cat();
        }

        for (int i = 0; i < dogCount; i++) {

            superArray[1][i] = new Dog();
        }

        printArrayOfArrays(superArray);
        return superArray;
    }

    private static void printArray(Animal[] animals) {
    
        for (int i = 0; i < animals.length; i++) {
            System.out.println(animals[i]);
        }

        System.out.println("\n\n");
    }

    private static void printArrayOfArrays(Animal[][] superArray) {
    
        for (int i = 0; i < superArray.length; i++) {

            for (int j = 0; j < superArray[i].length; j++) {
                System.out.println(superArray[i][j]);
            }
            
        }
    }
    
}
