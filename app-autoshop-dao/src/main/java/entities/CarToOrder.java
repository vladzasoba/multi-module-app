package entities;

import javax.persistence.*;

@Entity(name = "CAR_TO_ORDER")
@Table(name = "CAR_TO_ORDER")
public class CarToOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "car_to_order")
    private long carToOrderId;
    @OneToOne
    private Car car;

    public long getCarToOrderId() {
        return carToOrderId;
    }

    public void setCarToOrderId(long carToOrderId) {
        this.carToOrderId = carToOrderId;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
