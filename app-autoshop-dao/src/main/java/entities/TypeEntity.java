package entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "TYPE", schema = "PUBLIC", catalog = "DOCUMENTS")
public class TypeEntity {
    @Id
    @Column(name = "TYPE_ID", nullable = false)
    private Integer typeId;
    @Basic
    @Column(name = "NAME", nullable = true, length = 100)
    private String name;
    @OneToMany(mappedBy = "typeByTypeId")
    private Collection<CarEntity> carsByTypeId;

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
        TypeEntity that = (TypeEntity) o;
        return Objects.equals(typeId, that.typeId) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(typeId, name);
    }

    public Collection<CarEntity> getCarsByTypeId() {
        return carsByTypeId;
    }

    public void setCarsByTypeId(Collection<CarEntity> carsByTypeId) {
        this.carsByTypeId = carsByTypeId;
    }
}
