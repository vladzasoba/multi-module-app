package test_entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

//@Entity
@Table(name = "CUSTOMER", schema = "PUBLIC")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CUSTOMER_ID", nullable = false)
    private Integer customerId;
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;
    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;
    @Column(name = "CITY", nullable = false)
    private String city;
    @Column(name = "PHONE_NUMBER", nullable = false)
    private String phoneNumber;
    @Column(name = "COUNTRY", nullable = false)
    private String country;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    //    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "CUSTOMER_ID", nullable = false)
//    private Integer customerId;
//    @Column(name = "FIRST_NAME", nullable = false)
//    private String firstName;
//    @Column(name = "LAST_NAME", nullable = false)
//    private String lastName;
//    @Column(name = "CITY", nullable = false)
//    private String city;
//    @Column(name = "PHONE_NUMBER", nullable = false)
//    private String phonenNumber;
//    @Column(name = "COUNTRY", nullable = false)
//    private String country;
//    @OneToMany(mappedBy = "customer")
//    private List<Order> orders;
//
//    public List<Order> getOrders() {
//        return orders;
//    }
//
//    public void setOrders(List<Order> orders) {
//        this.orders = orders;
//    }
//
//    public Integer getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(Integer customerId) {
//        this.customerId = customerId;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getPhonenNumber() {
//        return phonenNumber;
//    }
//
//    public void setPhonenNumber(String phonenNumber) {
//        this.phonenNumber = phonenNumber;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Customer customer = (Customer) o;
//        return Objects.equals(firstName, customer.firstName) &&
//                Objects.equals(lastName, customer.lastName) &&
//                Objects.equals(city, customer.city) &&
//                Objects.equals(phonenNumber, customer.phonenNumber) &&
//                Objects.equals(country, customer.country);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(firstName, lastName, city, phonenNumber, country);
//    }
}
