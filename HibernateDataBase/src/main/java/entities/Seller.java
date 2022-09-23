package entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
@Entity
@Table(name = "seller")
public class Seller extends Model{
    @Column(name = "sellerNameAnno")
    String sellerName;
    @OneToMany(mappedBy = "seller", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL/**Used in TestMain*/
    )
    Set<Vehicle> vehicleSet;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PLAT_ID")
    Platform platform;

    @ElementCollection(fetch = FetchType.EAGER)
    @JoinColumn(name = "SELLER_ID")
//    @OrderColumn(name = "PARTS_IDD")
    Collection<Parts> partsSet = new ArrayList<>();

    public Seller() {super();}

    public Collection<Parts> getPartsSet() {
        return partsSet;
    }

    public void setPartsSet(Collection<Parts> partsSet) {
        this.partsSet = partsSet;
    }

    public Set<Vehicle> getVehicleSet() {
        return vehicleSet;
    }

    public void setVehicleSet(Set<Vehicle> vehicleSet) {
        this.vehicleSet = vehicleSet;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "sellerName='" + sellerName + '\'' +
                ", platform=" + platform +
                ", ID=" + ID +
                '}';
    }
}
