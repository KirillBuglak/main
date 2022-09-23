package Assertions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {

       // Logger.getGlobal().setLevel(Level.OFF);

        int x = 2;
        assert (x>4) : "OOOOoops";
        Logger.getGlobal().info("Didlo->NOT FOUND, FUSK!");
        Logger.getGlobal().severe("PZDC");
        log1.setLevel(Level.FINEST);
        log1.info("Severe logMess");
        Logger.getLogger("Flugher").info("Blast");

        try (FileReader read = new FileReader("USA")) {
        } catch (FileNotFoundException e) {
            log1.log(Level.WARNING,"There's no such a file dummy",e);
        } catch (IOException e) {
            System.out.println("InputOutput WrongDoing");
        }


    }
    final private static Logger log1 = Logger.getLogger("MyFirstEverLogger");

}
