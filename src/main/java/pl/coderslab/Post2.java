package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Post2", value = "/post2")
public class Post2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String messageText = request.getParameter("messageText");
        String isAcknowledgedStr = request.getParameter("isAcknowledged");

        if (isAcknowledgedStr == null) {
            messageText = Censor.doCensor(messageText);
        }

        response.getWriter().println(messageText);
    }
}
