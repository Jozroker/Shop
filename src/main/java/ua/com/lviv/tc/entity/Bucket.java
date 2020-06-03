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
