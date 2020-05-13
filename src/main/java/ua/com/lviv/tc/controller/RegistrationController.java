package ua.com.lviv.tc.controller;

import org.apache.log4j.Logger;
import ua.com.lviv.tc.entity.Bucket;
import ua.com.lviv.tc.entity.User;
import ua.com.lviv.tc.repositories.BucketRepository;
import ua.com.lviv.tc.repositories.impl.BucketRepositoryImpl;
import ua.com.lviv.tc.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

@WebServlet("/registration")
public class RegistrationController extends HttpServlet {

    private Logger log = Logger.getLogger(RegistrationController.class);
    private UserServiceImpl userService = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("registration.jsp").forward(req, resp);
        log.info("load registration.jsp page");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("fname");
        String lastName = req.getParameter("lname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Optional<User> userOptional = userService.findByEmail(email);
        if (userOptional.isPresent()) {
            log.error("user with email " + email + " is already exist");
            resp.sendRedirect("login");
        } else {
            if (firstName.equals("") || lastName.equals("") || email.equals("") || password.equals("")) {
//                resp.sendRedirect("registration");
                req.getRequestDispatcher("registration.jsp").forward(req, resp);
                log.debug("empty registration form");
                log.debug("user not saved");
            } else {
                User user = new User(firstName, lastName, password, "USER", email);
                userService.save(user);
                log.debug("save user " + user);
                resp.sendRedirect("login");
            }
        }

    }
}
