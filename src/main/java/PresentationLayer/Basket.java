package PresentationLayer;

import DBAccess.CupcakeMapper;
import FunctionLayer.Item;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class Basket extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();

        if (request.getParameter("bottom") != null && request.getParameter("top") != null && request.getParameter("quantity") != null) {
            int toppingID = Integer.parseInt(request.getParameter("top"));
            int bottomID = Integer.parseInt(request.getParameter("bottom"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));

            String topping = CupcakeMapper.getToppingName(toppingID);
            Double toppingPrice = CupcakeMapper.getToppingPrice(toppingID);
            String bottom = CupcakeMapper.getBottomName(bottomID);
            Double bottomPrice = CupcakeMapper.getBottomPrice(bottomID);

            Double itemPrice;

            itemPrice = (toppingPrice + bottomPrice) * quantity;

            Item itm = new Item(topping, bottom, quantity, itemPrice);

            if ((List<Item>) session.getAttribute("basket") == null) {
                List<Item> basket = new ArrayList<>();

                session.setAttribute("basket", basket);
            }

            ((ArrayList<Item>) session.getAttribute("basket")).add(itm);

            request.setAttribute("selection", "I kurv: " + topping + " " + bottom + " Antal: " + quantity);

            Double total = 0.0;
            for (Item items : (ArrayList<Item>) session.getAttribute("basket")) {
                total += items.getItemPrice();
            }

            session.setAttribute("total", total);
        } else {
            throw new LoginSampleException("Din kurv er tom!");
        }

        return "customerpage";
    }
    }
