package ua.com.lviv.tc.controller;

import org.apache.log4j.Logger;
import ua.com.lviv.tc.entity.User;
import ua.com.lviv.tc.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    Logger log = Logger.getLogger(LoginController.class);

    UserServiceImpl userService = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        boolean isUserLoggedIn = (session != null && session.getAttribute("email") != null);
        if (isUserLoggedIn) {
            resp.sendRedirect("menu");
            log.info("user is logged in");
            log.info("redirect to menu page");
        } else {
            req.getRequestDispatcher("login.jsp").forward(req, resp);
            log.info("load login.jsp page");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Optional<User> userOptional = userService.findByEmail(email);
        String url = "";
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            String role = user.getRole();
            if (user.getPassword().equals(password)) {
                req.getSession().setAttribute("email", email);
                req.getSession().setAttribute("role", role);
                url = "product-list.jsp";
                resp.sendRedirect("menu");
            } else {
                log.error("user's password with email " + email + " is invalid");
                url = "login.jsp";
                resp.sendRedirect("login");
            }
        } else {
            url = "login.jsp";
            resp.sendRedirect("login");
            log.error("no user with email " + email);
        }
//        req.getRequestDispatcher(url).forward(req, resp);
    }
}
