package entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "platform")
public class Platform extends Model {

    @Column(name ="platformNAMEanno")
    String platformTitle;
    @Temporal(TemporalType.DATE)
    Date paltformDate;
    @Temporal(TemporalType.TIME)
    Date paltformTime;
    @ManyToMany(mappedBy = "platformSet", fetch = FetchType.EAGER)
    Set <Provider> providerSet;

    public Platform(){super();}

    public Date getPaltformTime() {
        return paltformTime;
    }

    public void setPaltformTime(Date paltformTime) {
        this.paltformTime = paltformTime;
    }

    public Date getPaltformDate() {
        return paltformDate;
    }

    public void setPaltformDate(Date paltformDate) {
        this.paltformDate = paltformDate;
    }

    public Set<Provider> getProviderSet() {
        return providerSet;
    }

    public void setProviderSet(Set<Provider> providerSet) {
        this.providerSet = providerSet;
    }

    public String getPlatformTitle() {
        return platformTitle;
    }

    public void setPlatformTitle(String platformTitle) {
        this.platformTitle = platformTitle;
    }

    @Override
    public String toString() {
        return "Platform{" +
                "platformTitle='" + platformTitle + '\'' +
                ", ID=" + ID +
                '}';
    }
}
