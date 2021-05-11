package PresentationLayer;

import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import PresentationLayer.Log;


public class Logout extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();

        Log.info("The following user logged out:  "+session.getAttribute("email"));

        session.setAttribute("user", null);
        session.setAttribute("role", null);
        session.setAttribute("email", null);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Cache-Control", "private");
        response.setDateHeader("Expires", -1);
        response.setHeader("Pragma", "no-cache");

        session.invalidate();



        return "logout";
    }
}