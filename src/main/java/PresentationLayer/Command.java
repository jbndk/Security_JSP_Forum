package PresentationLayer;

import FunctionLayer.LoginSampleException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put("showAllMembers", new ShowAllMembers());
        commands.put("login", new Login() );
        commands.put("newuser", new NewUser() );
        commands.put("unknowncommand", new UnknownCommand());
        commands.put("logout", new Logout());
        commands.put("addpost", new AddPost());
        commands.put("showAllPosts", new ShowAllPosts());
        commands.put("uploadServlet", new UploadServlet());
        commands.put("newPost", new NewPost());
        commands.put("memberpage", new MemberPage());
        commands.put("uploadServlet2", new UploadServlet2());

    }

    static Command from( HttpServletRequest request ) {
        String TargetName = request.getParameter( "target" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(TargetName, new UnknownCommand() );   // unknowncommand er default.
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response )
            throws LoginSampleException, SQLException, ClassNotFoundException, ServletException, IOException;

}