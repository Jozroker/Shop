package ua.com.lviv.tc.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bucket_product")
public class BucketProduct {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @Column(name = "product_count")
    @NotNull
    private Integer productCount;

    @ManyToOne
    @JoinColumn(name = "bucket_id")
    private Bucket bucket;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

}