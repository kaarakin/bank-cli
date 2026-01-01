import java.util.ArrayList;

public class Bank {
    ArrayList<Customer> customers;
    ArrayList<Account> accounts;
    ArrayList<Transaction> transactions;

    Customer createCustomer(String fullName) {
        customer = Customer(fullName);
        customers.add(customer);

        return customer;
    }

    Account openDebitAccount(Customer owner) {
        debitAccount = DebitAccount(owner);
        accounts.add(debitAccount);

        return debitAccount;
    }

    Account openCreditAccount(Customer owner, double creditLimit) {
        creditAccount = CreditAccount(owner, creditLimit);
        accounts.add(creditAccount);

        return creditAccount;
    }

    Account findAccount(String accountNumber) {
        for (account : accounts) {
            if (account.accountNumber == accountNumber) {
                return account;
            }
        }
    }

    boolean deposit(String accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        boolean success = false;

        time = LocalDateTime.now();
        if (account.deposit(amount)) {
            success = true;
            String message = "OK";
        }

        transactions.add(Transaction(DEPOSIT, amount, accountNumber, accountNumber,
                                     time, success, message)
        );

        return success;
    }

    boolean withdraw(String accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        boolean success = false;

        time = LocalDateTime.now();
        if (account.withdraw(amount)) {
            success = true;
            String message = "OK";
        }

        transactions.add(Transaction(WITHDRAW, amount, accountNumber, accountNumber,
                time, success, message)
        );

        return success;
    }

    boolean transfer(String from, String to, double amount) {
        Account account = findAccount(accountNumber);
        boolean success = false;

        time = LocalDateTime.now();
        if (account.transfer(from, to, amount)) {
            success = true;
            String message = "OK";
        }

        transactions.add(Transaction(WITHDRAW, amount, from, to,
                time, success, message)
        );

        return success;
    }

    void printCustomerAccounts(int customerId) {
        for (account : accounts) {
            if (account.owner.getId() == customerId) {
                System.out.println(account);
            }
        }
    }

    void printTransactions() {
        for (transaction : transactions) {
            System.out.println(transaction);
        }
    }

    void printReport() {
        System.out.println("printReport()");
    }
}