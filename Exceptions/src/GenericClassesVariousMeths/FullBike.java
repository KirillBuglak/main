package GenericClassesVariousMeths;

import GenericClassesVariousMeths.Wheels.Wheels;

public class FullBike <W extends Wheels> {

    private W wheels;
private String frame;
private String fearings;
private double hp;

    public FullBike(W wheels, String frame, String fearings, double hp) {
        this.wheels = wheels;
        this.frame = frame;
        this.fearings = fearings;
        this.hp = hp;
    }

    public W getWheels() {
        return wheels;
    }

    public void setWheels(W wheels) {
        this.wheels = wheels;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getFearings() {
        return fearings;
    }

    public void setFearings(String fearings) {
        this.fearings = fearings;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }
}
