package pl.coderslab.session.zad1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/session1Get")
public class Session1Get extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer counter = (Integer)session.getAttribute("counter");

        if (counter == null) {
            response.getWriter().println("empty");
            return;
        }

        counter += 1;

        session.setAttribute("counter", counter);

        response.getWriter().println("counter="+counter);
    }
}
