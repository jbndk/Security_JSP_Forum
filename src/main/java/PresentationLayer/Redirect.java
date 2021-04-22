package PresentationLayer;

import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class Redirect extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException, ClassNotFoundException {

        String destination = request.getParameter("destination");

        switch (destination) {
            case "index": request.setAttribute("message", "Du er tilbage på indexsiden"); break;
            case "employeepage": request.setAttribute("message", "Du er tilbage på medarbejdersiden"); break;
            case "customerpage": request.setAttribute("message", "Du er tilbage på kundesiden"); break;
            default:request.setAttribute("message","Denne side findes ikke!");
        }

        return destination;
    }
}
