package entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vehicle")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DIFFER", discriminatorType = DiscriminatorType.STRING)
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)/**@TABLE creates table with seq-s*/
    int serialNumber;
    //    @Column(name = "MANUFanno")
    @Column
//    @NotFound(action = NotFoundAction.IGNORE)
    String manufacturer;
    @Column(name = "MODELanno")
    String model;
    @Transient /** Do not need to add this to table as a column*/
    Date date;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "CLient_ID")
    Client client;
    @ManyToOne(
/**Can use cascade here - so we would @Persist Auto instances, not Seller ones*/
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "Seller_ID", nullable = false)
    Seller seller;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    Platform platform;
    @Embedded
    @AttributeOverrides({
    @AttributeOverride(name = "Name_of_PART",
            column = @Column(name = "OVERR_partName")),
    @AttributeOverride(name = "Amount_of_PARTS",
            column = @Column(name = "OVERR_ammount"))
    })
    Parts nationalParts;
    @Embedded
    Parts importParts;
    @ElementCollection
    @JoinTable(name = "VEHICLE_PARTS",
    joinColumns = @JoinColumn(name = "VEHICLE_ID"))
    Set<Parts> partsSet = new HashSet<>();

    public Vehicle(){}

    public Set<Parts> getPartsSet() {
        return partsSet;
    }

    public void setPartsSet(Set<Parts> partsSet) {
        this.partsSet = partsSet;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Parts getNationalParts() {
        return nationalParts;
    }

    public void setNationalParts(Parts nationalParts) {
        this.nationalParts = nationalParts;
    }

    public Parts getImportParts() {
        return importParts;
    }

    public void setImportParts(Parts importParts) {
        this.importParts = importParts;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "serialNumber=" + serialNumber +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", client=" + client +
                ", seller=" + seller +
                ", platform=" + platform +
                ", nationalParts=" + nationalParts +
                ", importParts=" + importParts +
                '}';
    }
}
