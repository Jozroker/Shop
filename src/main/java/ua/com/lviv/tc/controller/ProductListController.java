//package ua.com.lviv.tc.controller;
//
//import ua.com.lviv.tc.entity.Product;
//import ua.com.lviv.tc.service.BucketService;
//import ua.com.lviv.tc.service.ProductService;
//import ua.com.lviv.tc.service.impl.BucketServiceImpl;
//import ua.com.lviv.tc.service.impl.ProductServiceImpl;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet("/product_list")
//public class ProductListController extends HttpServlet {
//
//    ProductService productService;
//    BucketService bucketService;
//
//    public ProductListController() {
//        this.productService = ProductServiceImpl.getInstance();
//        this.bucketService = BucketServiceImpl.getInstance();
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<Product> products = productService.findAll();
//        Integer bucketId = (Integer) req.getSession().getAttribute("bucketId");
//        Integer count = bucketService.getProductsCountInBucket(bucketId);
//        req.getSession().setAttribute("products", products);
//        req.getSession().setAttribute("productsInBucket", count);
//        req.getRequestDispatcher("/product-list.jsp").forward(req, resp);
//    }
//}
