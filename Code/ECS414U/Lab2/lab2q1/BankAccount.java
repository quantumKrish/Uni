package ECS414U.Lab2.lab2q1;

public class BankAccount {

    String accountNumber;
    int balance;

    public BankAccount(String pAccountNumber) {
        this.accountNumber = pAccountNumber;
        this.balance = 0;
    }

    public String getAccountNumber () {

        return accountNumber;
    }

    public int getBalance() {

        return balance;
    }
    
    
    public boolean deposit(double depositAmount) {

        if (depositAmount > 0) {
        
            this.balance += depositAmount;
            return true;

        } else {

            return false;
        }
    }


    public boolean withdraw(double withdrawAmount) {

        if ( (withdrawAmount > 0) && (balance - withdrawAmount > 0 ) ) {

            this.balance -= withdrawAmount;
            return true;

        } else {

            return false;
        }
    }


    

}