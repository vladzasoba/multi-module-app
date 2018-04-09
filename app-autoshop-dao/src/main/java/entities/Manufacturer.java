package entities;

import javax.persistence.*;

@Entity(name = "MANUFACTURER")
@Table(name = "MANUFACTURER")
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "manufacturer_id")
    private long manufacturerId;
    @Column(name = "name")
    private String name;

    public long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
