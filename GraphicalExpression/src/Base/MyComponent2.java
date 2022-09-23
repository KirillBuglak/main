package Base;

import javax.swing.*;
import java.awt.*;

    public class MyComponent2 extends JComponent {
        Image img = new ImageIcon("C:\\Users\\X\\Desktop\\Вечер\\Icon.jpg").getImage();
        int img_W=20;
        int img_H=20;

    public void paintComponent(Graphics d) {
        d.drawImage(img, 0, 0, img_W, img_H, null);
        for (int i = 0; i * img_W <= getWidth(); i++)
            for (int j = 0; j * img_H <= getHeight(); j++)
                if (i + j > 0)
                    d.copyArea(0, 0, img_W, img_H, i * img_W, j * img_H);
    }
    public Dimension getPreferredSize() {
        return new Dimension(300,200);
    }
}
