import java.io.PrintWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
public class LogIn extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException 
    {
        PrintWriter writer = response.getWriter();
        
        HttpSession session = request.getSession();
        ServletContext servletContext = getServletContext();
        String passedLogin = request.getParameter("login");
        String passedPassword = request.getParameter("password");
        User user = new User();
        user.setLogin(passedLogin);
        user.setPassword(passedPassword);

        String mainPagePath = new String("/WEB-INF/classes/main.jsp");
        String userNotFoundPagePath = new String("/WEB-INF/classes/userNotFound.jsp");
        String checkedLogin;
        String checkedPassword;
        RequestDispatcher reqDisp;
        try
        {
            if(Main.userDao.isRegistered(user)){
                reqDisp = servletContext.getRequestDispatcher(mainPagePath);
                reqDisp.forward(request, response);
            }
            reqDisp = servletContext.getRequestDispatcher(userNotFoundPagePath);
            reqDisp.forward(request, response);
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}