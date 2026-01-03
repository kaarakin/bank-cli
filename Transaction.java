import java.time.LocalDateTime;

public class Transaction {
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

    public TransactionType getType() {
        return this.type;
    }

    public double getAmount() {
        return this.amount;
    }

    public String getFromAccountNumber() {
        return this.fromAccountNumber;
    }

    public String getToAccountNumber() {
        return this.toAccountNumber;
    }

    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public String getMessage() {
        return this.message;
    }
}