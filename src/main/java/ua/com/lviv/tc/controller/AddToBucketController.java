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

@WebServlet("/bucket/add")
public class AddToBucketController extends HttpServlet {

    private BucketService bucketService;

    public AddToBucketController() {
        this.bucketService = BucketServiceImpl.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long bucketId = (Long)req.getSession().getAttribute("bucketId");
        String requestBody = req.getReader().lines().collect(Collectors.joining());
        AddProductDTO addProductDTO = new ObjectMapper().readValue(requestBody, AddProductDTO.class);
        bucketService.addProduct(bucketId, addProductDTO.getId());
        Integer count = bucketService.getProductsCountInBucket(bucketId);
        req.getSession().setAttribute("productsInBucket", count);
    }

    private static class AddProductDTO{
        private Long id;
//        private Integer count;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }
}
