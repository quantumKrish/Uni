package ECS414U.Lab5.lab5q2;

class ShapeDrawer1 extends Drawer implements SquareDrawer {

    public ShapeDrawer1(int sideLength, char filler, char special) {
        super(sideLength, filler, special);

    }

    public void drawSquare() {

        for (int i = 0; i < sideLength; i++) {

            for (int j = 0; j < sideLength; j++) {

                System.out.print(filler);
            }
            System.out.println();
        }

        
    }

    public void drawSpecialSquare() {

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
