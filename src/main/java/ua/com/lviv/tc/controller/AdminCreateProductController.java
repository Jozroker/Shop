//package ua.com.lviv.tc.controller;
//
//import org.apache.log4j.Logger;
//import ua.com.lviv.tc.entity.Product;
//import ua.com.lviv.tc.service.ProductService;
//import ua.com.lviv.tc.service.impl.ProductServiceImpl;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.math.BigDecimal;
//
//@WebServlet("/admin/create_products")
//public class AdminCreateProductController extends HttpServlet {
//
//    private ProductService productService;
//
//    public AdminCreateProductController() {
//        this.productService = ProductServiceImpl.getInstance();
//    }
//
//    private static Logger log = Logger.getLogger(AdminCreateProductController.class);
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        log.debug("request to get create product page");
//        req.getRequestDispatcher("/create-product.jsp").forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        log.debug("request to add new product");
//        String name = req.getParameter("name");
//        String description = req.getParameter("description");
//        String priceString = req.getParameter("price");
//        String countString = req.getParameter("count");
//        if (name.equals("") || description.equals("") || priceString.equals("")) {
//            resp.sendRedirect("create_products");
//            log.error("fields of create product is empty");
//        } else {
//            if (validatePrice(priceString) && validateCount(countString)) {
//                Integer count = Integer.parseInt(countString);
//                BigDecimal price = new BigDecimal(priceString);
//                Product product = new Product(name, description, price, count);
//                productService.save(product);
//                resp.sendRedirect("/product_list");
//                log.debug("product " + product + " is added successfully");
//            } else {
//                resp.sendRedirect("create_products");
//                log.error("incorrect price value");
//            }
//        }
//
//    }
//
//    private boolean validatePrice(String priceString) {
//        try {
//            Double.parseDouble(priceString);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    private boolean validateCount(String countString) {
//        try {
//            Integer.parseInt(countString);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//}
