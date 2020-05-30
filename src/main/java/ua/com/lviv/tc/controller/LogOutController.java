//package ua.com.lviv.tc.controller;
//
//import org.apache.log4j.Logger;
//import ua.com.lviv.tc.service.impl.UserServiceImpl;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebServlet("/logout")
//public class LogOutController extends HttpServlet {
//
//    Logger log = Logger.getLogger(LogOutController.class);
//
//    UserServiceImpl userService = UserServiceImpl.getInstance();
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
//        session.removeAttribute("email");
//        session.removeAttribute("role");
//        session.removeAttribute("name");
//        session.removeAttribute("bucketId");
//        session.removeAttribute("products");
//        resp.sendRedirect("login");
////        req.getRequestDispatcher("loginO.jsp").forward(req, resp);
//        log.info("exit from all pages to login.jsp page");
//    }
//
//}
