package Base;

import javax.swing.*;
import java.awt.*;

import static javax.swing.SwingConstants.*;

public class LayoutThings {
    public static void main(String[] args) {
        JFrame fr = new JFrame();
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JButton but1 = new JButton("1");
        JButton but2 = new JButton("2");
        JButton but3 = new JButton("3");
        JButton a = new JButton("A");
        JButton b = new JButton("B");
        JButton c = new JButton("C");
        JButton d = new JButton("D");
        JTextArea tf = new JTextArea("YEP!",2,10);
        ImageIcon img = new ImageIcon("C:\\Users\\X\\Desktop\\Вечер\\Icon.jpg");
        JLabel label2 = new JLabel("LABEL: ",JLabel.LEFT);
        JLabel label = new JLabel(img, JLabel.LEFT);
        JPasswordField pasf = new JPasswordField(10);
        pasf.setEchoChar('+');

//        tf.setEnabled(false);
        tf.setLineWrap(true);
        a.setEnabled(false);
        tf.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,40));

        panel.add(but1);
        panel.add(but2);
        panel.add(but3);
        panel1.add(a);
        panel1.add(b);
        panel2.add(c);
        panel2.add(d);
        panel2.add(pasf);
        panel3.add(label2);
        panel3.add(label);
        panel3.add(tf);

        tf.setText("CHANGED!");

        fr.setVisible(true);
        fr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(3,1,20,20));
        panel1.setLayout(new GridLayout(2,1,12,12));
        fr.add(panel,BorderLayout.EAST);
        fr.add(panel1,BorderLayout.CENTER);
        fr.add(panel2,BorderLayout.SOUTH);
//        fr.add(panel3,BorderLayout.NORTH);
        fr.add(panel3,BorderLayout.NORTH);

        fr.setBounds(0,0,600,400);
    }
}
class Class{
    public static void main(String[] args) {
        JFrame fr = new JFrame();
        JTextArea tf = new JTextArea("YEP!",2,10);
        ImageIcon img = new ImageIcon("C:\\Users\\X\\Desktop\\Вечер\\Icon.jpg");
        JScrollPane panelscr = new JScrollPane(tf);
        fr.add(panelscr);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fr.setBounds(0,0,60,40);
    }
}
