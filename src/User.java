public class User {
    private String username;
    private String status;

    public User(String username) {
        this.username = username;
        this.status = "offline";
    }

    // Getters and setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}