package Base;


import javax.swing.*;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;

import static javax.swing.SwingConstants.*;

class Class2 {
    public static void main(String[] args) {
        var frame = new JFrame();
        var textarea = new JTextArea(2, 10);
        var tf = new JTextField(10);
        var tf2 = new JTextField(10);
        var scrpane = new JScrollPane(textarea);
        var pass = new JPasswordField(10);
        var insertbut = new JButton("INSERT");
        var label = new Label("TEXT field1");
        var label2 = new Label("TEXT field12");
        insertbut.addActionListener(e->{
            textarea.append("text field1: "+tf.getText()+"\ntext field2: "+tf2.getText()+
                    "\npassword: "+pass.getPassword().toString());
        });
        var panelso = new JPanel();
        var panel1nor = new JPanel();
        var panel2ce = new JPanel();
        panelso.add(insertbut);
        panel2ce.add(label);
        panel2ce.add(tf);
        panel2ce.add(label2);
        panel2ce.add(tf2);
        panel2ce.add(pass);

        frame.add(panelso, BorderLayout.SOUTH);
        frame.add(panel1nor);
        frame.add(scrpane, BorderLayout.CENTER);
        frame.add(panel2ce, BorderLayout.NORTH);

        frame.setBounds(400,100,600,600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
    }
}
class CheckBpxes{
    /** make it work like in a book*/
    public static void main(String[] args) {
        String mess = "something to play with!";
        var but1 = new JButton("but1");
        var but2 = new JButton("but2");
        var frame = new JFrame();
        var panel = new JPanel();
        var panel1 = new JPanel();
        var panel2 = new JPanel();
        var font = new Font("Arial",0,40);
        var textArea = new JTextArea(mess);
        textArea.setEditable(false);
        var combobos = new JComboBox<String>();
        var combobosmod = new DefaultComboBoxModel<String>();
        var slider = new JSlider(HORIZONTAL,20,80,50);
        ChangeListener change = e->{System.out.println("CHANGER");};
        var menuBar = new JMenuBar();
        var fileMenu = new JMenu("FILE!");
        fileMenu.setMnemonic('F');
        var somenu = new JMenu("SOME");
        var someAction = new AbstractAction("smthg"){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("smthg has been performed");
            }
        };
        someAction.putValue(Action.SMALL_ICON,new ImageIcon("C:\\Users\\X\\Desktop\\Вечер\\Icon.jpg"));

        var someItem = somenu.add(someAction);
        var copy = new JMenuItem("COPY", 'C');
        var paste = new JMenuItem("PASTE",'P');
        var check = new JCheckBoxMenuItem("Check");
        var check1 = new JCheckBoxMenuItem("Check");
        var peck = new JCheckBoxMenuItem("Peck");
        check.addActionListener(e->{
            if (check.isSelected()) {peck.setEnabled(false);
            if (peck.isSelected()) peck.setSelected(false);}
            if (!check.isSelected()) peck.setEnabled(true);
        });
        var ra = new JRadioButtonMenuItem("RA");
        var rb = new JRadioButtonMenuItem("RB");
        var grp = new ButtonGroup();
        grp.add(ra);
        grp.add(rb);
        somenu.add(ra);
        somenu.add(rb);
        var toolBar = new JToolBar("Toolbar",VERTICAL);
        toolBar.add(but1);
        toolBar.addSeparator();
        toolBar.add(but2);


        fileMenu.add(check);
        fileMenu.add(peck);
        copy.addActionListener(e-> System.out.println("CopyAction"));
        copy.setIcon(new ImageIcon("C:\\Users\\X\\Desktop\\Вечер\\Icon2.jpg"));
        paste.setIcon(new ImageIcon("C:\\Users\\X\\Desktop\\Вечер\\Icon.jpg"));
        paste.setHorizontalTextPosition(LEFT);
        paste.addActionListener(e-> System.out.println("PasteAction"));
        paste.setAccelerator(KeyStroke.getKeyStroke("ctrl P"));

