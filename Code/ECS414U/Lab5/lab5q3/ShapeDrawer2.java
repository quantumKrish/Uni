package ECS414U.Lab5.lab5q3;

class ShapeDrawer2 extends Drawer implements SquareDrawer {

    public ShapeDrawer2(int sideLength, char filler, char special) {
        super(sideLength, filler, special);
    }


    public void drawStairCase() {

        for (int i = 1; i < sideLength + 1; i++) {

           for (int repeat = 0; repeat < sideLength; repeat++) {

               for (int x = 0; x < (sideLength) * i; x++) {

                   System.out.print(filler);
                }

               System.out.println();
            }
        }
    }


    public void drawSquare(int sideLength, char filler) {

        for (int i = 0; i < sideLength; i++) {

            for (int j = 0; j < sideLength; j++) {

                System.out.print(filler);
            }
            System.out.println();
        }

        
    }


    public void drawSpecialSquare(int sideLength, char filler, char special) {

        int lowerLimit = 0;
        int upperLimit = sideLength - 1;
        boolean middleReached = false;

        for (int i = 0; i < sideLength; i++) {

            while (!middleReached) {

                for (int j = 0; j < sideLength; j++) {

                    if ( j == lowerLimit || j == upperLimit ) {
                        System.out.print(special);
                    } else {
                        System.out.print(filler);
                    }
                }
                System.out.println();

                // If the lower and upper limits are the same, we have reached the middle of the square
                if ( lowerLimit == upperLimit ) {
                    middleReached = true;

                    lowerLimit = lowerLimit - 2;
                    upperLimit = upperLimit + 2;
                }

                lowerLimit++;
                upperLimit--;
                i++;
            }  


            for (int j = 0; j < sideLength; j++) {


                if ( j == lowerLimit || j == upperLimit ) {
                    System.out.print(special);
                } else {
                    System.out.print(filler);
                }
            }
            System.out.println();

            lowerLimit--;
            upperLimit++;
        }
    }


}