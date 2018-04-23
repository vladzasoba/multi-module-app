package faces;

import auto_shop_service.AutoShopService;
import auto_shop_service.AutoShopServiceImple;
import new_entities.Manufacturer;
import new_entities.Vehicle;

import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "productList")
public class ShopProducts {
    private AutoShopService autoShopService = new AutoShopServiceImple();
    private List<Vehicle> filteredVehicles;

    public List<Vehicle> getFilteredVehicles() {
        return filteredVehicles;
    }

    public void setFilteredVehicles(List<Vehicle> filteredVehicles) {
        this.filteredVehicles = filteredVehicles;
    }

    public List<Vehicle> getVehicles() {
        return autoShopService.getVehicles();
    }

    public boolean filterByPrice(Object value, Object filter) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if(filterText == null||filterText.equals("")) {
            return true;
        }

        if(value == null) {
            return false;
        }

        return ((Comparable) value).compareTo(Integer.valueOf(filterText)) > 0;
    }

    public List<String> getManufacturers() {
        List<Manufacturer> manufacturers = autoShopService.getManufacturers();
        List<String> brands = new ArrayList<>();
        for (Manufacturer m : manufacturers) {
            brands.add(m.getName());
        }
        return brands;
    }

    public List<String> getColors() {
        return autoShopService.getColors();
    }
}
