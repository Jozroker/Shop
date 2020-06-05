package ua.com.lviv.tc.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bucket")
@NamedQueries({
        @NamedQuery(name = "findAllBuckets", query = "select b from Bucket b"),
        @NamedQuery(name = "deleteBucketById", query = "delete from Bucket b where b.id = ?1"),
        @NamedQuery(name = "getBucketsId", query = "select b.id from Bucket b"),
        @NamedQuery(name = "getProductsInBucket", query = "select bp from BucketProduct bp where " +
                "bp.bucket.id = ?1"),
        @NamedQuery(name = "deleteProductFromBucket", query = "delete from BucketProduct bp where" +
                " bp.bucket.id = ?1 and bp.product.id = ?2"),
        @NamedQuery(name = "getProductsCountInBucket", query = "select count(bp.product) from " +
                "BucketProduct bp where bp.bucket.id = ?1")
})
public class Bucket {

    @Id
    @Column(name = "id")
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "purchase_date")
    @NotNull
    private Instant purchaseDate;


    public Bucket(Instant purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
