import parts.*;

public class Computer {
    private Processor processor;
    private RAM ram;
    private HardDrive hardDrive;
    private Monitor monitor;
    private Keyboard keyboard;
    private final String vendor;
    private final String name;

    public Computer(String vendor, String name) {
        this.vendor = vendor;
        this.name = name;
    }

    public Computer(String vendor, String name, Processor processor, RAM ram,
                    HardDrive hardDrive, Monitor monitor, Keyboard keyboard) {
        this(vendor, name);
        this.processor = processor;
        this.ram = ram;
        this.hardDrive = hardDrive;
        this.monitor = monitor;
        this.keyboard = keyboard;
    }

    public double getComputerWeight() {
        return processor.getWeight() + ram.getWeight() + monitor.getWeight()
                + keyboard.getWeight() + hardDrive.getWeight();
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public HardDrive getHardDrive() {
        return hardDrive;
    }

    public void setHardDrive(HardDrive hardDrive) {
        this.hardDrive = hardDrive;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    @Override
    public String toString() {
        return "----------------------" + "\n" + "Computer \n" +
                "vendor=" + vendor +
                ", name=" + name + ", " + "\n" +
                processor.toString() + "\n" + ram.toString() + "\n" + monitor.toString() + "\n" + keyboard.toString() + "\n" + hardDrive.toString()
                + "\n" + "----------------------";
    }
}
