public class CreditAccount extends Account {
    private double creditLimit;

    public CreditAccount(Customer owner, double creditLimit) {
        this.accountNumber = count;
        this.balance = 0;
        this.owner = owner;
        this.creditLimit = creditLimit;
        count++;
    }

    public boolean withdraw(double amount) {
        if (amount > 0) {
            if (this.balance >= -creditLimit) {
                this.balance -= amount;
                return true;
            }
        }

        return false;
    }
}