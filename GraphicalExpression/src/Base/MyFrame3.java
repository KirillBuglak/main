package Base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MyFrame3 extends JFrame{
    public JPanel Butts;
    int Panel_Width = 300;
    int Panel_Height = 200;
    Image img = new ImageIcon("C:\\Users\\X\\Desktop\\Вечер\\REDDOT.png").getImage();
    Image img2 = new ImageIcon("C:\\Users\\X\\Desktop\\Вечер\\BLUEDOT.png").getImage();

    public MyFrame3(){
        setSize(Panel_Width,Panel_Height);
        var Butts = new JPanel();
        var REDaction = new ColorAction(Color.RED, null,"Red");
        var BLUEaction = new ColorAction(Color.BLUE, null,"Blue");
        var REDbutt = new JButton(REDaction);
        var BLUEbutt = new JButton(BLUEaction);
        Butts.add(REDbutt);
        Butts.add(BLUEbutt);
        add(Butts);
    }

    public class ColorAction extends AbstractAction {

        public ColorAction(Color c, Icon ic, String name){
            putValue(Action.NAME,name);
            putValue(Action.SMALL_ICON,ic);
            putValue("color",c);
            putValue(Action.SHORT_DESCRIPTION,"Makes this "+name.toLowerCase());
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            Color color = (Color) getValue("color");
            Butts.setBackground(color);
        }
    }
}
