import java.util.ArrayList;
import java.time.LocalDateTime;

public class Bank {
    ArrayList<Customer> customers;
    ArrayList<Account> accounts;
    ArrayList<Transaction> transactions;

    public Bank() {
        this.customers = new ArrayList<Customer>();
        this.accounts = new ArrayList<Account>();
        this.transactions = new ArrayList<Transaction>();
    }

    public Customer createCustomer(String fullName) {
        Customer customer = new Customer(fullName);
        customers.add(customer);

        return customer;
    }

    public Account openDebitAccount(Customer owner) {
        DebitAccount debitAccount = new DebitAccount(owner);
        accounts.add(debitAccount);

        return debitAccount;
    }

    public Account openCreditAccount(Customer owner, double creditLimit) {
        CreditAccount creditAccount = new CreditAccount(owner, creditLimit);
        accounts.add(creditAccount);

        return creditAccount;
    }

    public Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }

        return null;
    }

    public Customer findCustomer(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }

        return null;
    }

    public boolean deposit(String accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        boolean success = false;
        String message = "Not successful";

        LocalDateTime time = LocalDateTime.now();
        if (account != null && account.deposit(amount)) {
            success = true;
            message = "OK";
        }

        transactions.add(new Transaction(TransactionType.DEPOSIT, amount, accountNumber, accountNumber,
                                     time, success, message)
        );

        return success;
    }

    public boolean withdraw(String accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        boolean success = false;
        String message = "Not successful";

        LocalDateTime time = LocalDateTime.now();
        if (account != null && account.withdraw(amount)) {
            success = true;
            message = "OK";
        }

        transactions.add(new Transaction(TransactionType.WITHDRAW, amount, accountNumber, accountNumber,
                time, success, message)
        );

        return success;
    }

    public boolean transfer(String from, String to, double amount) {
        Account accountFrom = findAccount(from);
        Account accountTo = findAccount(to);
        boolean success = false;
        String message = "Not successful";

        LocalDateTime time = LocalDateTime.now();
        if (accountFrom != null && accountTo != null && accountFrom.transfer(accountTo, amount)) {
            success = true;
            message = "OK";
        }

        transactions.add(new Transaction(TransactionType.TRANSFER, amount, from, to,
                time, success, message)
        );

        return success;
    }

    public void printCustomerAccounts(int customerId) {
        for (Account account : accounts) {
            if (account.getOwner().getId() == customerId) {
                System.out.println(account);
            }
        }
    }

    public void printTransactions() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public void printReport() {
        System.out.println("printReport()");
    }
}