public class Member {
    private String id;
    private String name;
    private String email;
    private String role;

    public Member(String id, String name, String email, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Email: %s | Role: %s",
                id, name, email, role);
    }
}
