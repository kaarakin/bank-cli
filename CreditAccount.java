public class CreditAccount extends Account {
    private double creditLimit = 10000;

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