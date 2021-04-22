package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Post;
import sun.reflect.annotation.ExceptionProxy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddPost extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        System.out.println("AddPost.java line 15");
        try {
            HttpSession session = request.getSession();

            String category = request.getParameter("category");
            String content = request.getParameter("content");
            String author = session.getAttribute("userID").toString();

            System.out.println("Author:" + author);

            Post p = new Post(category, content, author);

            OrderMapper.addPost(p);

            return "confirmation";

        } catch (Exception e) {
            System.out.println("Error: " + e);
            return "customerpage";
        }
    }

}
