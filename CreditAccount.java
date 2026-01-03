public class CreditAccount extends Account {
    private double creditLimit;

    public CreditAccount(Customer owner, double creditLimit) {
        super(owner);
        this.creditLimit = creditLimit;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            return false;
        }

        double balance = this.getBalance();
        if (balance - amount >= -creditLimit) {
            this.setBalance(balance - amount);
            return true;
        }
        return false;
    }

    public double getCreditLimit() {
        return this.creditLimit;
    }
}