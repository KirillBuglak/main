import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class MouseMayhem {
    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            JFrame Frame = new JFrame();
            JPanel panel = new JPanel();
            JTextField text = new JTextField();
            text.setVisible(true);
            text.setLocation(0,0);
            panel.add(new MouseCom());
            panel.add(text);
            Frame.add(panel);
            Frame.setBounds(100,100,600,400);
            Frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            Frame.setVisible(true);
        });
    }
}
    class MouseCom extends JComponent{
        private static final int DEF_H = 400;
        private static final int DEF_W = 600;
        private static int SOME = 60;
        private ArrayList<Rectangle2D> recs;
        private Rectangle2D current;

        public MouseCom(){
            recs = new ArrayList<>();
            current=null;
            addMouseListener(new ClickHand());
            addMouseMotionListener(new Motionhand());

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(DEF_W,DEF_H);
        }

        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g.setColor(Color.RED);
            for (Rectangle2D r : recs)
                g2.fill(r);
        }
        public Rectangle2D find(Point2D p){
            for (Rectangle2D r : recs){
                if (r.contains(p)) return r;
            }
            return null;
        }
        public void addrec(Point2D p){
            double x = p.getX();
            double y = p.getY();
            current = new Rectangle2D.Double(x-SOME/2, y-SOME/2,
                    SOME, SOME);
            recs.add(current);
            repaint();
        }
        public void removerec(Rectangle2D re){
            if (re==null) return;
            if (re==current) current=null;
            recs.remove(re);
            repaint();
        }


    class ClickHand implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            current = find(e.getPoint());
            if (current!=null & e.getClickCount()>=2)
                removerec(current);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            current = find(e.getPoint());
            if (current == null) addrec(e.getPoint());
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (e.getClickCount()>=3) SOME+=10;
            if (e.getClickCount()>=4) SOME-=20;
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            System.out.println("yep!");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            System.out.println("nope!");
        }
    }

    class Motionhand implements MouseMotionListener {
        @Override
        public void mouseDragged(MouseEvent e) {
            if (current!=null) {
                int x = e.getX();
                int y = e.getY();
                current.setFrame(x-SOME/2,y-SOME/2,SOME,SOME);
                repaint();
            }
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            if (find(e.getPoint())==null) setCursor(Cursor.getDefaultCursor());
            else setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        }
    }
}