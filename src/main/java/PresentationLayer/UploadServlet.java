package PresentationLayer;

import FunctionLayer.LoginSampleException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UploadServlet" )
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)

public class UploadServlet extends Command {

    AddPost addPost = new AddPost();

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException, ClassNotFoundException {

        boolean succeded = false;
        String fileName = "";
        String filePath = "";
        String path = "C:\\ForumFiles\\";
        //String path = "root/upl4";

        try {
            Part filePart = request.getPart("file");
            fileName = filePart.getSubmittedFileName();
            for (Part part : request.getParts()) {
                part.write(path + fileName);
            }
            succeded = true;
        } catch (Exception e) {
            System.out.println(e);
        }

        if(succeded) {
            filePath = path + fileName;

        } else {
            filePath = "NA";
        }

        request.setAttribute("filePath", filePath);
        addPost.execute(request, response);

        return "confirmation";
    }
}