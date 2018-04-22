package test_entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

//@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "CATEGORY_ID")
@Table(name = "VEHICLE", schema = "PUBLIC")
//@SecondaryTables({
////        @SecondaryTable(name = "CATEGORY", pkJoinColumns = { @PrimaryKeyJoinColumn(name = "CATEGORY_ID") }),
//        @SecondaryTable(name = "MANUFACTURER", pkJoinColumns = { @PrimaryKeyJoinColumn(name = "MANUFACTURER_ID") })
////        @SecondaryTable(name = "MOTOR_BIKE"),
////        @SecondaryTable(name = "CAR")
//})
public abstract class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VEHICLE_ID", nullable = false, updatable = false)
    private Integer vehicleId;
    @ManyToOne
    @JoinColumn(name = "MANUFACTURER_ID", table = "MANUFACTURER", insertable = false, updatable = false)
    private Manufacturer manufacturer;
    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "CATEGORY_ID")
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

    //    @OneToOne(mappedBy = "vehicle")
//    private MotorBike motorBike;
//    @OneToOne(mappedBy = "vehicle")
//    private Car car;
//    @OneToMany(mappedBy = "vehicle")
//    private List<VehicleToOrder> vehicleToOrders;
//
//    public MotorBike getMotorBike() {
//        return motorBike;
//    }
//
//    public void setMotorBike(MotorBike motorBike) {
//        this.motorBike = motorBike;
//    }
//
//    public Car getCar() {
//        return car;
//    }
//
//    public void setCar(Car car) {
//        this.car = car;
//    }
//
//    public List<VehicleToOrder> getVehicleToOrders() {
//        return vehicleToOrders;
//    }
//
//    public void setVehicleToOrders(List<VehicleToOrder> vehicleToOrders) {
//        this.vehicleToOrders = vehicleToOrders;
//    }
//
//    public Integer getVehicleId() {
//        return vehicleId;
//    }
//
//    public void setVehicleId(Integer vehicleId) {
//        this.vehicleId = vehicleId;
//    }
//
//    public Manufacturer getManufacturer() {
//        return manufacturer;
//    }
//
//    public void setManufacturer(Manufacturer manufacturer) {
//        this.manufacturer = manufacturer;
//    }
//
//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }
//
//    public String getModel() {
//        return model;
//    }
//
//    public void setModel(String model) {
//        this.model = model;
//    }
//
//    public Double getPrice() {
//        return price;
//    }
//
//    public void setPrice(Double price) {
//        this.price = price;
//    }
//
//    public Integer getYear() {
//        return year;
//    }
//
//    public void setYear(Integer year) {
//        this.year = year;
//    }
//
//    public String getColor() {
//        return color;
//    }
//
//    public void setColor(String color) {
//        this.color = color;
//    }
//
//    public Integer getPower() {
//        return power;
//    }
//
//    public void setPower(Integer power) {
//        this.power = power;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Vehicle vehicle = (Vehicle) o;
//        return Objects.equals(manufacturer, vehicle.manufacturer) &&
//                Objects.equals(category, vehicle.category) &&
//                Objects.equals(model, vehicle.model) &&
//                Objects.equals(price, vehicle.price) &&
//                Objects.equals(year, vehicle.year) &&
//                Objects.equals(color, vehicle.color) &&
//                Objects.equals(power, vehicle.power);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(manufacturer, category, model, price, year, color, power);
//    }
//
//    @Override
//    public String toString() {
//        return "Vehicle{" +
//                "vehicleId=" + vehicleId +
//                ", manufacturer=" + manufacturer +
//                ", category=" + category +
//                ", model='" + model + '\'' +
//                ", price=" + price +
//                ", year=" + year +
//                ", color='" + color + '\'' +
//                ", power=" + power +
//                '}';
//    }
}
