package PresentationLayer;

import FunctionLayer.Item;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeleteItem extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException, ClassNotFoundException {
        HttpSession session = request.getSession();

        int counter = Integer.parseInt(request.getParameter("counter"));

        Double price = ((ArrayList<Item>) session.getAttribute("basket")).get(counter).getItemPrice();

        ((ArrayList<Item>) session.getAttribute("basket")).remove(counter);

        Double total = (Double) session.getAttribute("total");
        total = total -price;
        session.setAttribute("total", total);

        return "basket";
    }
}