package ua.com.lviv.tc.controller;

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
import java.util.Optional;

@WebServlet("/admin/update_product")
public class AdminUpdateProductController extends HttpServlet {

    private ProductService productService;

    public AdminUpdateProductController() {
        this.productService = ProductServiceImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/update-product.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idString = req.getParameter("id");
        Long id = 0L;
        if (validateId(idString)) {
            id = Long.parseLong(idString);
        }
        Optional<Product> oldProductOptional = productService.findById(id);
        if (oldProductOptional.isPresent()) {
            Product oldProduct = oldProductOptional.get();
            String name = req.getParameter("name");
            String description = req.getParameter("description");
            String priceString = req.getParameter("price");
            String countString = req.getParameter("count");
            BigDecimal price = new BigDecimal(0);
            Integer count = 0;
            if (validatePrice(priceString) && validateCount(countString)) {
                price = new BigDecimal(priceString);
                count = Integer.parseInt(countString);
            }
            if (name.equals("")) {
                name = oldProduct.getName();
            }
            if (description.equals("")) {
                description = oldProduct.getDescription();
            }
            if (priceString.equals("")) {
                price = oldProduct.getPrice();
            }
            if (countString.equals("")) {
                count = oldProduct.getCount();
            }
            Product product = new Product(id, name, description, price, count);
            productService.update(product);
            resp.sendRedirect("/product_list");
        } else {
            resp.sendRedirect("/update_product");
        }

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

    private boolean validateCount(String countString) {
        try {
            Integer.parseInt(countString);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
