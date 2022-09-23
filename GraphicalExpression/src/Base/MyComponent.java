package Base;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class MyComponent extends JComponent {
        int text_X = 50;
        int text_Y = 0;
        int text_Width = 600;
        int text_Height = 200;
        Font font1 = new Font("Times New Roman",Font.BOLD,24);
        Font font2 = new Font("Verdana",Font.BOLD+Font.ITALIC,20);
        Font font3 = font2.deriveFont(14);

       /* double rec_X = (double) text_X;
        double rec_Y = (double) text_Y;
        double rec_Width = (double) text_Width;
        double rec_Height = (double) text_Height;*/

        //Circle coordinated are lower cause no rectangle created yet

public void paintComponent(Graphics d) {

    //TEXT
    d.setFont(font1);
    d.setColor(Color.RED);
    /*d.drawString("Файл не загружается потому-что как-то так вот вышло",
            text_X, text_Y);*/
    var text = "Файл не загружается потому-что как-то так вот вышло...";

    FontRenderContext context = d.getFontMetrics().getFontRenderContext();
    Rectangle2D textBounds = font1.getStringBounds(text,context);
    double T_X = (getWidth() - textBounds.getWidth())/2;
    double T_Y = (getHeight() - textBounds.getHeight())/2;
    double T_Ascent = -textBounds.getY();
    double BaseLine = T_Y + T_Ascent;
    d.drawString(text,(int) T_X, (int) T_Y);
    LineMetrics metrix = font1.getLineMetrics(text,context);

    //RECTANGLE
    double rec_X = T_X;
    double rec_Y = T_Y+metrix.getDescent();
    double rec_Width = textBounds.getWidth();
    double rec_Height = textBounds.getHeight()*3;

    var d2 = (Graphics2D) d;
    d2.setColor(Color.BLACK);
    var rec = new Rectangle2D.Double(rec_X,rec_Y,rec_Width,rec_Height);
    d2.draw(rec);
    //ELLIPSE
    d2.setColor(Color.BLUE);
    var ell = new Ellipse2D.Double();
    ell.setFrame(rec);
    d2.draw(ell);
    //LINE
    d2.draw(new Line2D.Double(rec_X,rec_Y,
            rec_X+rec_Width,rec_Y+rec_Height/2));
    //LINE2
    d2.draw(new Line2D.Double(rec_X,rec_Y+rec_Height/2,
            rec_X+rec_Width,rec_Y));
    //LINE3
    d2.draw(new Line2D.Double(rec_X,rec_Y+rec_Height,
            rec_X+rec_Width,rec_Y+rec_Height/2));
    //LINE4
    d2.draw(new Line2D.Double(rec_X,rec_Y+rec_Height/2,
            rec_X+rec_Width,rec_Y+rec_Height));
    //LINE5
    d2.draw(new Line2D.Double(rec_X+rec_Width/2,rec_Y,
            rec_X+rec_Width/2,rec_Y+rec_Height));
    //CIRCLE
    d2.setColor(Color.magenta);
    double CirCent_X = rec.getCenterX();
    double CirCent_Y = rec.getCenterY();
    double radius = rec_Height/2;
    var cir = new Ellipse2D.Double();
    cir.setFrameFromCenter(CirCent_X,CirCent_Y,
            CirCent_X+radius,CirCent_Y+radius);
    d2.draw(cir);
    }

public Dimension getPreferredSize() {
    return new Dimension(text_Width+2*text_X,text_Height);
    }
}
