package ECS414U.midTermPractice;

class BankTransaction {

    double amount;
    String transactionType;
    String date;
    String description;

    
    public BankTransaction (int amount, String transactionType, String date, String description) {

        this.amount = amount;
        this.transactionType = transactionType;
        this.date = date;
        this.description = description;
    }

    public String toString () {

        String message = "";

        if (transactionType.equals("Withdrawal")) {

            message = "Withdrawal of " + amount;
            return message;
            
        } else if (transactionType.equals("Deposit")) {

            message = "Deposit of " + amount;
            return message;
            
        } else {

            return "Invalid transaction type entered.";
        }    
    }

    public void printTransactionDetails () {

        String message = "";
        message = toString() + " on " + date + " for " + description;
        System.out.println(message);
    }
}