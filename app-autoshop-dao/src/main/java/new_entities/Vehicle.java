package new_entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "category_id")
@Table(name = "VEHICLE", schema = "STUD_VZASOBA")
public class Vehicle {
    @Id
    @Column(name = "vehicle_id", nullable = false)
    private Integer vehicleId;
    @Basic
    @Column(name = "COLOR", nullable = true, length = 20)
    private String color;
    @Basic
    @Column(name = "MODEL", nullable = true, length = 50)
    private String model;
    @Basic
    @Column(name = "POWER", nullable = true)
    private Integer power;
    @Basic
    @Column(name = "PRICE", nullable = true, precision = 0)
    private Double price;
    @Basic
    @Column(name = "YEAR", nullable = true)
    private Integer year;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", updatable = false, insertable = false)
    private Category categoryByCategoryId;
    @ManyToOne
    @JoinColumn(name = "manufacturer_id", referencedColumnName = "manufacturer_id")
    private Manufacturer manufacturerByManufacturerId;

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
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
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(vehicleId, vehicle.vehicleId) &&
                Objects.equals(color, vehicle.color) &&
                Objects.equals(model, vehicle.model) &&
                Objects.equals(power, vehicle.power) &&
                Objects.equals(price, vehicle.price) &&
                Objects.equals(year, vehicle.year);
    }

    @Override
    public int hashCode() {

        return Objects.hash(vehicleId, color, model, power, price, year);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", color='" + color + '\'' +
                ", model='" + model + '\'' +
                ", power=" + power +
                ", price=" + price +
                ", year=" + year +
                ", categoryByCategoryId=" + categoryByCategoryId +
                ", manufacturerByManufacturerId=" + manufacturerByManufacturerId +
                '}';
    }

    public Category getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(Category categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }

    public Manufacturer getManufacturerByManufacturerId() {
        return manufacturerByManufacturerId;
    }

    public void setManufacturerByManufacturerId(Manufacturer manufacturerByManufacturerId) {
        this.manufacturerByManufacturerId = manufacturerByManufacturerId;
    }
}
