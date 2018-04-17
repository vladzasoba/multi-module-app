package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CAR_TO_ORDER", schema = "stud_vzasoba")
public class CarToOrderEntity {
    @Id
    @Column(name = "CAR_TO_ORDER_ID", nullable = false)
    private Integer carToOrderId;
    @ManyToOne
    @JoinColumn(name = "CAR_ID", referencedColumnName = "CAR_ID")
    private CarEntity carByCarId;

    public Integer getCarToOrderId() {
        return carToOrderId;
    }

    public void setCarToOrderId(Integer carToOrderId) {
        this.carToOrderId = carToOrderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarToOrderEntity that = (CarToOrderEntity) o;
        return Objects.equals(carToOrderId, that.carToOrderId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(carToOrderId);
    }

    public CarEntity getCarByCarId() {
        return carByCarId;
    }

    public void setCarByCarId(CarEntity carByCarId) {
        this.carByCarId = carByCarId;
    }
}
