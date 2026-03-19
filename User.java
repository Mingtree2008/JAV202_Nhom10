package entity;

public class User {
    private int userId;
    private String userName;
    private String password;
    private boolean status;
    private String email;
    private String role;

    // Constructor mặc định
    public User() {
    }

    // Constructor đầy đủ
    public User(int userId, String userName, String password, boolean status, String email, String role) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.status = status;
        this.email = email;
        this.role = role;
    }

    // Constructor không có ID (dùng khi INSERT)
    public User(String userName, String password, boolean status, String email, String role) {
        this.userName = userName;
        this.password = password;
        this.status = status;
        this.email = email;
        this.role = role;
    }

    // Getter & Setter
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", status=" + status +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
