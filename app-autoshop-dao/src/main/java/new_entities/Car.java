package new_entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "1")
@Table(name = "VEHICLE", schema = "STUD_VZASOBA")
public class Car extends Vehicle {
    @Basic
    @Column(name = "DRIVE_TYPE", nullable = true, length = 20)
    private String driveType;
    @ManyToOne
    @JoinColumn(name = "TYPE_ID", referencedColumnName = "type_id")
    private Type typeByTypeId;

    public String getDriveType() {
        return driveType;
    }

    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }

    public Type getTypeByTypeId() {
        return typeByTypeId;
    }

    public void setTypeByTypeId(Type typeByTypeId) {
        this.typeByTypeId = typeByTypeId;
    }
}
