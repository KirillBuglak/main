package Base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame2 extends JFrame {

    JPanel ButtPanel;
    int Panel_Width = 300;
    int Panel_Height = 200;

public MyFrame2(){
    setSize(Panel_Width,Panel_Height);
    var GreenButt = new JButton("Green");
    var BlackButt = new JButton("Black");
    var MagButt = new JButton("Magnt");

    ButtPanel = new JPanel();

  /*  ButtPanel.add(GreenButt);
    ButtPanel.add(BlackButt);
    ButtPanel.add(MagButt);*/

    add(ButtPanel);

   /* var GreenAction = new MyActionListener(Color.GREEN);
    var BlackAction = new MyActionListener(Color.BLACK);
    var MagAction = new MyActionListener(Color.MAGENTA);*/
    makeButt("Green",Color.GREEN);
    makeButt("Black",Color.BLACK);
    makeButt("Mag",Color.MAGENTA);

    /**anotherButt("Butt");**/


  /*  GreenButt.addActionListener(GreenAction);
    BlackButt.addActionListener(BlackAction);
    MagButt.addActionListener(MagAction);*/
}
public void makeButt(String name, Color color){
    var butt = new JButton(name);
    ButtPanel.add(butt);
    butt.addActionListener(e -> ButtPanel.setBackground(color));
}
/**public void anotherButt(String name){
    var butt = new JButton(name);
    add(new MyComponent());
}**/
/**INNER CLASS @ActionListener to access @ButtPanel**/
/*private class MyActionListener implements ActionListener
{
    private Color bckgrd;

    public MyActionListener(Color c){
        bckgrd = c;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ButtPanel.setBackground(bckgrd);
    }
}*/
}