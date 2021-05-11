
package PresentationLayer;

import DBAccess.UserMapper;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class NewUser extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException, SQLException {
        String email = request.getParameter( "email" );
        String password1 = request.getParameter( "password1" );
        String password2 = request.getParameter( "password2" );
        if ( password1.equals( password2 ) && LogicFacade.isValidPassword(password1) ) {
            User user = LogicFacade.createMember( email, password1 );
            HttpSession session = request.getSession();

            session.setAttribute("email",email);
            session.setAttribute( "user", user );
            session.setAttribute( "role", user.getRole() );
            return user.getRole() + "page";
        } else {
            request.setAttribute("message", "Der skete en fejl - tjek venligst at dit password lever op til kravene.");
            request.setAttribute("error", "Der skete en fejl.");
            throw new LoginSampleException( "De to passwords er ikke ens." );


        }
    }

}