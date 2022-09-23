package entities;

import jakarta.persistence.*;

import java.util.Set;
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int clientNumber;
//    @Column(name = "clientNameAnno")
    @Basic
    String clientName;
    @OneToOne()
    Seller seller;
    @OneToMany(mappedBy = "client")
//    @JoinTable(name = "CLIENT_AUTO",
//            joinColumns = @JoinColumn(name = "CLIENT_ID"),
//            inverseJoinColumns = @JoinColumn(name = "AUTO_ID"))
    Set<Vehicle> vehicleSet;
    @OneToOne(cascade = CascadeType.ALL)
    Platform platform;

    public Client(){}

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Set<Vehicle> getVehicleSet() {
        return vehicleSet;
    }

    public void setVehicleSet(Set<Vehicle> vehicleSet) {
        this.vehicleSet = vehicleSet;
    }

    public int getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(int clientNumber) {
        this.clientNumber = clientNumber;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientNumber=" + clientNumber +
                ", clientName='" + clientName + '\'' +
                ", seller=" + seller +
                ", platform=" + platform +
                '}';
    }
}
