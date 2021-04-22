package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShowAllOrders extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException {
        HttpSession session = request.getSession();

        ArrayList<Order> orderList = null;

        //orderList = OrderMapper.showAllOrders();

        try {
            orderList = LogicFacade.showAllOrders();
        } catch (LoginSampleException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        request.setAttribute("orderList", orderList);

        return "showAllOrders";
    }
}
