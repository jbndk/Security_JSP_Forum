package PresentationLayer;

import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.HashMap;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put("showAllCustomers", new showAllCustomers());
        commands.put( "login", new Login() );
        commands.put( "newcustomer", new NewCustomer() );
        commands.put("newemployee", new NewEmployee());
        commands.put("balance", new Balance());
        commands.put("showAllOrders", new ShowAllOrders());
        commands.put("redirect", new Redirect());
        commands.put("basket", new Basket());
        commands.put("makeOrder",new MakeOrder());
        commands.put("unknowncommand", new UnknownCommand());
        commands.put("delete", new DeleteItem());
        commands.put("logout", new Logout());
        commands.put("forum", new Forum());
        commands.put("write", new Write());
        commands.put("writeaction", new WriteAction());
        commands.put("addpost", new AddPost());
        commands.put("showAllPosts", new ShowAllPosts());
        commands.put("uploadServlet", new UploadServlet());
        commands.put("newPost", new NewPost());
        commands.put("customerpage", new CustomerPage());

    }

    static Command from( HttpServletRequest request ) {
        String TargetName = request.getParameter( "target" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(TargetName, new UnknownCommand() );   // unknowncommand er default.
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response )
            throws LoginSampleException, SQLException, ClassNotFoundException;

}