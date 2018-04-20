package test_entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "ORDER", schema = "PUBLIC")
public class Order {
    @Id
    @Column(name = "ORDER_ID", nullable = false)
    private Integer orderId;
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", table = "CUSTOMER")
    private Customer customer;
    @Column(name = "ORDER_DATE", nullable = false)
    private Date orderDate;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(customer, order.customer) &&
                Objects.equals(orderDate, order.orderDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(customer, orderDate);
    }
}
