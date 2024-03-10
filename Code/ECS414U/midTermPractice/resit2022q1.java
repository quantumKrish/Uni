package ECS414U.midTermPractice;

class Band {

    int members = -999;
    String name = "default";

    public Band (String name) {

        this.name = name;
    }

    public Band (int members) {

        this.members = members;
    }

    public Band () {

    }


    public Band (int members, String name) {
        
        this.members = members;
        this.name = name;

    }

    public String getName () {
        
        return name;
    }

    public int getMembers () {
        
        return members;
    }

    public void setName (String newName) {
        
        name = newName;
        
    }

    public void setMembers (int newMembers) {
        
        members = newMembers;
    }

}
    
public class resit2022q1 {

    public static void main(String[] args) {
        
        // Test 1
        Band b1 = new Band(5, "The Beatles");
        System.out.println(b1.getName());
        System.out.println(b1.getMembers());

        // Test 2
        Band b2 = new Band(4, "The Rolling Stones");
        b2.setMembers(5);
        b2.setName("The Who");
        System.out.println(b2.getName());
        System.out.println(b2.getMembers());

        //test 3

        Band b3 = new Band("Black Sabbath");
        System.out.println(b3.getName());
        System.out.println(b3.getMembers());

        //test 4
        Band b4 = new Band(6);
        System.out.println(b4.getName());
        System.out.println(b4.getMembers());
    }



}
