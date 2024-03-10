package ECS414U.midTermPractice;

class Wine {

    int year;
    String grape;
    
    public Wine() {

    }

    public Wine(int year, String grape) {
        this.year = year;
        this.grape = grape;
    }
    
    public String getGrape () {
    
        return grape;
    }

    public int getYear () {
        
        return year;
    }

    public void setGrape (String newGrape) {
        
        grape = newGrape;
        
    }

    public void setYear (int newYear) {
        
        year = newYear;
    }
}



public class q1 {

    public static void main(String[] args) {

        // Test 1
        Wine p1 = new Wine(2019, "Syrah");
        System.out.println(p1.getGrape());
        System.out.println(p1.getYear());

        // Test 2
        Wine p2 = new Wine();
        p2.setYear(2021);
        p2.setGrape("Tempranillo");
        System.out.println(p2.getGrape());
        System.out.println(p2.getYear());
    }
    
}
