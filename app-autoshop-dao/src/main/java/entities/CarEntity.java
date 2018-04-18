package entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "CAR")
public class CarEntity {
    @Id
    @Column(name = "CAR_ID", nullable = false)
    private Integer carId;
    @Basic
    @Column(name = "COLOR", nullable = true, length = 50)
    private String color;
    @Basic
    @Column(name = "HORSE_POWER", nullable = true)
    private Integer horsePower;
    @Basic
    @Column(name = "PRICE", nullable = true)
    private Integer price;
    @Basic
    @Column(name = "YEAR", nullable = true)
    private Integer year;
    @ManyToOne
    @JoinColumn(name = "MANUFACTURER_ID", referencedColumnName = "MANUFACTURER_ID")
    private ManufacturerEntity manufacturerByManufacturerId;
    @ManyToOne
    @JoinColumn(name = "MODEL_ID", referencedColumnName = "MODEL_ID")
    private ModelEntity modelByModelId;
    @ManyToOne
    @JoinColumn(name = "TYPE_ID", referencedColumnName = "TYPE_ID")
    private TypeEntity typeByTypeId;
    @OneToMany(mappedBy = "carByCarId")
    private Collection<CarToOrderEntity> carToOrdersByCarId;

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

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

    public ManufacturerEntity getManufacturerByManufacturerId() {
        return manufacturerByManufacturerId;
    }

    public void setManufacturerByManufacturerId(ManufacturerEntity manufacturerByManufacturerId) {
        this.manufacturerByManufacturerId = manufacturerByManufacturerId;
    }

    public ModelEntity getModelByModelId() {
        return modelByModelId;
    }

    public void setModelByModelId(ModelEntity modelByModelId) {
        this.modelByModelId = modelByModelId;
    }

    public TypeEntity getTypeByTypeId() {
        return typeByTypeId;
    }

    public void setTypeByTypeId(TypeEntity typeByTypeId) {
        this.typeByTypeId = typeByTypeId;
    }

    public Collection<CarToOrderEntity> getCarToOrdersByCarId() {
        return carToOrdersByCarId;
    }

    public void setCarToOrdersByCarId(Collection<CarToOrderEntity> carToOrdersByCarId) {
        this.carToOrdersByCarId = carToOrdersByCarId;
    }
}
