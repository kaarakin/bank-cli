public class Account {
    private String accountNumber;
    private double balance;
    private Customer owner;

    public static int count = 0;

    public Account(Customer owner) {
        this.accountNumber = String.valueOf(count);
        this.balance = 0;
        this.owner = owner;
        count++;
    }

    final public boolean deposit(double amount) {
        if (amount > 0) {
            double balance = this.getBalance();
            if (balance >= 0) {
                this.setBalance(balance + amount);
                return true;
            }
        }

        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0) {
            double balance = this.getBalance();
            if (balance >= amount) {
                this.setBalance(balance - amount);
                return true;
            }
        }

        return false;
    }

    public boolean transfer(Account to, double amount) {
        if (amount > 0) {
            if (withdraw(amount)) {
                to.setBalance(to.getBalance() + amount);
                return true;
            }
        }

        return false;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Customer getOwner() {
        return this.owner;
    }

    public void getOwner(Customer owner) {
        this.owner = owner;
    }
}

// todo: все требования для Account