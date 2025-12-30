public class Account {
    private int accountNumber;
    private int balance;
    private Customer owner;

    public boolean deposit(double amount) {
        if (amount > 0 && this.balance > 0) {
            this.balance += amount;
            return true;
        }

        return false;
    }

    public boolean withdraw(double amount) {
        if ((amount > 0 && this.balance > 0) && (this.balance > amount)) {
            this.balance -= amount;
            return true;
        }

        return false;
    }

    public boolean transfer(Account to, double amount) {
        if ((amount > 0 && this.balance > 0) && (this.balance > amount)) {
            this.balance -= amount;
            to.balance   += amount;
            return true;
        }

        return false;
    }

    public int getBalance() {
        return this.balance;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public Customer getOwner() {
        return this.owner;
    }
}

// todo: все требования для Account