        fileMenu.add(copy);
        fileMenu.addSeparator();
        fileMenu.add(paste);
        menuBar.add(fileMenu);
        menuBar.add(somenu);
        var pop = new JPopupMenu();
        pop.add(copy);
        pop.add(check1);
        combobos.setComponentPopupMenu(pop);
        menuBar.setComponentPopupMenu(pop);
        menuBar.setToolTipText("Do something with this thing");


        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(10);
        slider.setSnapToTicks(true);
        slider.setPaintTicks(true);
        slider.setPaintTrack(true);
        slider.setInverted(true);
        slider.createStandardLabels(10,20);
        slider.setPaintLabels(true);
        slider.addChangeListener(change);
        var labelya = new Hashtable<Integer,Component>();
        labelya.put(0,new JLabel("Z"));
        labelya.put(20,new JLabel("A"));
        labelya.put(40,new JLabel("B"));
        labelya.put(60,new JLabel("C"));
        labelya.put(80,new JLabel("D"));
        labelya.put(100,new JLabel("Z"));
        var imgs = new Hashtable<Integer,Component>();
        imgs.put(20,new JLabel(new ImageIcon("C:\\Users\\X\\Desktop\\Вечер\\Icon.jpg")));
        imgs.put(40,new JLabel(new ImageIcon("C:\\Users\\X\\Desktop\\Вечер\\Icon2.jpg")));
        imgs.put(60,new JLabel(new ImageIcon("C:\\Users\\X\\Desktop\\Вечер\\Icon.jpg")));
        imgs.put(80,new JLabel(new ImageIcon("C:\\Users\\X\\Desktop\\Вечер\\Icon3.jpg")));
        slider.setLabelTable(labelya);
        slider.setLabelTable(imgs);
        slider.setToolTipText("Slide this ting");

