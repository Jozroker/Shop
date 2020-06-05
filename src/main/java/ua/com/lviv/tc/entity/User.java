package ua.com.lviv.tc.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
@NamedQueries({
        @NamedQuery(name = "findAllUsers", query = "select u from User u"),
        @NamedQuery(name = "findUserByEmail", query = "select u from User u where u.email = ?1"),
        @NamedQuery(name = "deleteUserById", query = "delete from User u where u.id = ?1")
})
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @Column(name = "fname")
    @NotNull
    private String firstName;

    @Column(name = "lname")
    @NotNull
    private String lastName;

    @Column(name = "password")
    @NotNull
    private String password;

    @Column(name = "role")
    @NotNull
    private String role;

    @Column(name = "email", unique = true, length = 30)
    @NotNull
    private String email;

//    @Column(name = "bucket_id", nullable = false)
//    @NotNull
//    private Integer bucketId;

    @OneToOne(cascade = CascadeType.REMOVE)
//    @OneToOne
    @JoinColumn(name = "bucket_id")
    private Bucket bucket;

//    public void setBucket(Bucket bucket) {
//        this.bucket = bucket;
//        bucket.setUser(this);
//    }

    public User(String firstName, String lastName, String password, String role, String email, Bucket bucket) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.role = role;
        this.email = email;
        this.bucket = bucket;
    }

    public User(String firstName, String lastName, String password, String role, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.role = role;
        this.email = email;
    }
}
