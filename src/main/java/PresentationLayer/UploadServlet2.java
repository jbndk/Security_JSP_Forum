package PresentationLayer;
import FunctionLayer.LoginSampleException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet (name = "UploadServlet" )
@MultipartConfig (fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class UploadServlet2 extends HttpServlet {
    String path = "C:\\ForumFiles\\";
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException {
        try {
            System.out.println("Linje 23");
            Part filePart = request.getPart("file");
            System.out.println("Linje 25");
            String fileName = filePart.getSubmittedFileName();
            System.out.println("Linje 27");
            for (Part part : request.getParts()) {
                part.write(path + fileName);
            }
            System.out.println("Linje 31");
        } catch (Exception e) {
            System.out.println("Linje 33 - error:");
            System.out.println(e);
        }
        request.getRequestDispatcher( "confirmation" ).forward(request, response);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException {
    }
}
