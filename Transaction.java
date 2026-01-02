import java.time.LocalDateTime;

public class Transaction {
//    public enum TransactionType {
//        DEPOSIT,
//        WITHDRAW,
//        TRANSFER
//    }

    private TransactionType type;
    private double amount;
    private String fromAccountNumber;
    private String toAccountNumber;
    private LocalDateTime timestamp;
    private boolean success;
    private String message;

    public Transaction(TransactionType type, double amount, String fromAccountNumber, String toAccountNumber,
                       LocalDateTime timestamp, boolean success, String message) {
        this.type = type;
        this.amount = amount;
        this.fromAccountNumber = fromAccountNumber;
        this.toAccountNumber = toAccountNumber;
    }
}