package new_entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "body_type", schema = "mma", catalog = "")
public class BodyType {
    @Id
    @Column(name = "body_type_id", nullable = false)
    private Integer bodyTypeId;
    @Basic
    @Column(name = "name", nullable = true, length = 100)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BodyType bodyType = (BodyType) o;
        return Objects.equals(bodyTypeId, bodyType.bodyTypeId) &&
                Objects.equals(name, bodyType.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(bodyTypeId, name);
    }
}
