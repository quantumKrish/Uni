package ECS414U.Lab1;

public class lab1q5 {

    public static void main(String[] args) {

        int[] xs = {1,2,3,4};
        int k = 2;

        final int arrayLength = xs.length;
        int[] filteredArray = new int[getDivisibleValues(xs, k, arrayLength)];

        filterAndReverse(xs, filteredArray, k, arrayLength);
        printArrayList(filteredArray);

    }

    public static int getDivisibleValues (int[] xs, int k, int arrayLength) {

        int divValues = 0;

        for (int i = arrayLength - 1; i >= 0; i--) {

            if ( xs[i] % k == 0) {

                divValues++;

            }
        }

        return divValues;
    }

    public static int[] filterAndReverse(int[] xs, int[] filteredArray, int k, int arrayLength) {

        int j = 0;

        for (int i = arrayLength - 1; i >= 0; i--) {

            if ( xs[i] % k == 0) {

                filteredArray[j] = xs[i];

                j++;
            }
        }

        return filteredArray;
    }

//----------------------------------------------------------------------------------//
//----------------------         INPUT OUTPUT METHODS          ---------------------//
//----------------------------------------------------------------------------------//

    // This method prints every element in the array passed to it as a list
    //
    public static void printArrayList (int[] filteredArray) {

        for (int currentIndex = 0; currentIndex < filteredArray.length; currentIndex++) {

            System.out.println(filteredArray[currentIndex]);
        }

        return;
    } 
    //END printArrayList
    
}
