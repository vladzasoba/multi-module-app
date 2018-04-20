package test_entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "VEHICLE", schema = "PUBLIC")
public abstract class Vehicle {
    @Id
    @Column(name = "VEHICLE_ID", nullable = false)
    private Integer vehicleId;
    @ManyToOne
    @JoinColumn(name = "MANUFACTURER_ID", table = "MANUFACTURER")
    private Manufacturer manufacturer;
    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID", table = "CATEGORY")
    private Category category;
    @Column(name = "MODEL", nullable = false)
    private String model;
    @Column(name = "PRICE", nullable = false)
    private Double price;
    @Column(name = "YEAR", nullable = false)
    private Integer year;
    @Column(name = "COLOR", nullable = false)
    private String color;
    @Column(name = "POWER", nullable = false)
    private Integer power;
    @OneToOne(mappedBy = "VEHICLE")
    private List<VehicleToOrder> vehicleToOrders;

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(manufacturer, vehicle.manufacturer) &&
                Objects.equals(category, vehicle.category) &&
                Objects.equals(model, vehicle.model) &&
                Objects.equals(price, vehicle.price) &&
                Objects.equals(year, vehicle.year) &&
                Objects.equals(color, vehicle.color) &&
                Objects.equals(power, vehicle.power);
    }

    @Override
    public int hashCode() {

        return Objects.hash(manufacturer, category, model, price, year, color, power);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", manufacturer=" + manufacturer +
                ", category=" + category +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", power=" + power +
                '}';
    }
}
