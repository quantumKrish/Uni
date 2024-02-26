package ECS414U.Lab5.lab5q1;

public class lab5q1 {

    public static void main(String[] args) {

        Drawer drawer = new Drawer(5, '*', 'X');

        System.out.println("Square properties:");
        System.out.println(drawer.sideLength);
        System.out.println(drawer.filler);
        System.out.println(drawer.special);
    }
}
