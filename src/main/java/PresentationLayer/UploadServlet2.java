package PresentationLayer;

import FunctionLayer.LoginSampleException;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet(name = "UploadServlet2" )
@MultipartConfig(fileSizeThreshold = 1024 * 1024, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)


public class UploadServlet2 extends Command {

    // location to store file uploaded
    public static final String DEFAULT_FILENAME = "ForumFiles";

    // upload settings
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
    public static final String UPLOAD_DIRECTORY = "upload";
    String path = "C:\\ForumFiles\\";

    /**
     * Upon receiving file upload submission, parses the request to read
     * upload data and saves the file on disk.
     */

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException, ClassNotFoundException, ServletException, IOException {

        String fileName = "";
        String path = "C:\\ForumFiles\\";

        try {
            Part filePart = request.getPart("uploadFile");
            fileName = filePart.getSubmittedFileName();
            for (Part part : request.getParts()) {
                System.out.println(part.getName());
                System.out.println(part.getSize());
                System.out.println(part.getContentType());
                part.write(path + fileName);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        request.setAttribute("message", "There was an error: ");
        return "uploadpage";
    }

}