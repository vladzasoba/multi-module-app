package entities;

import javax.persistence.*;

@Entity(name = "MODEL")
@Table(name = "MODEL")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "model_id")
    private long modelId;
    @Column(name = "name")
    private String name;

    public long getModelId() {
        return modelId;
    }

    public void setModelId(long modelId) {
        this.modelId = modelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
