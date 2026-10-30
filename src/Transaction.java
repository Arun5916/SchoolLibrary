import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private String id;
    private String bookId;
    private String memberId;
    private String type;
    private LocalDate date;

    public Transaction(String id, String bookId, String memberId, String type, LocalDate date) {
        this.id = id;
        this.bookId = bookId;
        this.memberId = memberId;
        this.type = type;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getBookId() {
        return bookId;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getType() {
        return type;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return String.format("ID: %s | Book ID: %s | Member ID: %s | Type: %s | Date: %s",
                id, bookId, memberId, type, date.format(formatter));
    }
}
