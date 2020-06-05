package ua.com.lviv.tc.controller;

import ua.com.lviv.tc.entity.Product;
import ua.com.lviv.tc.service.impl.BucketServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/bucket")
public class BucketController extends HttpServlet {

    BucketServiceImpl bucketService = BucketServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long bucketId = (Long) req.getSession().getAttribute("bucketId");
        Map<Product, Integer> products = bucketService.getProductsInBucket(bucketId);
        req.getSession().setAttribute("products", products);
        req.getRequestDispatcher("bucket.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
