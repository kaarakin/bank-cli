import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        this.timestamp = timestamp;
        this.success = success;
        this.message = message;
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

    public String getFormattedTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return timestamp.format(formatter);
    }

    public boolean isSuccess() {
        return this.success;
    }

    public String getMessage() {
        return this.message;
    }
}