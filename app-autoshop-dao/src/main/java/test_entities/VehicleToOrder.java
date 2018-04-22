package test_entities;

import javax.persistence.*;
import java.util.Objects;

//@Entity
@Table(name = "VEHICLE_TO_ORDER", schema = "PUBLIC")
//@SecondaryTables({
//        @SecondaryTable(name = "ORDERS"),
//        @SecondaryTable(name = "VEHICLE")
//})
public class VehicleToOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VEHICLE_TO_ORDER_ID", nullable = false)
    private Integer vehicleToOrderId;
    @ManyToOne
    @JoinColumn(name = "VEHICLE_ID", referencedColumnName = "VEHICLE_ID")
    private Vehicle vehicle;
    @OneToOne
    @JoinColumn(name = "ORDER_ID", table = "ORDERS")
    private Order order;

    public Integer getVehicleToOrderId() {
        return vehicleToOrderId;
    }

    public void setVehicleToOrderId(Integer vehicleToOrderId) {
        this.vehicleToOrderId = vehicleToOrderId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    //
//
//
//    public Integer getVehicleToOrderId() {
//        return vehicleToOrderId;
//    }
//
//    public void setVehicleToOrderId(Integer vehicleToOrderId) {
//        this.vehicleToOrderId = vehicleToOrderId;
//    }
//
//    public Vehicle getVehicle() {
//        return vehicle;
//    }
//
//    public void setVehicle(Vehicle vehicle) {
//        this.vehicle = vehicle;
//    }
//
//    public Order getOrder() {
//        return order;
//    }
//
//    public void setOrder(Order order) {
//        this.order = order;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        VehicleToOrder that = (VehicleToOrder) o;
//        return Objects.equals(vehicle, that.vehicle) &&
//                Objects.equals(order, that.order);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(vehicle, order);
//    }
}
