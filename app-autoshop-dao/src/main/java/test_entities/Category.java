package test_entities;

import com.sun.org.apache.bcel.internal.generic.FALOAD;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

//@Entity
@Table(name = "CATEGORY", schema = "PUBLIC")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CATEGORY_ID", nullable = false, insertable = false, updatable = false)
    private Integer categoryId;
    @Column(name = "NAME")
    private String name;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //    @OneToMany
//    private List<Vehicle> vehicles;
//
//    public List<Vehicle> getVehicles() {
//        return vehicles;
//    }
//
//    public void setVehicles(List<Vehicle> vehicles) {
//        this.vehicles = vehicles;
//    }
//
//    public Integer getCategoryId() {
//        return categoryId;
//    }
//
//    public void setCategoryId(Integer categoryId) {
//        this.categoryId = categoryId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Category category = (Category) o;
//        return Objects.equals(name, category.name);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(name);
//    }
}
