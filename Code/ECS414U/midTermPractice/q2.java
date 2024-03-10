package ECS414U.midTermPractice;

class Account {
    
    int balance;
    String holder;
    
    public Account (int balance, String holder) {
        
        this.balance = balance;
        this.holder = holder;
    }
    
    public String toString() {
        
        String message;
        float floatBalance;


        // when negative
        if (balance < 0) {

            floatBalance = (float) balance / -100;
            message = holder + ": " + String.format("%.2f", floatBalance) + " debt";
            return message;

        } else {
            floatBalance = (float) balance / 100;
            message = holder + ": " + String.format("%.2f", floatBalance) + " credit";
            return message;
        }
    }

}


public class q2 {

    public static void main(String[] args) {
        
        Account a = new Account(-27412, "Abe");
        System.out.println(a);
    
    }
    
}