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

@WebServlet("/personal_cabinet")
public class PersonalCabinetController extends HttpServlet {

    UserServiceImpl userService = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = String.valueOf(req.getSession().getAttribute("email"));
        Optional<User> userOptional = userService.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            String firstName = user.getFirstName();
            String lastName = user.getLastName();
            req.setAttribute("fname", firstName);
            req.setAttribute("lname", lastName);
            req.setAttribute("email", email);
            req.getRequestDispatcher("cabinet.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("login");
        }

    }
}
