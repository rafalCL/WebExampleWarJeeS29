package pl.coderslab.cookies.zad1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delCookie")
public class Cookie1Del extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("User", "");
        cookie.setPath("/");
        cookie.setMaxAge(0);

        response.addCookie(cookie);
        response.getWriter().println("Usunięto ciacho");
    }
}
