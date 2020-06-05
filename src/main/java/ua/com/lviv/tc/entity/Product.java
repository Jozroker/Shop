package ua.com.lviv.tc.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Comparator;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
@NamedQueries({
        @NamedQuery(name = "updateProduct", query = "update Product p set p.count = ?1, p" +
                ".description = " +
                "?2, p.name = ?3, p.price = ?4 where p.id = ?5"),
        @NamedQuery(name = "findAllProducts", query = "select p from Product p"),
        @NamedQuery(name = "deleteProductById", query = "delete from Product p where p.id = ?1")
})
public class Product implements Comparable<Product> {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @Column(name = "name", unique = true, length = 30)
    @NotNull
    private String name;

    @Column(name = "description")
    @Lob
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
