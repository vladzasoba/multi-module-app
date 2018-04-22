package new_entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue(value = "2")
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
