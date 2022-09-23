public class Dimensions {
    private final double width; //mm
    private final double height; //mm
    private final double length; //mm

    public Dimensions(double width, double height, double length) {
        this.width = width;
        this.height = height;
        this.length = length;
    }

    public double volume() {
        return (width * height * length / 1000000000); //m3
    }
}
