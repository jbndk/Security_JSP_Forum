package PresentationLayer;

import FunctionLayer.LogicFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Balance extends Command {


    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        int userID = Integer.parseInt(request.getParameter("userID"));
        double beloebTilIndsaettelse = Double.parseDouble(request.getParameter("beloebTilIndsaettelse"));
        LogicFacade.updateBalance(userID,beloebTilIndsaettelse);
        request.setAttribute("besked", "Kunden med id: " + userID + " har fået indsat " + beloebTilIndsaettelse
                + " på sin konto");
        return "balance";
    }
}