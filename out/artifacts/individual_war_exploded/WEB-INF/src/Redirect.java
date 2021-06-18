import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class Redirect extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException
    {

        ServletContext servletContext = getServletContext();
        String nullComp = null;
        String validateLogInFieldsPath = new String("/validateLogInFields");
        String registrationPagePath = new String("/WEB-INF/html/registration.html");
        RequestDispatcher reqDisp;
        if(!(nullComp == request.getParameter("LogInButton")))
        {
            reqDisp = servletContext.getRequestDispatcher(validateLogInFieldsPath);
            reqDisp.forward(request, response);
        }
        else if(!(nullComp == request.getParameter("RegisterButton")))
        {
            reqDisp = servletContext.getRequestDispatcher(registrationPagePath);
            reqDisp.forward(request, response);
        }
    }
}