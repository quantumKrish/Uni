package ECS414U.midTermPractice;

class BankAccount {

    protected int accountNumber;
    protected String accountHolder;
    protected double balance;

    public BankAccount (int accountNumber, String accountHolder, double balance) {

        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void setAccountNumber (int newAccountNumber) {

        accountNumber = newAccountNumber;
    }

    public void setAccountHolder (String newAccountHolder) {

        accountHolder = newAccountHolder;
    }

    public void setBalance (double newBalance) {

        balance = newBalance;
    }

    public int getAccountNumber () {

        return accountNumber;
    }

    public String getAccountHolder () {

        return accountHolder;
    }

    public double getBalance () {

        return balance;
    }
}

interface InterestEarning {

    public void calculateInterest ();
    
}

interface transaction {

    public double deposit (double amount);
    public double withdraw (double amount);
}

class SavingsAccount extends BankAccount implements InterestEarning, transaction{

    double interestRate;
    double interest;

    public SavingsAccount (int accountNumber, String accountHolder, double balance, double interestRate) {

        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    public void setInterestRate (double newInterestRate) {

        interestRate = newInterestRate;
    }

    public double getInterestRate () {

        return interestRate;
    }

    public void calculateInterest () {

        interest = balance * interestRate;
        System.out.println("Interest: $" + String.valueOf(interest)); 
    }

    public double deposit (double amount) {

        System.out.println("Deposit: $" + String.valueOf(amount) + " into savings account.");
        return balance += amount;
    }

    public double withdraw (double amount) {

        if (balance - amount < balance) {
            System.out.println("Insufficient funds.");
            return balance;
        } else {
            System.out.println("Withdrawal: $" + String.valueOf(amount) + " from savings account.");
            return balance -= amount;
        }
    }

    public String toString () {

        return "Savings Account[accountNumber:" + accountNumber + ", accountHolder:" + accountHolder + ", balance:" + balance + ", interestRate:" + interestRate + "]";
    }   
}

class CheckingAccount extends BankAccount implements transaction{

    double overdraftLimit;

    public CheckingAccount (int accountNumber, String accountHolder, double balance, double overdraftLimit) {

        super(accountNumber, accountHolder, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public void setOverdraftLimit (double newOverdraftLimit) {

        overdraftLimit = newOverdraftLimit;
    }

    public double getOverdraftLimit () {

        return overdraftLimit;
    }

    public double deposit (double amount) {

        System.out.println("Deposit: $" + String.valueOf(amount) + " into checking account.");
        return balance += amount;
    }

    public double withdraw (double amount) {

        if (balance - amount < overdraftLimit) {
            System.out.println("Insufficient funds.");
            return balance;
        } else {
            System.out.println("Withdrawal: $" + String.valueOf(amount) + " from checking account.");
            return balance -= amount;
        }
    }

    public String toString () {

        return "Checking Account[accountNumber:" + accountNumber + ", accountHolder:" + accountHolder + ", balance:" + balance + ", overdraftLimit:" + overdraftLimit + "]";
    }
}






public class gptQ3 {

    public static void main(String[] args) {

        SavingsAccount savingsAccount = new SavingsAccount(123, "Alice", 1000.0, 0.02);
        CheckingAccount checkingAccount = new CheckingAccount(456, "Bob", 500.0, 200.0);
        
        System.out.println(savingsAccount);
        System.out.println(checkingAccount);
        
        // Perform transactions and print details
        savingsAccount.deposit(500.0);
        checkingAccount.withdraw(300.0);

        savingsAccount.calculateInterest();


    }
    
}