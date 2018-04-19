package test_entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "MOTOR_BIKE")
public class MotorBike extends Vehicle {
    @ManyToOne
    @JoinColumn(name = "BODY_TYPE_ID", table = "BODY_TYPE")
    private BodyType bodyType;

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MotorBike motorBike = (MotorBike) o;
        return Objects.equals(bodyType, motorBike.bodyType);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), bodyType);
    }


}
