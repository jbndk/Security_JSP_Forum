package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShowAllPosts extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException {

        HttpSession session = request.getSession();

        ArrayList<Post> posts = null;
        try {
            posts = LogicFacade.showAllPosts();
        } catch (LoginSampleException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        request.setAttribute("posts",posts);

        return "showAllPosts";
    }
}
