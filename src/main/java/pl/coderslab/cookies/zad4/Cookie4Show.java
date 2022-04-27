package pl.coderslab.cookies.zad4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/showAllCookies")
public class Cookie4Show extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String responseText = "brak ciasteczek";
        if(cookies != null) {
            responseText = "";
            for (Cookie c : cookies) {
                responseText += String.format("<div>%s <a href='removeCookie?name=%s'>delete</a></div>", c.getName(), c.getName());
            }
        }
        response.getWriter().println(responseText);
    }
}
