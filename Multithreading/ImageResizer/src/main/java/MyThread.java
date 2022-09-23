import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class MyThread extends Thread {

    private static int i = 1;

    private final File[] files;
    private final String dscFolder;
    private final int newWidth;
    private final long start;

    public MyThread(File[] files, String dscFolder, int newWidth, long start) {
        this.files = files;
        this.dscFolder = dscFolder;
        this.newWidth = newWidth;
        this.start = start;
    }

    @Override
    public void run() {
        try {

            for (File file : files) {

                if (file == null || !(file.getName().endsWith(".jpg") || file.getName().endsWith(".png"))) continue;
                BufferedImage imageSrc = ImageIO.read(file);
                if (imageSrc == null) continue;
                int newHeight = (int) Math.round(imageSrc.getHeight() / (imageSrc.getWidth() / (double) newWidth));
                BufferedImage imageDst = Scalr.resize(imageSrc, newWidth, newHeight);

                File newFile = new File(dscFolder + "/" + file.getName());
                ImageIO.write(imageDst, "jpg", newFile);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(i++ + "\t Time for this operation is - " + (System.currentTimeMillis() - start) + " ms");
    }
}