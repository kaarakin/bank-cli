import java.time.LocalDateTime;

public class Transaction {
    public enum TransactionType {
        DEPOSIT,
        WITHDRAW,
        TRANSFER
    }

    TransactionType type;
    double amount;
    private int fromAccountNumber;
    private int toAccountNumber;
    LocalDateTime timestamp;
    boolean success;
    String message;
}