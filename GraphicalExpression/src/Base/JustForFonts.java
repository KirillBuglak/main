package Base;

import java.awt.*;

public class JustForFonts {
    public static void main(String[] args) {
        String [] fonts = GraphicsEnvironment.
        getLocalGraphicsEnvironment().
        getAvailableFontFamilyNames();
        for (String font: fonts)
            System.out.println(font);
    }
}
