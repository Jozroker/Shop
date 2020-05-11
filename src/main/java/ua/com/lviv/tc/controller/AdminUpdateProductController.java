package ua.com.lviv.tc.controller;

import org.apache.log4j.Logger;
import ua.com.lviv.tc.entity.Product;
import ua.com.lviv.tc.service.ProductService;
import ua.com.lviv.tc.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/admin/update_product")
public class AdminUpdateProductController extends HttpServlet {

    private ProductService productService;

    public AdminUpdateProductController() {
        this.productService = ProductServiceImpl.getInstance();
    }

    private static Logger log = Logger.getLogger(AdminUpdateProductController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("request to get create product page");
        req.getRequestDispatcher("create-update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("request to update product");
        String idString = req.getParameter("id");
        Integer id = 0;
        if (validateId(idString)) {
            id = Integer.parseInt(idString);
        }
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String priceString = req.getParameter("price");
        BigDecimal price = new BigDecimal(0);
        if (validatePrice(priceString)) {
            price = new BigDecimal(priceString);
        }
        Product product = new Product(id, name, description, price);
        productService.update(product);
        resp.sendRedirect("product-list");
        log.debug("product " + product + " is updated successfully");
    }

    private boolean validatePrice(String priceString) {
        try {
            Double.parseDouble(priceString);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean validateId(String idString) {
        try {
            Integer.parseInt(idString);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
