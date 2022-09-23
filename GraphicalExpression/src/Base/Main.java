package Base;

import java.awt.*;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(()-> {
            /**Choose among @MyFrames**/
            var frame = new MyFrame();
          //  var listener = new ClosingThing();
          //  frame.addWindowListener(listener);
            frame.setTitle("Очень важная штука");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        } );
    }
}