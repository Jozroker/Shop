package ua.com.lviv.tc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ua.com.lviv.tc.entity.Product;
import ua.com.lviv.tc.service.BucketService;
import ua.com.lviv.tc.service.impl.BucketServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet("/count")
public class CountController extends HttpServlet {

    private BucketService bucketService;

    public CountController() {
        this.bucketService = BucketServiceImpl.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestBody = req.getReader().lines().collect(Collectors.joining());
        ProductCountDTO productDTO = new ObjectMapper().readValue(requestBody, ProductCountDTO.class);
        bucketService.updateProduct(productDTO.getBucketId(), productDTO.getProductId(), productDTO.getCount());
        Map<Product, Integer> products = bucketService.getProductsInBucket(productDTO.getBucketId());
        req.getSession().setAttribute("products", products);
    }

    private static class ProductCountDTO{
        private Long bucketId;
        private Long productId;
        private Integer count;

        public Long getBucketId() {
            return bucketId;
        }

        public void setBucketId(Long bucketId) {
            this.bucketId = bucketId;
        }

        public Long getProductId() {
            return productId;
        }

        public void setProductId(Long productId) {
            this.productId = productId;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }
    }
}
