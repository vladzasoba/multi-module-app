package entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "MODEL", schema = "PUBLIC", catalog = "DOCUMENTS")
public class ModelEntity {
    private Integer modelId;
    private String name;
    private Collection<CarEntity> carsByModelId;

    @Id
    @Column(name = "MODEL_ID", nullable = false)
    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    @Basic
    @Column(name = "NAME", nullable = true, length = 100)
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

    @OneToMany(mappedBy = "modelByModelId")
    public Collection<CarEntity> getCarsByModelId() {
        return carsByModelId;
    }

    public void setCarsByModelId(Collection<CarEntity> carsByModelId) {
        this.carsByModelId = carsByModelId;
    }
}
