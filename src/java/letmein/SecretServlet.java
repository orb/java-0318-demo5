package letmein;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secret")
public class SecretServlet extends HttpServlet {
    private static boolean isLoggedIn(HttpServletRequest req) {
        return req.getSession().getAttribute("user") != null;
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (isLoggedIn(req)) {
            req.setAttribute("theSecret", "my password is password1234");
            req.getRequestDispatcher("/WEB-INF/secret.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/letmein");
        }     
    }
}
