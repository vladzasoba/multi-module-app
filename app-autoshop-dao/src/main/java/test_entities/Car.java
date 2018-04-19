package test_entities;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CAR")
public class Car extends Vehicle {
    @ManyToOne
    @JoinColumn(name = "TYPE_ID", table = "TYPE")
    private Type type;
    @Column(name = "DRIVE_TYPE")
    private String driveType;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getDriveType() {
        return driveType;
    }

    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return Objects.equals(type, car.type) &&
                Objects.equals(driveType, car.driveType);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), type, driveType);
    }
}
