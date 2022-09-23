package Base;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileView;
import java.awt.*;
import java.io.File;
import java.io.FileFilter;

public class FileDialogs {
    public static void main(String[] args) {
        var label = new JLabel("TEXT");
        label.setIcon(new ImageIcon("C:\\Users\\X\\Desktop\\Вечер\\Icon.jpg"));
        label.setSize(100,100);
        var foriconviewer = new FileNameExtensionFilter("","jpg","png");
        var frame = new JFrame();
        var menubar = new JMenuBar();
        var menu = new JMenu("SOME MENU");
        var item1 = new JMenuItem("Open Dialog");
        JFileChooser open = new JFileChooser();
//        MJLabel iconviewer = new MJLabel(open);
//        iconviewer.setSize(100,100);

        open.setCurrentDirectory(new File("C:\\Users\\X\\Desktop\\Вечер"));
        open.setMultiSelectionEnabled(true);
        open.setFileFilter(new FileNameExtensionFilter(".jpg","jpg"));
        open.setAcceptAllFileFilterUsed(false);
        open.setFileView(new MFileView(new FileNameExtensionFilter("jpg","jpg"),
                new ImageIcon("C:\\Users\\X\\Desktop\\Вечер\\Icon.jpg")));
        open.add(label,BorderLayout.NORTH);
        open.addPropertyChangeListener(e->{
            if (e.getPropertyName()==JFileChooser.SELECTED_FILE_CHANGED_PROPERTY){
                var newfile = (File) e.getNewValue();
                if (!newfile.isDirectory() && foriconviewer.accept(newfile)) {
                    var icon = new ImageIcon(newfile.getPath());
                    icon = new ImageIcon(icon.getImage().getScaledInstance(100, 100, 100));
                    label.setIcon(icon);
                }
//                iconviewer.loadImage(newfile);
            }
        });
        JFileChooser save = new JFileChooser();
        save.setCurrentDirectory(new File("C:\\Users\\X\\Desktop\\Вечер"));
        save.setSelectedFile(new File("Default_name"));
        item1.addActionListener(e->{
            open.showDialog(frame,"Approve?");
        });
        var item2 = new JMenuItem("Save Dialog");
        item2.addActionListener(e->{
            save.showSaveDialog(frame);
        });
        menu.add(item1);
        menu.add(item2);
        menubar.add(menu);
        frame.setJMenuBar(menubar);
        frame.setVisible(true);
        frame.setSize(600,400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
class MFileView extends FileView{
    FileNameExtensionFilter filter;
    Icon icon;
    MFileView(FileNameExtensionFilter filter, Icon icon){
        this.filter=filter;
        this.icon=icon;
    }
    @Override
    public Icon getIcon(File f) {
        if (!f.isDirectory() & filter.accept(f)) return icon;
        else return null;
    }

    @Override
    public String getName(File f) {
        return super.getName(f);
    }

    @Override
    public String getDescription(File f) {
        return super.getDescription(f);
    }

    @Override
    public String getTypeDescription(File f) {
        return super.getTypeDescription(f);
    }

    @Override
    public Boolean isTraversable(File f) {
        return super.isTraversable(f);
    }
}
class MJLabel extends JLabel{
    File f;
    public MJLabel(JFileChooser fchoo){
            this.setSize(100,100);
            this.setBorder(BorderFactory.createEtchedBorder());
        }
      public void loadImage(File f){
        var ic = new ImageIcon(f.getPath());
        if (ic.getIconWidth()>getWidth()) ic = new ImageIcon(ic.
                getImage().
                getScaledInstance(getWidth(), -1, Image.SCALE_DEFAULT));
        this.setIcon(ic);
        repaint();
    }
}