        combobos.setEditable(true);
        LinkedList<String> list = new LinkedList<>();
        list.add("blah");
        list.add("GRRRA");
        list.add("man");
        list.add("Harld");
        combobosmod.addAll(list);
//        for (int i =0; i<= list.size()-1;++i)
//            combobos.addItem(list.get(i));
        combobos.setModel(combobosmod);
        combobos.addItemListener(e-> System.out.println(e.getItem()));
        combobos.removeItemAt(2);
        textArea.setFont(font);
        textArea.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.BLUE),"Text area"));
        var radioButts = new ButtonGroup();
        var small = new JRadioButton("Small",false);
        small.addActionListener(e->{textArea.setFont(textArea.getFont().deriveFont(10.0F));});
        var medium = new JRadioButton("Medium",false);
        medium.addActionListener(e->{textArea.setFont(textArea.getFont().deriveFont(40.0F));});
        var huge = new JRadioButton("Huge",true);
        huge.addActionListener(e->{textArea.setFont(textArea.getFont().deriveFont(60.0F));});
        radioButts.add(small);
        radioButts.add(medium);
        radioButts.add(huge);
        var italic = new JCheckBox("ITALIC");
        var bold = new JCheckBox("BOLD");
        ActionListener listener = e-> {
            int optiobs=0;
            if (italic.isSelected()) optiobs+=Font.ITALIC;
            if (bold.isSelected()) optiobs+=Font.BOLD;
                Font ft = textArea.getFont().deriveFont(optiobs);
                textArea.setFont(ft);
        };
        italic.addActionListener(listener);
        bold.addActionListener(listener);
        panel.add(textArea);
        panel.setLayout(new GridLayout(3,3));
        panel1.add(combobos);
        panel1.add(slider);
        panel2.add(italic);
        panel2.add(bold);
        panel2.add(small);
        panel2.add(medium);
        panel2.add(huge);
        panel2.setLayout(new GridLayout(3,2));
        panel2.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(),"Some butts"));
        frame.add(panel,BorderLayout.NORTH);
        frame.add(panel2,BorderLayout.SOUTH);
        frame.add(panel1,BorderLayout.CENTER);
        frame.setJMenuBar(menuBar);

        frame.setBounds(300,0,600,600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(toolBar, BorderLayout.EAST);

        frame.pack();
    }
}
class gridBagLayoutThing {
    public static void main(String[] args) {
        var insets = new Insets(10, 10, 10, 10);
        LinkedList<String> list = new LinkedList<>();
        list.add("blah");
        list.add("GRRRAhhhhhhhh!");
        list.add("man");
        list.add("Harld");
        var but1 = new JButton("but1");
        var but2 = new JButton("but2");
        var but3 = new JButton("but3");
        var commbbx = new JComboBox<String>();
        var cmbbxmodel = new DefaultComboBoxModel<String>();
        var text = new JTextArea("Some text here", 20, 20);
        text.setEditable(false);
        cmbbxmodel.addAll(list);
        commbbx.setModel(cmbbxmodel);
        commbbx.setEditable(false);
        var frame = new JFrame();
        var panel = new JPanel();
        var gridbaglay = new GridBagLayout();
        panel.setLayout(gridbaglay);
        var constrs = new GridBagConstraints();
        constrs.weightx = 100;
        constrs.weighty = 100;
        constrs.gridx = 0;
        constrs.gridy = 0;
        constrs.gridwidth = 100;
        constrs.gridheight = 10;
        var constrs2 = new GridBagConstraints();
        constrs2.weightx = 5;
        constrs2.weighty = 5;
        constrs2.gridx = 10;
        constrs2.gridy = 0;
        constrs2.gridwidth = 20;
        constrs2.gridheight = 20;
        var constrs3 = new GridBagConstraints();
        constrs3.weightx = 20;
        constrs3.weighty = 60;
        constrs3.gridx = 0;
        constrs3.gridy = 10;
        constrs3.gridwidth = 100;
        constrs3.gridheight = 50;
        var constrs4 = new GridBagConstraints();
        constrs4.weightx = 50;
        constrs4.weighty = 0;
        constrs4.gridx = 60;
        constrs4.gridy = 100;
        constrs4.gridwidth = 10;
        constrs4.gridheight = 5;


//        panel.add(but1, constrs);
//        panel.add(but2, constrs2);
//        panel.add(but3, GridBagConstraints.HORIZONTAL);
//        panel.add(commbbx, constrs3);
//        panel.add(text, constrs4);
//        panel.add(but1, new GBC(1,1));
        panel.add(but1, new GBC(0,0).setFill(RIGHT));
        panel.add(but2, new GBC(0,1).setFill(RIGHT).setInsets(10));
        panel.add(but3, new GBC(2,2).setFill(RIGHT).setInsets(10).setIpad(10,100));

        frame.add(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(400,400));
        frame.pack();
    }
}
    class GBC extends GridBagConstraints{
        GBC(int grx, int gry){
            gridx=grx;
            gridy=gry;
        }
        GBC(int grx, int gry, int grw, int grh){
            gridx=grx;
            gridy=gry;
            gridwidth=grw;
            gridheight=grh;
        }
        public GBC setAnchor(int anchor){
            this.anchor = anchor;
            return this;
        }
        public GBC setFill(int fill){
            this.fill = fill;
            return this;
        }
        public GBC setWeight(double weightx, double weighty){
            this.weightx = weightx;
            this.weighty = weighty;
            return this;
        }
        public GBC setInsets(int distance){
            this.insets = new Insets(distance,distance,distance,distance);
            return this;
        }
        public GBC setInsets(int top, int left, int bottom, int right){
            this.insets = new Insets(top,left,bottom,right);
            return this;
        }
        public GBC setIpad(int ipadx, int ipady){
            this.ipadx=ipadx;
            this.ipady=ipady;
            return this;
        }
    }
class MyLayout implements LayoutManager{

    @Override
    public void addLayoutComponent(String name, Component comp) {
        addLayoutComponent(name,comp);
    }

    @Override
    public void removeLayoutComponent(Component comp) {
        removeLayoutComponent(comp);
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return parent.getPreferredSize();
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return parent.getPreferredSize();
    }

    @Override
    public void layoutContainer(Container parent) {
        parent.setBounds(parent.getBounds());
    }
}