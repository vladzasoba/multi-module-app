package entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "MODEL", schema = "stud_vzasoba")
public class ModelEntity {
    @Id
    @Column(name = "MODEL_ID", nullable = false)
    private Integer modelId;
    @Basic
    @Column(name = "NAME", nullable = true, length = 100)
    private String name;
    @OneToMany(mappedBy = "modelByModelId")
    private Collection<CarEntity> carsByModelId;

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
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
        ModelEntity that = (ModelEntity) o;
        return Objects.equals(modelId, that.modelId) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(modelId, name);
    }

    public Collection<CarEntity> getCarsByModelId() {
        return carsByModelId;
    }

    public void setCarsByModelId(Collection<CarEntity> carsByModelId) {
        this.carsByModelId = carsByModelId;
    }
}
