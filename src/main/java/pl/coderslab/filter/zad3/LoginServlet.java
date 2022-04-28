package pl.coderslab.filter.zad3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final static String USER = "admin";
    private final static String PASSWORD = "coderslab";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        if (user.equals(USER) && pass.equals(PASSWORD)) {
            // dodaj dane do sesji pod kluczem: username
            HttpSession session = request.getSession();
            session.setAttribute("username", USER);
            // przekieruj na adres /admin
            response.sendRedirect("admin");
            return;
        } else {
            response.getWriter().println("niepoprawny login lub hasło");
        }
    }
}
