package ua.com.lviv.tc.controller;

import ua.com.lviv.tc.entity.User;
import ua.com.lviv.tc.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/registration")
public class RegistrationController extends HttpServlet {

    private UserServiceImpl userService = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("fname");
        String lastName = req.getParameter("lname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Optional<User> userOptional = userService.findByEmail(email);
        if (userOptional.isPresent()) {
            resp.sendRedirect("login");
        } else {
            if (firstName.equals("") || lastName.equals("") || email.equals("") || password.equals("")) {
//                resp.sendRedirect("registration");
                req.getRequestDispatcher("registration.jsp").forward(req, resp);
            } else {
                User user = new User(firstName, lastName, password, "USER", email);
                userService.save(user);
                resp.sendRedirect("login");
            }
        }

    }
}
