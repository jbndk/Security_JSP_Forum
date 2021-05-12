package FunctionLayer;

import DBAccess.ForumMapper;
import DBAccess.PostMapper;
import DBAccess.UserMapper;
import java.util.ArrayList;

public class LogicFacade {

    public static User login(String email, String password) throws LoginSampleException {
        return UserMapper.login(email, password);
    }

    public static User createMember(String email, String password) throws LoginSampleException {
        User user = new User(email, "", "member");
        user.setPassword(password);
        System.out.println("Hashed pw: " + user.getPassword());
        UserMapper.createUser(user);
        return user;
    }

    public static User createAdmin(String email, String password) throws LoginSampleException {
        User user = new User(email, "", "admin");
        user.setPassword(password);
        UserMapper.createUser(user);
        return user;
    }

    public static ArrayList<Post> showAllPosts() throws LoginSampleException, ClassNotFoundException {
        return PostMapper.showAllPosts();
    }

    public static ArrayList<Category> getCategories() throws LoginSampleException {
        return ForumMapper.getCategories();
    }

    public static ArrayList<User> showAllMembers() throws LoginSampleException {
        return UserMapper.showAllMembers();
    }

    public static boolean isValidPassword (String password){
        //Rules: minimum: one numeric, lowercase, uppercase, one of these chars: @#$%, length between 8-20

        boolean isValid = true;
        if (password.length() > 15 || password.length() < 8) {
            System.out.println("Password must be less than 20 and more than 8 characters in length.");
            isValid = false;
        }
        String upperCaseChars = "(.*[A-Z].*)";
        if (!password.matches(upperCaseChars)) {
            System.out.println("Password must have atleast one uppercase character");
            isValid = false;
        }
        if (!password.matches("^\\S*$")) {
            isValid =false;
        }
        String lowerCaseChars = "(.*[a-z].*)";
        if (!password.matches(lowerCaseChars)) {
            System.out.println("Password must have at least one lowercase character");
            isValid = false;
        }
        String numbers = "(.*[0-9].*)";
        if (!password.matches(numbers)) {
            System.out.println("Password must have atleast one number");
            isValid = false;
        }
        String specialChars = "(.*[@,#,$,%,!].*$)";
        if (!password.matches(specialChars)) {
            System.out.println("Password must have at least one special character among @#$%");
            isValid = false;
        }
        return isValid;
    }

}