package ECS414U.Lab2.lab2q1;


public class lab2q1 {

    public static void main(String[] args) {
        BankAccount ba = new BankAccount("123456789");

        System.out.println(ba.getAccountNumber());
        System.out.println(ba.getBalance());

        double depositAmount = 100;
        System.out.println(ba.deposit(depositAmount));        // true

        double invalidDepositAmount = -100;
        System.out.println(ba.deposit(invalidDepositAmount)); // false

        double withdrawAmount = 50;
        System.out.println(ba.withdraw(withdrawAmount));      // true

        double tooHighWithdrawal = 200;
        System.out.println(ba.withdraw(tooHighWithdrawal));   // false

        double tooLowWithdrawal = -200;
        System.out.println(ba.withdraw(tooLowWithdrawal));    // false

        System.out.println(ba.getAccountNumber());
        System.out.println(ba.getBalance());
    }

    
}
