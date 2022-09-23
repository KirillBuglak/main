package Base;

import javax.swing.*;

public class MyFrame extends JFrame
{
  //  private static final int DefHeight = 600;
  //  private static final int DefWidth = 1000;

public MyFrame(){
    add(new MyComponent2());/**Choose between @MyComponents**/
    pack();//pack uses the size of components OR setSize(DefWidth,DefHeight) sizes of a frame;
    }
}
