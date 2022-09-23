package Base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.prefs.Preferences;

public class Prefs {

    public static void main(String[] args) {
    EventQueue.invokeLater(()-> {
        FR fr = new FR("SOME", 0, 0, 600, 400);
        JPanel pane = new JPanel();
        JButton but = new JButton("REMEMBER?");

        but.addActionListener(e->{
            fr.prefs.putInt("x", fr.getLocation().x);
            fr.prefs.putInt("y", fr.getLocation().y);
            fr.prefs.putInt("w", fr.getWidth());
            fr.prefs.putInt("h", fr.getHeight());
                });
        pane.add(but);
        fr.add(pane);
        fr.setBounds(fr.prefs.getInt("x",0),fr.prefs.getInt("y",0),
                fr.prefs.getInt("w",0),fr.prefs.getInt("h",0));
    });

    }
}
class FR extends JFrame{

    Preferences prefs = Preferences.userRoot().node(FR.class.getCanonicalName());

    FR(String name, int x, int y, int w, int h){
       this.setTitle(name);
       setBounds(x,y,w,h);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setVisible(true);
       addWindowListener(new WindowAdapter() {
           @Override
           public void windowClosing(WindowEvent e) {
               prefs.putInt("x", getLocation().x);
               prefs.putInt("y", getLocation().y);
               prefs.putInt("w", getWidth());
               prefs.putInt("h", getHeight());
           }
       });
        setBounds(prefs.getInt("x",0),prefs.getInt("y",0),
                prefs.getInt("w",0),prefs.getInt("h",0));
    }
}