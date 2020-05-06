package ua.com.lviv.tc.entity;

import java.time.LocalDate;
import java.util.List;

public class Bucket {

    private Integer id;

    private Integer userId;

    private List<Integer> productsId;

    private LocalDate purchaseDate;

    public Bucket(Integer id, Integer userId, List<Integer> productsId, LocalDate purchaseDate) {
        this.id = id;
        this.userId = userId;
        this.productsId = productsId;
        this.purchaseDate = purchaseDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<Integer> getProductsId() {
        return productsId;
    }

    public void setProductsId(List<Integer> productsId) {
        this.productsId = productsId;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public String toString() {
        return "Bucket{" +
                "id=" + id +
                ", userId=" + userId +
                ", productId=" + productsId +
                ", purchaseDate=" + purchaseDate +
                '}';
    }
}
