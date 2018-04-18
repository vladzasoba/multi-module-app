package entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "CAR_CUSTOMER")
public class CustomerEntity {
    @Id
    @Column(name = "CUSTOMER_ID", nullable = false)
    private Integer customerId;
    @Basic
    @Column(name = "CITY", nullable = true, length = 50)
    private String city;
    @Basic
    @Column(name = "EMAIL_ADDRESS", nullable = true, length = 50)
    private String emailAddress;
    @Basic
    @Column(name = "FIRST_NAME", nullable = true, length = 100)
    private String firstName;
    @Basic
    @Column(name = "LAST_NAME", nullable = true, length = 100)
    private String lastName;
    @Basic
    @Column(name = "PHONE_NUMBER", nullable = true, length = 100)
    private String phoneNumber;
    @Basic
    @Column(name = "STATE", nullable = true, length = 100)
    private String state;
    @OneToMany(mappedBy = "customerByCustomerId")
    private Collection<OrderEntity> ordersByCustomerId;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

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

    public Collection<OrderEntity> getOrdersByCustomerId() {
        return ordersByCustomerId;
    }

    public void setOrdersByCustomerId(Collection<OrderEntity> ordersByCustomerId) {
        this.ordersByCustomerId = ordersByCustomerId;
    }
}
