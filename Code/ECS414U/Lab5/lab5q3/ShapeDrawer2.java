package ECS414U.Lab5.lab5q3;

class ShapeDrawer2 extends Drawer implements SquareDrawer, StairCaseDrawer {

    public ShapeDrawer2(int sideLength, char filler, char special) {

        super(sideLength, filler, special);
    }


    public void drawSquare(int sideLength, char filler) {

        for (int i = 0; i < sideLength; i++) {

            for (int j = 0; j < sideLength; j++) {

                System.out.print(filler);
            }
            System.out.println();
        }
    }


    public void StaircaseDrawer(int sideLength, char filler) {

        for (int y = 1; y < sideLength + 1; y++) {

           for (int repeat=0;repeat<sideLength;repeat++) {
               for (int x=0; x<(sideLength)*y;x++) {
                   System.out.print(filler);
               }
               System.out.println();
           }

       }
   }
}

}
