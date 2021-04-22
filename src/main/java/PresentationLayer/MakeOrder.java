package PresentationLayer;

import DBAccess.CupcakeMapper;
import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import FunctionLayer.Item;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;

public class MakeOrder extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException, ClassNotFoundException {
        HttpSession session = request.getSession();

        int brugerID = Integer.parseInt(request.getParameter("userID"));
        //Double total = 0.0;

        Double total = (Double) session.getAttribute("total");
        Double saldo = UserMapper.getBalance(brugerID);

        if (saldo > total) {
            UserMapper.payOrder(total, brugerID);


            Order order = new Order(brugerID, total);

            OrderMapper.createOrder(order);

            //OrderMapper.insertItems(1, 1, 1, 6);

            int thisOrderID = OrderMapper.lastOrderID();


            for (Item i : (ArrayList<Item>) session.getAttribute("basket")) {

                int toppingID = CupcakeMapper.getToppingID(i.getTopping());
                int bottomID = CupcakeMapper.getBottomID(i.getBottom());
                int quantity = i.getQuantity();


                OrderMapper.insertItems(thisOrderID, toppingID, bottomID, quantity);
            }



            
            ((ArrayList<Item>) session.getAttribute("basket")).clear();

            return "confirmation";
        } else {
            return "balancetoolow";
        }
    }
}
