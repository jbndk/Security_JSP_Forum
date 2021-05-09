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

}