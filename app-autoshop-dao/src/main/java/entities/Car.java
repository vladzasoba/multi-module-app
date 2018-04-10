package entities;

import javax.persistence.*;

@Entity(name = "CAR")
@Table(name = "CAR")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "car_id")
    private long carId;
    @ManyToOne
    private Type type;
    @ManyToOne
    private Model model;
    @ManyToOne
    private Manufacturer manufacturerId;
    @Column(name = "year")
    private long year;
    @Column(name = "price")
    private long price;
    @Column(name = "color")
    private String color;
    @Column(name = "horse_power")
    private int horsePower;

    public long getId() {
        return carId;
    }

    public void setId(long carId) {
        this.carId = carId;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Manufacturer getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Manufacturer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
}
