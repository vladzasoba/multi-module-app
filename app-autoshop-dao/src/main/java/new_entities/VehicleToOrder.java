package new_entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "vehicle_to_order", schema = "mma", catalog = "")
public class VehicleToOrder {
    @Id
    @Column(name = "vehicle_to_order_id", nullable = false)
    private Integer vehicleToOrderId;
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    private Order orderByOrderId;
    @ManyToOne
    @JoinColumn(name = "vehicle_id", referencedColumnName = "vehicle_id")
    private Vehicle vehicleByVehicleId;

    public Integer getVehicleToOrderId() {
        return vehicleToOrderId;
    }

    public void setVehicleToOrderId(Integer vehicleToOrderId) {
        this.vehicleToOrderId = vehicleToOrderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleToOrder that = (VehicleToOrder) o;
        return Objects.equals(vehicleToOrderId, that.vehicleToOrderId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(vehicleToOrderId);
    }

    public Order getOrderByOrderId() {
        return orderByOrderId;
    }

    public void setOrderByOrderId(Order orderByOrderId) {
        this.orderByOrderId = orderByOrderId;
    }

    public Vehicle getVehicleByVehicleId() {
        return vehicleByVehicleId;
    }

    public void setVehicleByVehicleId(Vehicle vehicleByVehicleId) {
        this.vehicleByVehicleId = vehicleByVehicleId;
    }
}
