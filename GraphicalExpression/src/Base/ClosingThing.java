package Base;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClosingThing extends WindowAdapter {
    @Override
    public void windowClosed(WindowEvent e) {
      //  if (user agrees)
            System.exit(0);
    }
}
