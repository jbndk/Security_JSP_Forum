package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;

public class showAllCustomers extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException {

        HttpSession session = request.getSession();

        ArrayList<User> customerList = null;
        try {
            customerList = LogicFacade.showAllCustomers();
        } catch (LoginSampleException e) {
            e.printStackTrace();
        }

        request.setAttribute("customerList",customerList);

        return "showAllCustomers";
    }
}
