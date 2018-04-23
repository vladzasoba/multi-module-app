package new_entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "2")
@Table(name = "VEHICLE", schema = "STUD_VZASOBA")
public class MotorBike extends Vehicle {
    @ManyToOne
    @JoinColumn(name = "BODY_TYPE_ID", referencedColumnName = "body_type_id")
    private BodyType bodyTypeByBodyTypeId;

    public BodyType getBodyTypeByBodyTypeId() {
        return bodyTypeByBodyTypeId;
    }

    public void setBodyTypeByBodyTypeId(BodyType bodyTypeByBodyTypeId) {
        this.bodyTypeByBodyTypeId = bodyTypeByBodyTypeId;
    }
}
