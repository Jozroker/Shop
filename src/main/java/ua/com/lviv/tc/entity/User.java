package ua.com.lviv.tc.entity;

public class User {

    private Integer id;

    private String firstName;

    private String lastName;

    private String password;

    private String role;

    private String email;

    private Integer bucketId;

    public User(Integer id, String firstName, String lastName, String password, String role, String email, Integer bucketId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.role = role;
        this.email = email;
        this.bucketId = bucketId;
    }

    public User(String firstName, String lastName, String password, String role, String email, Integer bucketId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.role = role;
        this.email = email;
        this.bucketId = bucketId;
    }

    public User(String firstName, String lastName, String password, String role, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.role = role;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getBucketId() {
        return bucketId;
    }

    public void setBucketId(Integer bucketId) {
        this.bucketId = bucketId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", email='" + email + '\'' +
                ", bucketId='" + bucketId + '\'' +
                '}';
    }
}
