package DTO;

public class SomeOneDTO {
    private int ID;
    private String name;

    public SomeOneDTO(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "SomeOneDTO{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                '}';
    }
}
