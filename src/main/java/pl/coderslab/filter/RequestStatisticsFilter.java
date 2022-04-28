package pl.coderslab.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class RequestStatisticsFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        String userAgent = ((HttpServletRequest) request).getHeader("user-agent");
        System.out.println(userAgent);
        final long start = System.currentTimeMillis();
        chain.doFilter(request, response);
        final long end = System.currentTimeMillis();
        System.out.println("Przetworzenie tego żądania zajęło " + (end-start) + "ms.");
    }
}
