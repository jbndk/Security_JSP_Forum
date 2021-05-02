package FunctionLayer;

import org.mindrot.jbcrypt.BCrypt;

public class User {

    private int userID;
    private String email;
    private String password;
    private String role;
    private double balance;

    public User( int userID, String email, String password, String role, double balance ) {
        this.userID = userID;
        this.email = email;
        this.password = BCrypt.hashpw(password, BCrypt.gensalt(12));
        this.role = role;
        this.balance = balance;
    }

    public User(String email, String password, String role, double balance) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.balance = balance;
    }

    public User(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public int getUserID() {

        return userID;
    }

    public void setUserID(int userID) {

        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean verifyPassword(String pw) {
        System.out.println("Verify Password");
        System.out.println("PW: " + pw);
        System.out.println("this.password: " + this.password);
        return (BCrypt.checkpw(this.password, pw));
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + userID +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", balance=" + balance +
                '}';
    }
}