package ua.com.lviv.tc.controller.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {

    private static final Logger log = Logger.getLogger(LoginFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init login filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("filtering request");
        final HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        boolean isLoginPage = ((HttpServletRequest) servletRequest).getRequestURI().equals("/login");
        boolean isRegistrationPage = ((HttpServletRequest) servletRequest).getRequestURI().equals("/registration");
        boolean isUserLoggedIn = (session != null && session.getAttribute("email") != null);
        if (isUserLoggedIn || isLoginPage || isRegistrationPage) {
//            log.info("user is logged in");
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            servletRequest.getRequestDispatcher("/login").forward(servletRequest, servletResponse);
//            ((HttpServletResponse) servletResponse).sendRedirect("login");
        }
    }

    @Override
    public void destroy() {

    }
}
