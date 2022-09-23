import java.io.File;

public class Main {
    private static final String srcFolder = "C:\\Users\\kiril\\OneDrive\\Рабочий стол\\Java";
    private static final String dscFolder = "C:\\Users\\kiril\\OneDrive\\Рабочий стол\\Java\\newImages";
    private static final File[] initFiles = new File(srcFolder).listFiles();
    private static final int procNumber = Runtime.getRuntime().availableProcessors();
    private static int step;
    private static int srcPosition;
    private static final int newWidth = 300;
    private static File[] files;
    private static MyThread myThread;
    private static int arraysSubLength;
    private static int threadNumber;


    public static void main(String[] args) {

        threadNumber = Math.min(initFiles.length, procNumber);

        step = initFiles.length / threadNumber;

        for (int i = 0; i < threadNumber; i++) {
            files = new File[step];
            arraysSubLength += files.length;

            srcPosition = i * step;

            if (i == threadNumber - 1) {
                files = new File[initFiles.length - (arraysSubLength - step)];
                if (arraysSubLength == 0) {
                    files = new File[initFiles.length];
                    srcPosition = 0;
                }
            }

            System.arraycopy(initFiles, srcPosition, files, 0, files.length);
            myThread = new MyThread(files, dscFolder, newWidth, System.currentTimeMillis());
            myThread.start();
        }
    }
}