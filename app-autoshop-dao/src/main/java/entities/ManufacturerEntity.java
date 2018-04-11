package entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "MANUFACTURER", schema = "PUBLIC", catalog = "DOCUMENTS")
public class ManufacturerEntity {
    private Integer manufacturerId;
    private String name;
    private Collection<CarEntity> carsByManufacturerId;

    @Id
    @Column(name = "MANUFACTURER_ID", nullable = false)
    public Integer getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Integer manufacturerId) {
        this.manufacturerId = manufacturerId;
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
        ManufacturerEntity that = (ManufacturerEntity) o;
        return Objects.equals(manufacturerId, that.manufacturerId) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(manufacturerId, name);
    }

    @OneToMany(mappedBy = "manufacturerByManufacturerId")
    public Collection<CarEntity> getCarsByManufacturerId() {
        return carsByManufacturerId;
    }

    public void setCarsByManufacturerId(Collection<CarEntity> carsByManufacturerId) {
        this.carsByManufacturerId = carsByManufacturerId;
    }
}
