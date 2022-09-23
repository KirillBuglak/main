package pack.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import javax.validation.constraints.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int what;
    @NotEmpty(message = "Manufacturer should be filled")
    @Size(min = 3, max = 5, message = "Should not be less than 3 and more than 5")
    private String manufacturer;

    @Min(value = 1990, message = "Should not be older than 1990")
    @Max(value = 2010, message = "Can't be newer than 2010")
    private int year;

    @NotEmpty(message = "Enter some body type")
    private String body;

    public Car() {
    }

    public Car(int what, String manufacturer, int year, String body) {
        this.what = what;
        this.manufacturer = manufacturer;
        this.year = year;
        this.body = body;
    }

    public int getWhat() {
        return what;
    }

    public void setWhat(int what) {
        this.what = what;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Car{" +
                "what=" + what +
                ", manufacturer='" + manufacturer + '\'' +
                ", year=" + year +
                ", body='" + body + '\'' +
                '}';
    }
}