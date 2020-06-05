package ua.com.lviv.tc.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import ua.com.lviv.tc.service.BucketService;
import ua.com.lviv.tc.service.impl.BucketServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet("/bucket/remove")
public class RemoveFromBucketController extends HttpServlet {

    private BucketService bucketService;

    public RemoveFromBucketController() {
        this.bucketService = BucketServiceImpl.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestBody = req.getReader().lines().collect(Collectors.joining());
        RemoveProductDTO removeProductDTO = new ObjectMapper().readValue(requestBody, RemoveProductDTO.class);
        bucketService.deleteProduct(removeProductDTO.getBucketId(), removeProductDTO.getProductId());
        Integer count = bucketService.getProductsCountInBucket(removeProductDTO.getBucketId());
        req.getSession().setAttribute("productsInBucket", count);
    }

    private static class RemoveProductDTO{
        private Long bucketId;
        private Long productId;

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
    }
}
