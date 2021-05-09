package FunctionLayer;

import org.mindrot.jbcrypt.BCrypt;

public class User {

    private String email;
    private String password;
    private String role;

    /*
    public User(String email, String password, String role) {
        this.email = email;
        this.password = BCrypt.hashpw(password, BCrypt.gensalt(12));
        this.role = role;
    }
     */


    public User(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
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

    @Override
    public String toString() {
        return "User{" +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}