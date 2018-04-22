package test_entities;

import sun.java2d.loops.GeneralRenderer;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

//@Entity
@Table(name = "BODY_TYPE", schema = "PUBLIC")
public class BodyType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BODY_TYPE_ID", nullable = false)
    private Integer bodyTypeId;
    @Column(name = "NAME", nullable = false)
    private String name;

    public Integer getBodyTypeId() {
        return bodyTypeId;
    }

    public void setBodyTypeId(Integer bodyTypeId) {
        this.bodyTypeId = bodyTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //    @OneToMany(mappedBy = "bodyType")
//    private List<MotorBike> motorBikes;
//
//    public List<MotorBike> getMotorBikes() {
//        return motorBikes;
//    }
//
//    public void setMotorBikes(List<MotorBike> motorBikes) {
//        this.motorBikes = motorBikes;
//    }
//
//    public Integer getBodyTypeId() {
//        return bodyTypeId;
//    }
//
//    public void setBodyTypeId(Integer bodyTypeId) {
//        this.bodyTypeId = bodyTypeId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        BodyType bodyType = (BodyType) o;
//        return Objects.equals(name, bodyType.name);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(name);
//    }
}
