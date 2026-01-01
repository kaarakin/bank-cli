public class DebitAccount extends Account {
    public DebitAccount(Customer owner) {
        this.accountNumber = count;
        this.balance = 0;
        this.owner = owner;
        count++;
    }

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