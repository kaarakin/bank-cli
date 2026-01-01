public class DebitAccount extends Account {
    public boolean withdraw(double amount) {
        if (amount > 0) {
            if (this.balance > amount) {
                this.balance -= amount;
                return true;
            }
        }

        return false;
    }
}