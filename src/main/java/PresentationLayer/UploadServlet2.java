package PresentationLayer;

import FunctionLayer.LoginSampleException;
import PresentationLayer.Log;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

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

@WebServlet(name = "UploadServlet2")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)


public class UploadServlet2 extends Command {


    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException, ClassNotFoundException, ServletException, IOException {

        AddPost addPost = new AddPost();
        String fileName = "";
        String path = "C:\\ForumFiles\\";
        List<String> extensions = Arrays.asList("jpg", "jpeg", "png", "JPG", "JPEG", "PNG");
        boolean succeded = false;
        String filePath = "";

        try {
            Part filePart = request.getPart("uploadFile");
            fileName = filePart.getSubmittedFileName();
            String[] fileNameSplits = fileName.split("\\.");
            // extension is assumed to be the last part
            int extensionIndex = fileNameSplits.length - 1;
            System.out.println(Arrays.toString(fileNameSplits));
            // add extension to id
            //File newName = new File(path + "/" + id + "." + fileNameSplits[extensionIndex]);
            String fileExtension = fileNameSplits[extensionIndex];
            if (extensions.contains(fileExtension)) {
                //for (Part part : request.getParts()) {
                    System.out.println(filePart.getName());
                    System.out.println(filePart.getSize());
                    System.out.println(filePart.getContentType());
                    UUID uuid = UUID.randomUUID();
                    filePart.write(path + uuid + "." + fileNameSplits[extensionIndex]);
                    request.setAttribute("message", "File "
                            + fileName + " was uploaded successfully!");
                    succeded = true;
                    path = path + uuid + "." + fileExtension;

               // }
            } else {
                request.setAttribute("message", "Filetype is not supported/allowed ");
            }


        } catch (Exception e) {
            request.setAttribute("message", "There was an error: ");
            System.out.println(e);
        }

        if(succeded) {
            filePath = path;
        } else {
            filePath = "NA";
        }

        request.setAttribute("filePath", filePath);
        String status = addPost.execute(request, response);

        if(status.equals("success")) {
            return "confirmation";
        } else {
            return "newPost";
        }

    }

}