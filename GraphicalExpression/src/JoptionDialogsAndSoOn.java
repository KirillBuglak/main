import com.sun.security.auth.UserPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.desktop.UserSessionEvent;
import java.net.PasswordAuthentication;
import java.nio.file.attribute.UserPrincipalLookupService;

public class JoptionDialogsAndSoOn {
    public static void main(String[] args) {
        var options = new String[]{"yes","no","WTF"};

        JOptionPane.showMessageDialog(new JLabel("some"),"ERR message","MESSMTHFKR!",JOptionPane.ERROR_MESSAGE);
        JOptionPane.showConfirmDialog(new JLabel("some"),
                "WARN message","YEp",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
        JOptionPane.showOptionDialog(new JLabel("some"),"PLAIN message",
                "Title",1,JOptionPane.PLAIN_MESSAGE,null,options,null);
        JOptionPane.showInputDialog(new JLabel("some"),"QUEST message",JOptionPane.QUESTION_MESSAGE);

    }
}
class AllByHand{
    public static void main(String[] args) {
        var frame = new DialogFrame(600,400);
    }
}
class DialogFrame extends JFrame{
    passchose dialog = null;
    JTextArea smArea = new JTextArea();
    DialogFrame(int width, int height){

        this.setSize(width,height);
        var menuBar = new MenuBar();
        var submenu = new Menu("SUB Some");
        var menuItem = new MenuItem("ITEM");
        var exitItem = new MenuItem("PRESS TO EXIT");
        menuItem.addActionListener(e->new MyDialog(this));
        exitItem.addActionListener((e->System.exit(0)));
        submenu.add(menuItem);
        submenu.add(exitItem);
        var menu = new Menu("Some");
        menu.add(submenu);
        menuBar.add(menu);
        this.setMenuBar(menuBar);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        smArea.setSize(100,100);
        this.add(smArea,BorderLayout.CENTER);
//        pack();
    }
    class MyDialog extends JDialog{
        passchose dialog = null;
        MyDialog(JFrame owner){

            super(owner,"DIALOGUE TING",true);
            var but = new JButton("OK?");
            var con = new JButton("CONNECT!");
            var but3 = new JButton("YES?");
            var panel = new JPanel();
            var comb = new JComboBox<String>();
            comb.setEditable(true);
            panel.setLayout(new GridLayout(2,2));
            panel.add(but);
            panel.add(con);
            panel.add(but3);
            but.addActionListener(e->this.setVisible(false));
            con.addActionListener(e->
            {
                if (dialog == null) dialog = new passchose();
                if (dialog.showDialog(DialogFrame.this,"Title set in Showing dialog")){
                    User us = dialog.getUser();
                    smArea.append("User login: "+us.getName()+"\n"+"Password: "+us.getPassword());
                    smArea.setLineWrap(true);
                }
            });
            this.add(panel,BorderLayout.SOUTH);
            this.add(comb,BorderLayout.NORTH);
            this.setSize(600,400);
            this.getRootPane().setDefaultButton(con);
            this.setLocation(300,300);
            this.setVisible(true);
//            this.pack();
        }
    }
    class passchose extends JPanel{
        JTextField login = new JTextField("");
        JPasswordField password = new JPasswordField("");
        JDialog dialog;
        boolean ok;
        JButton okbut;
        JButton cancelbut;
        passchose(){
            this.setLayout(new BorderLayout());
            var panel = new JPanel();
            panel.setLayout(new GridLayout(2,2));
            panel.add(new JLabel("Login:"));
            panel.add(login);
            panel.add(new JLabel("Passwoord:"));
            panel.add(password);
            this.add(panel, BorderLayout.CENTER);
            okbut = new JButton("OK");
            okbut.addActionListener(e->{
                ok=true;
                dialog.setVisible(false);
            });
            cancelbut = new JButton("CANCEL");
            cancelbut.addActionListener(e->dialog.setVisible(false));
            var butpan = new JPanel();
            butpan.add(okbut);
            butpan.add(cancelbut);
            this.add(butpan, BorderLayout.SOUTH);
            this.setLocation(400,400);
        }
        public void setUser(User u){
            login.setText(u.getName());
        }
        public User getUser(){
            return new User(login.getText()/**getName()*/,password.getPassword());
        }

        public boolean showDialog(Component grandfather, String titl){
            ok = false;
            JFrame owner = null;
            if (grandfather instanceof JFrame) owner = (JFrame) grandfather;
            else owner = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class,grandfather);
            if (dialog == null || dialog.getOwner()!=owner) {
                dialog = new JDialog(owner,true);
                dialog.add(this);
                dialog.getRootPane().setDefaultButton(cancelbut);
                dialog.pack();
            }
            dialog.setTitle("Some TITLE");
            dialog.setLocation(400,400);
            dialog.setVisible(true);
            return ok;
        }
    }
}
class User{
    String name;
    char[] password;
    User(String name, char[] password){
        this.name=name;
        this.password=password;
    }
    public String getName(){
        return name;
    }

    public String getPassword() {
        String str = "";
        for (int i = 0;i< password.length;++i)
            str = str.concat(String.valueOf(password[i]));
        return str;
    }
}