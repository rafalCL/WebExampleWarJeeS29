package pl.coderslab.cookies.zad4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/removeCookie")
public class Cookie4Del extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cookieToDeleteName = request.getParameter("name");
        if(cookieToDeleteName == null) {
            response.getWriter().println("Nie podano nazwy ciasteczka");
            return;
        }
        Cookie cookie = new Cookie(cookieToDeleteName, "");
        cookie.setPath("/");
        cookie.setMaxAge(0);

        response.addCookie(cookie);
        response.getWriter().println("Usunięto ciacho");
    }
}
