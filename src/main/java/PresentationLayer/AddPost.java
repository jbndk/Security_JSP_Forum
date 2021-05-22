package PresentationLayer;

import DBAccess.PostMapper;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Post;
import sun.java2d.pipe.hw.ExtendedBufferCapabilities;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AddPost extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        System.out.println("AddPost()");
        try {
            HttpSession session = request.getSession();

            String category = request.getParameter("category");
            String content = request.getParameter("content");
            String author = session.getAttribute("email").toString();
            String filePath = "";

            filePath = request.getAttribute("filePath").toString();
            //System.out.println(filePath);

            //System.out.println("Author:" + author);

            Post p = new Post(category, content, author, filePath);
            Log.info("File: " + filePath + " was uploaded by user: "+ session.getAttribute("email").toString());

            PostMapper.addPost(p);

            return "success";

        } catch (Exception e) {
            System.out.println("Error: " + e);
            return "customerpage";
        }
    }

}
