package new_entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Type {
    @Id
    @Column(name = "type_id", nullable = false)
    private Integer typeId;
    @Basic
    @Column(name = "name", nullable = true, length = 100)
    private String name;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
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
        Type type = (Type) o;
        return Objects.equals(typeId, type.typeId) &&
                Objects.equals(name, type.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(typeId, name);
    }
}
