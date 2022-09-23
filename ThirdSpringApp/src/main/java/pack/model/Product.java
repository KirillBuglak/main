package pack.model;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Can't be blank")
    @Size(min = 3, max = 10, message = "Should be between 3 and 10")
    private String label;
    @NotBlank(message = "Enter MAIL")
    @Email(message = "Not an Email")
    private String mail;

    public Product() {
    }

    public Product(int id, String label, String mail) {
        this.id = id;
        this.label = label;
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}