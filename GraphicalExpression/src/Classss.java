import Base.MyFrame3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class Classss{
    static JFrame jFrame = getFrame();
    static JPanel jPanel = new JPanel();
    public static void main(String[] args) throws ClassNotFoundException {
//        var img = new ImageIcon("C:\\Users\\X\\Desktop\\Вечер\\Icon.jpg").getImage();
//        Close windowClose = new Close();
        KeyStroke key = KeyStroke.getKeyStroke("ctrl B");


        EventQueue.invokeLater(()->{
            JButton but = new JButton("BUTTS");
            MyAction myaction = new MyAction("SOME",Color.GREEN);
            but.addActionListener(myaction);
            jPanel.add(but);
            jFrame.add(jPanel);
            InputMap inmap = jPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
            inmap.put(key,"myaction");
            ActionMap acMap = jPanel.getActionMap();
            acMap.put("myaction",myaction);

//            MyFrame frame = new MyFrame();
//            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//            frame.setIconImage(img);
//            frame.setVisible(true);
//            frame.addWindowListener(windowClose);
//            frame.setSize(400,400);
        });
    }
    static JFrame getFrame(){
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setBounds(400,400,400,400);
        jFrame.setVisible(true);
        return jFrame;
    }

    static class Close implements WindowListener {

        @Override
        public void windowOpened(WindowEvent e) {
//            JFrame fr = new JFrame();
//            fr.setBounds(0,0,200,100);
//            fr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//            fr.setVisible(true);
        }

        @Override
        public void windowClosing(WindowEvent e) {
            JFrame fr = new JFrame();
            fr.setBounds(0,0,200,100);
            JPanel panel = new JPanel();
            JButton but = new JButton("CLOSE?");
            but.addActionListener(event->System.exit(0));
            panel.add(but);
            fr.add(panel);
            fr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            fr.setVisible(true);
        }

        @Override
        public void windowClosed(WindowEvent e) {

        }

        @Override
        public void windowIconified(WindowEvent e) {
            JFrame fr = new JFrame();
            fr.setBounds(0,0,200,100);
            JPanel panel = new JPanel();
            JButton but = new JButton("CLOSE?");
            but.addActionListener(event->System.exit(0));
            panel.add(but);
            fr.add(panel);
            fr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            fr.setVisible(true);
        }

        @Override
        public void windowDeiconified(WindowEvent e) {

        }

        @Override
        public void windowActivated(WindowEvent e) {

        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            JFrame fr = new JFrame();
            fr.setBounds(0,0,200,100);
            JPanel panel = new JPanel();
            JButton but = new JButton("CLOSE?");
            but.addActionListener(event->System.exit(0));
            panel.add(but);
            fr.add(panel);
            fr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            fr.setVisible(true);
        }
    }
    static class MyAction extends AbstractAction{
        Color color;
        public MyAction(String name, Color color){
            putValue(Action.NAME, name);
            putValue("Color", this.color=color);
            putValue(Action.SHORT_DESCRIPTION,"sets this thing to smthg");
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            jPanel.setBackground(color);
            MyComp myComp = new MyComp();
            jFrame.add(myComp);
        }
    }
}
class MyFrame extends JFrame{
    ImageIcon img = new ImageIcon("C:\\Users\\X\\Desktop\\Вечер\\Icon.jpg");
    MyComp comp = new MyComp();
    KeyStroke key = KeyStroke.getKeyStroke("ctrl B");
    JButton but = new JButton(img);
    JButton but2 = new JButton("but",img);
    JPanel butPan = new JPanel();


//    public void makeJBUt (String name, Color color){
//        JButton but = new JButton(name);
//        JPanel panel = new JPanel();
//        panel.add(but);
//        but.addActionListener(e->panel.setBackground(color));
//    }

    MyFrame(){


//        but.setSize(100,50);
//        but2.setSize(100,50);

//        but.setLocation(0,0);
//        but2.setLocation(0,50);

        setSize(400,400);

        butPan.add(but);
        butPan.add(but2);
        add(butPan);
        but.addActionListener(e-> {System.out.println("You've done it MAN!");
        but2.setBackground(Color.RED);});
        but2.addActionListener(e-> but.setBackground(Color.BLUE));


//        add(but);
//        add(but2);
//        add(comp);
//        pack();
    }
}
class MyComp extends JComponent{
    private static final int DEFAULT_WIDTH = 800;
    private static final int DEFAULT_HEIGHT = 200;
    Font font = new Font("Arial",Font.BOLD+Font.ITALIC,32);
    Font font1 = font.deriveFont(60.0F);
    String str = "Some sample string";
    FontRenderContext contex2 = getFontMetrics(font).getFontRenderContext();
    LineMetrics metr = font1.getLineMetrics(str,contex2);
    Image img = new ImageIcon("C:\\Users\\X\\Desktop\\Вечер\\Icon.jpg").getImage();


    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g.setColor(Color.RED);
        g.setFont(font1);

        FontRenderContext cont = g2.getFontRenderContext();
        Rectangle2D bounds = font1.getStringBounds(str,cont);
        g.setColor(Color.BLUE);
        double x = (getWidth()-bounds.getWidth())/2;
        double y = (getHeight()-bounds.getHeight())/2;
//        double asc = metr.getAscent();
//        double baseY = y+asc;
//        double des = metr.getDescent();
//        double lead = metr.getLeading();

//        g.drawString(str, (int) x, (int) baseY);
//        g2.setColor(Color.RED);
//        g2.draw(new Line2D.Double(x,baseY,x+bounds.getWidth(),baseY));
//        Rectangle2D rec = new Rectangle2D.Double(x,y+des/2,bounds.getWidth(),bounds.getHeight()-des/2);
//        g2.setColor(Color.BLACK);
//        g2.draw(rec);
        g2.drawImage(img,(int) x,(int)(y + bounds.getHeight()),Color.BLUE,null);
        g2.drawImage(img,0,0,Color.BLUE,null);
//        int imgW = img.getWidth(null);
//        int imgH = img.getHeight(null);
//        for (int i = 0; i*imgW<=getWidth();++i)
//            for (int j = 0; j*imgH<=getHeight();++j)
//                if (i+j>0) g.copyArea(0,0,imgW,imgH,i*imgW,j*imgH);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }
}