package Base;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

public class LongRunningTasks {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            var frame = new Myframe1();
            frame.setSize(600,400);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
class Myframe1 extends JFrame{
        JFileChooser fchooser;
        JTextArea tarea;
        JLabel statusthing;
        JMenuItem open;
        JMenuItem cancel;
        JMenuBar menbar;
        JMenu MENUE;
        SwingWorker<StringBuilder,DataThing> fileRead;

    public Myframe1(){
        fchooser = new JFileChooser();
        fchooser.setCurrentDirectory(new File("."));


        tarea = new JTextArea(10,20);
        add(new JScrollPane(tarea));

        statusthing = new JLabel("STATUS");
        add(statusthing,BorderLayout.SOUTH);

        menbar = new JMenuBar();
        setJMenuBar(menbar);

        MENUE = new JMenu("SOME MENU");
        menbar.add(MENUE);

        open = new JMenuItem("OPEN");
        cancel = new JMenuItem("CANCEL");
        cancel.setEnabled(false);
        MENUE.add(open);
        MENUE.add(cancel);
        open.addActionListener(e-> {
            int inres = fchooser.showOpenDialog(null);
            if (inres == JFileChooser.APPROVE_OPTION) {
                tarea.setText("APPROVE");
                open.setEnabled(false);
                fileRead = new SomeReader(fchooser.getSelectedFile());

                fileRead.execute();
                cancel.setEnabled(true);
            }
        });
        cancel.addActionListener(y->fileRead.cancel(true));
            pack();
        }


    class DataThing{
        int num;
        String str;
    }

    class SomeReader extends SwingWorker<StringBuilder,DataThing>{

        StringBuilder strbl = new StringBuilder();
        File file;

        SomeReader(File file){
            this.file=file;
        }

        @Override
        public StringBuilder doInBackground() throws Exception {
            int numberOfLines=0;
            try(Scanner scanner = new Scanner(new FileInputStream(file),
                    StandardCharsets.UTF_8)){
                while (scanner.hasNextLine()){
                    String line = scanner.nextLine();
                    numberOfLines++;
                    strbl.append(line).append("\n");
                    var data = new DataThing();
                    data.num=numberOfLines;
                    data.str=line;
                    publish(data);
                    Thread.sleep(4000);
                    }
            }
            return strbl;
        }

        @Override
        public void process(List<DataThing> chunks) {
            if (isCancelled()) return;
            var newstrbl = new StringBuilder();
            statusthing.setText(""+chunks.get(chunks.size()-1).num);
            for (DataThing d : chunks) newstrbl.append(d.str)
                    .append("\n");
            tarea.append(newstrbl.toString());
        }

        @Override
        public void done() {
            try{
                StringBuilder res = get();
                tarea.setText(res.toString());
                statusthing.setText("WE'VE MADE IT!");

            } catch (ExecutionException e) {
                e.getMessage();
            } catch (InterruptedException e) {
            }catch (CancellationException e){
                tarea.setText("CANCELLED");
                statusthing.setText("YOU'VE INTERRUPTED IT");
            }
            cancel.setEnabled(false);
            open.setEnabled(true);
        }
    }
}