package letmein;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserManager userManager = (UserManager) getServletContext().getAttribute("userManager");
        
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        User user = userManager.findUserIfValid(name, password);
        if (user != null) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/letmein");
        } else {
            request.setAttribute("error", "I don't know who you are anymore!");
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }


}
