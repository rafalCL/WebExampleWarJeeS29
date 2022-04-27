package pl.coderslab.cookies.zad1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getCookie")
public class Cookie1Get extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String value = null;
        if(cookies != null) {
            for (Cookie c : cookies) {
                if ("User".equals(c.getName())) {
                    value = c.getValue();
                    break;
                }
            }
        }
        response.getWriter().println(value);
    }
}
