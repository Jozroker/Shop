package ua.com.lviv.tc.entity;

import java.time.LocalDateTime;

public class Bucket {

    private Integer id;

    private LocalDateTime purchaseDate;

    public Bucket(Integer id, LocalDateTime purchaseDate) {
        this.id = id;
        this.purchaseDate = purchaseDate;
    }

    public Bucket(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public String toString() {
        return "Bucket{" +
                "id=" + id +
                ", purchaseDate=" + purchaseDate +
                '}';
    }
}
