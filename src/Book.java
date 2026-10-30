public class Book {
    private String id;
    private String title;
    private String author;
    private String category;
    private String status;

    public Book(String id, String title, String author, String category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.status = "Available";
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isAvailable() {
        return status.equals("Available");
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Title: %s | Author: %s | Category: %s | Status: %s",
                id, title, author, category, status);
    }
}
