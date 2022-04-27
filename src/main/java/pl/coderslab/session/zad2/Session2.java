package pl.coderslab.session.zad2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/session2")
public class Session2 extends HttpServlet {
    private static final String FORM_HTML = "    <form method=\"post\">\n" +
            "        <div>\n" +
            "            <label for=\"grade\">Ocena</label>\n" +
            "            <input id=\"grade\" name=\"grade\" type=\"number\"/>\n" +
            "        </div>\n" +
            "        <div>\n" +
            "            <input type=\"submit\"/>\n" +
            "        </div>\n" +
            "    </form>" +
            "" +
            "<div>Grades: %s</div>" +
            "<div>avg=%s</div>";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println(String.format(FORM_HTML, "[]", "n/a"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Integer> grades = (List<Integer>)session.getAttribute("grades");

        if (grades==null) {
            grades = new ArrayList<>();
        }

        String gradeStr = request.getParameter("grade");
        try {
            grades.add(Integer.parseInt(gradeStr));
            session.setAttribute("grades", grades);
        } catch (NumberFormatException e) {
            System.out.println("nieprawidlowe dane");
        }
        Double avg = null;

        if (grades.size() > 0) {
            double sum = 0;
            for (int grd : grades) {
                sum += grd;
            }
            avg = sum/grades.size();
        }

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println(String.format(FORM_HTML,
                grades.toString(),
                avg == null ? "n/a" : avg));

    }
}
