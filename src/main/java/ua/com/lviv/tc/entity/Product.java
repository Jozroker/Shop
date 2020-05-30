package ua.com.lviv.tc.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Comparator;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product implements Comparable<Product> {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    @NotNull
    private BigDecimal price;

    @Column(name = "count")
    private Integer count;

    public Product(String name, String description, BigDecimal price, Integer count) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.count = count;
    }

    @Override
    public int compareTo(Product p) {
        return this.name.compareTo(p.getName());
    }
}
