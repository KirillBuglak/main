package metro;

public class Station {

    private int number;
    private String name;
    private Line line;
    private String depth;
    private String date;
    private boolean hasChange;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        String third;
        if (depth.equals("?")) {
            third = null;
        } else {
            String first = depth.replace("\"", "");
            String second = first.replace("−", "-");
            third = second.replace(",", ".");
        }
        this.depth = third;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public boolean isHasChange() {
        return hasChange;
    }

    public void setHasChange(boolean hasChange) {
        this.hasChange = hasChange;
    }

    @Override
    public String toString() {
        return "metro.Station{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", line=" + line.getNumber() +
                ", depth='" + depth + '\'' +
                ", date='" + date + '\'' +
                ", hasChange=" + hasChange +
                '}';
    }
}