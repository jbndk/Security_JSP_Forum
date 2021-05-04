package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import jdk.nashorn.internal.runtime.CodeInstaller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import FunctionLayer.VerifyRecaptcha;


public class Login extends Command {

    private CodeInstaller VerifyRecaptcha;

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
     try {
         String email = request.getParameter("email");
         String password = request.getParameter("password");
         User user = LogicFacade.login(email, password);
         // get reCAPTCHA request param
         String gRecaptchaResponse = request
                 .getParameter("g-recaptcha-response");
         System.out.println(gRecaptchaResponse);
         boolean verify = FunctionLayer.VerifyRecaptcha.verify(gRecaptchaResponse);


         HttpSession session = request.getSession();

         session.setAttribute("user", user);
         session.setAttribute("role", user.getRole());
         session.setAttribute("email", email);  // ellers skal man skrive  user.email på jsp siderne og det er sgu lidt mærkeligt at man har adgang til private felter. Men måske er det meget fedt , jeg ved det ikke
         session.setAttribute("userID", user.getUserID());

         return user.getRole() + "page";

     } catch (Exception e) {
         System.out.println("Login error: " + e);
         return "index";
     }
    }

}