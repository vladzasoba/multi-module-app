package entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "CAR", schema = "PUBLIC")
public class CarEntity {
    private Integer carId;
    private String color;
    private Integer horsePower;
    private Integer price;
    private Integer year;
    private ManufacturerEntity manufacturerByManufacturerId;
    private ModelEntity modelByModelId;
    private TypeEntity typeByTypeId;
    private Collection<CarToOrderEntity> carToOrdersByCarId;

    @Id
    @Column(name = "CAR_ID", nullable = false)
    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    @Basic
    @Column(name = "COLOR", nullable = true, length = 50)
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Basic
    @Column(name = "HORSE_POWER", nullable = true)
    public Integer getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }

    @Basic
    @Column(name = "PRICE", nullable = true)
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @Column(name = "YEAR", nullable = true)
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarEntity carEntity = (CarEntity) o;
        return Objects.equals(carId, carEntity.carId) &&
                Objects.equals(color, carEntity.color) &&
                Objects.equals(horsePower, carEntity.horsePower) &&
                Objects.equals(price, carEntity.price) &&
                Objects.equals(year, carEntity.year);
    }

    @Override
    public int hashCode() {

        return Objects.hash(carId, color, horsePower, price, year);
    }

    @ManyToOne
    @JoinColumn(name = "MANUFACTURER_ID", referencedColumnName = "MANUFACTURER_ID")
    public ManufacturerEntity getManufacturerByManufacturerId() {
        return manufacturerByManufacturerId;
    }

    public void setManufacturerByManufacturerId(ManufacturerEntity manufacturerByManufacturerId) {
        this.manufacturerByManufacturerId = manufacturerByManufacturerId;
    }

    @ManyToOne
    @JoinColumn(name = "MODEL_ID", referencedColumnName = "MODEL_ID")
    public ModelEntity getModelByModelId() {
        return modelByModelId;
    }

    public void setModelByModelId(ModelEntity modelByModelId) {
        this.modelByModelId = modelByModelId;
    }

    @ManyToOne
    @JoinColumn(name = "TYPE_ID", referencedColumnName = "TYPE_ID")
    public TypeEntity getTypeByTypeId() {
        return typeByTypeId;
    }

    public void setTypeByTypeId(TypeEntity typeByTypeId) {
        this.typeByTypeId = typeByTypeId;
    }

    @OneToMany(mappedBy = "carByCarId")
    public Collection<CarToOrderEntity> getCarToOrdersByCarId() {
        return carToOrdersByCarId;
    }

    public void setCarToOrdersByCarId(Collection<CarToOrderEntity> carToOrdersByCarId) {
        this.carToOrdersByCarId = carToOrdersByCarId;
    }
}
