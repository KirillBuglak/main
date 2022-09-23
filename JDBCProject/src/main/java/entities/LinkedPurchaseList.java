package entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import keys.LinkPurKey;

@Entity
@Table(name = "linked_purchase_list")
public class LinkedPurchaseList {

    @EmbeddedId
    private LinkPurKey id;

    public LinkPurKey getId() {
        return id;
    }

    public void setId(LinkPurKey id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "entities.LinkedPurchaseList{" +
                "id=" + id +
                '}';
    }
}
