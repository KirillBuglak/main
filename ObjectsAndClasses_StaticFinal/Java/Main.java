import enums.HDType;
import enums.MonitorType;
import parts.*;

public class Main {
    public static void main(String[] args) {

        Processor processor1 = new Processor(64, 8, "RADEON", 20);
        Processor processor2 = new Processor(64, 8, "RADEON", 20);
        RAM ram1 = new RAM("Good One", 8, 100);
        RAM ram2 = new RAM("Bad One", 2, 200);
        Monitor monitor1 = new Monitor(17, MonitorType.VA, 1780);
        Monitor monitor2 = new Monitor(22, MonitorType.IPS, 1990);
        Keyboard keyboard1 = new Keyboard("Gaming One", false, 400);
        Keyboard keyboard2 = new Keyboard("Office One", true, 650);
        HardDrive hardDrive1 = new HardDrive(HDType.SSD, 1000, 1500);
        HardDrive hardDrive2 = new HardDrive(HDType.HDD, 20, 2000);

        Computer computer1 = new Computer("Lenovo", "Lm500");
        computer1.setProcessor(processor1);
        computer1.setRam(ram1);
        computer1.setMonitor(monitor1);
        computer1.setKeyboard(keyboard1);
        computer1.setHardDrive(hardDrive1);

        Computer computer2 = new Computer("HP","h700",processor2,ram2,hardDrive2,monitor2,keyboard2);

        System.out.println(computer1.getComputerWeight());
        System.out.println(computer2.getComputerWeight());

        System.out.println(computer1);
        System.out.println(computer2);

        System.out.println(monitor1.getType());
        System.out.println(monitor2.getType());
    }
}