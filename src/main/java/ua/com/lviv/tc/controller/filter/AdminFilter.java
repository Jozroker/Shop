package ua.com.lviv.tc.controller.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/admin/*")
public class AdminFilter implements Filter {

    public static final Logger log = Logger.getLogger(AdminFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init admin filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("filtering admin request");
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpRequest.getSession();
        if (session.getAttribute("role") != null) {
            boolean isAdmin = session.getAttribute("role").equals("ADMIN");
            if (isAdmin) {
                log.info("this is admin");
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                log.info("this isn't admin");
                httpRequest.getRequestDispatcher("/not_admin.jsp").forward(servletRequest, servletResponse);
            }
        } else {
            log.info("user not logging in");
//            ((HttpServletResponse) servletResponse).setStatus(403);
//            ((HttpServletResponse) servletResponse).sendRedirect("error");
            ((HttpServletResponse) servletResponse).sendRedirect("/shop/login");

        }
    }

    @Override
    public void destroy() {

    }
}
