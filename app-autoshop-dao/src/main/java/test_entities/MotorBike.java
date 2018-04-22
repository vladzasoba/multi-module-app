package test_entities;

import javax.persistence.*;
import java.util.Objects;

//@Entity
//@DiscriminatorValue(value = "2")
@Table(name = "MOTOR_BIKE", schema = "PUBLIC")
//@SecondaryTable(name = "BODY_TYPE")
public class MotorBike extends Vehicle {
    @ManyToOne
    @JoinColumn(name = "BODY_TYPE_ID", referencedColumnName = "BODY_TYPE_ID")
    private BodyType bodyType;

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }
//    @OneToOne
//    @JoinColumn(name = "VEHICLE_ID", referencedColumnName = "VEHICLE_ID")
//    private Vehicle vehicle;
//
//    public Vehicle getVehicle() {
//        return vehicle;
//    }
//
//    public void setVehicle(Vehicle vehicle) {
//        this.vehicle = vehicle;
//    }
//
//    public BodyType getBodyType() {
//        return bodyType;
//    }
//
//    public void setBodyType(BodyType bodyType) {
//        this.bodyType = bodyType;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
//        MotorBike motorBike = (MotorBike) o;
//        return Objects.equals(bodyType, motorBike.bodyType);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(super.hashCode(), bodyType);
//    }
//

}
