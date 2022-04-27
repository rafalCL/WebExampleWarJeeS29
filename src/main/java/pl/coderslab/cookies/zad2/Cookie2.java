package pl.coderslab.cookies.zad2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addToCookies")
public class Cookie2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key = request.getParameter("key");
        String value = request.getParameter("value");
        if (key == null || value == null
                || key.length() < 1 || value.length() < 1) {
            response.getWriter().println(String.format("Niepoprawne dane: %s, %s", key, value));
            return;
        }
        Cookie cookie = new Cookie(key, value);
        cookie.setPath("/");
        cookie.setMaxAge(24 * 60 * 60);

        response.addCookie(cookie);
        response.getWriter().println(String.format("Dodano ciasteczko: %s=%s", key, value));
    }
}
