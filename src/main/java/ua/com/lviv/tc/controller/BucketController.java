//package ua.com.lviv.tc.controller;
//
//import org.apache.log4j.Logger;
//import ua.com.lviv.tc.entity.Product;
//import ua.com.lviv.tc.service.impl.BucketServiceImpl;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Map;
//
//@WebServlet("/bucket")
//public class BucketController extends HttpServlet {
//
//    Logger log = Logger.getLogger(LoginController.class);
//    BucketServiceImpl bucketService = BucketServiceImpl.getInstance();
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Integer bucketId = (Integer) req.getSession().getAttribute("bucketId");
//        Map<Product, Integer> products = bucketService.getProductsInBucket(bucketId);
//        req.getSession().setAttribute("products", products);
//        req.getRequestDispatcher("bucket.jsp").forward(req, resp);
//        log.info("load bucket.jsp page");
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
//    }
//}
