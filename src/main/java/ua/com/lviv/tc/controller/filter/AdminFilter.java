package ua.com.lviv.tc.controller.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/admin/*")
public class AdminFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpRequest.getSession();
        if (session.getAttribute("role") != null) {
            boolean isAdmin = session.getAttribute("role").equals("ADMIN");
            if (isAdmin) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                httpRequest.getRequestDispatcher("/not-admin.jsp").forward(servletRequest, servletResponse);
            }
        } else {
//            ((HttpServletResponse) servletResponse).setStatus(403);
//            ((HttpServletResponse) servletResponse).sendRedirect("error");
            ((HttpServletResponse) servletResponse).sendRedirect("/login");

        }
    }

    @Override
    public void destroy() {

    }
}
