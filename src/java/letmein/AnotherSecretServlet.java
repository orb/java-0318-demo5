package letmein;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secret2")
public class AnotherSecretServlet extends HttpServlet {

    private static boolean isLoggedIn(HttpServletRequest req) {
        return req.getSession().getAttribute("user") != null;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (isLoggedIn(req)) {
            req.setAttribute("theSecret", "Snape killed dumbledore");
            req.getRequestDispatcher("/WEB-INF/secret2.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/letmein");
        }
    }
}
