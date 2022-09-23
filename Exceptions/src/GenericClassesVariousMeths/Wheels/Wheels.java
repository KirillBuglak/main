package GenericClassesVariousMeths.Wheels;

public class Wheels {

    int numberOFSpokes;
    String rimType;

    public Wheels(int numberOFSpokes, String rimType) {
        this.numberOFSpokes = numberOFSpokes;
        this.rimType = rimType;
    }

    public int getNumberOFSpokes() {
        return numberOFSpokes;
    }

    public void setNumberOFSpokes(int numberOFSpokes) {
        this.numberOFSpokes = numberOFSpokes;
    }

    public String getRimType() {
        return rimType;
    }

    public void setRimType(String rimType) {
        this.rimType = rimType;
    }
}
