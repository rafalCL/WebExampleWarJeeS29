package pl.coderslab;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

// Zadanie 1
//Zadanie 1 - rozwiązywane z wykładowcą
//W projekcie stwórz servlet Get1, dostępny pod adresem /get1,
// który pobierze z adresu dwa parametry: start i end .
//Po uruchomieniu aplikacji na serwerze,
// w przeglądarce wyświetlą się wszystkie liczby od start do end.
// (dla uproszczenia załóżmy, że będziemy przesyłać tylko liczby całkowite).
// Jeżeli zmienne nie są przesłane, to strona ma wypisać informację BRAK.
//Przykładowy adres wywołania: http://localhost:8080/get1?start=1&end=12;
@WebServlet(name = "Get1", value = "/get1")
public class Get1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String startStr = request.getParameter("start");
        String endStr = request.getParameter("end");
        if(startStr == null || endStr == null) {
            response.getWriter().println("BRAK");
            return;
        }

        try {
            int start = Integer.parseInt(startStr);
            int end = Integer.parseInt(endStr);
            for(int i = start; i<=end; i++) {
                response.getWriter().println(
                        String.format("<div>%s</div>", i)
                );
            }
            return;
        } catch (NumberFormatException e) {
            response.getWriter().println(
                    String.format("Niepoprawne dane: %s %s", startStr, endStr)
            );
            return;
        }
    }
}
