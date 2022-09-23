package entities;

import jakarta.persistence.*;

import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "provider")
public class Provider extends Model{
    @Column(name = "provName")
    @Size(min = 1, max = 5, message = "To much letters in provider's name")
    String providerName;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "PROV_PLAT",
            joinColumns = @JoinColumn(name = "provJOIN"),
    inverseJoinColumns = @JoinColumn(name = "platformJOIN"))
    Set <Platform> platformSet;

    public Provider(){super();}


    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public Set<Platform> getPlatformSet() {
        return platformSet;
    }

    public void setPlatformSet(Set<Platform> platformSet) {
        this.platformSet = platformSet;
    }

    @Override
    public String toString() {
        return "Provider{" +
                "providerName='" + providerName + '\'' +
                ", ID=" + ID +
                '}';
    }
}
