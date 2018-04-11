package entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "CUSTOMER", schema = "PUBLIC", catalog = "DOCUMENTS")
public class CustomerEntity {
    private Integer customerId;
    private String city;
    private String emailAddress;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String state;
    private Collection<OrderEntity> ordersByCustomerId;

    @Id
    @Column(name = "CUSTOMER_ID", nullable = false)
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "CITY", nullable = true, length = 50)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "EMAIL_ADDRESS", nullable = true, length = 50)
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Basic
    @Column(name = "FIRST_NAME", nullable = true, length = 100)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "LAST_NAME", nullable = true, length = 100)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "PHONE_NUMBER", nullable = true, length = 100)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "STATE", nullable = true, length = 100)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEntity that = (CustomerEntity) o;
        return Objects.equals(customerId, that.customerId) &&
                Objects.equals(city, that.city) &&
                Objects.equals(emailAddress, that.emailAddress) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {

        return Objects.hash(customerId, city, emailAddress, firstName, lastName, phoneNumber, state);
    }

    @OneToMany(mappedBy = "customerByCustomerId")
    public Collection<OrderEntity> getOrdersByCustomerId() {
        return ordersByCustomerId;
    }

    public void setOrdersByCustomerId(Collection<OrderEntity> ordersByCustomerId) {
        this.ordersByCustomerId = ordersByCustomerId;
    }
}
