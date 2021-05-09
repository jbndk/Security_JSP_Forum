package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShowAllMembers extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException {

        HttpSession session = request.getSession();

        ArrayList<User> memberList = null;
        try {
            memberList = LogicFacade.showAllMembers();
        } catch (LoginSampleException e) {
            e.printStackTrace();
        }

        request.setAttribute("memberList",memberList);

        return "showAllMembers";
    }
}
