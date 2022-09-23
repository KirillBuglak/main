package Base;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class MyTryProcesses {
    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File("C:\\Users\\X\\Desktop\\Вечер\\inputText.txt");
        File file1 =
new File("C:\\Users\\X\\Desktop\\Вечер\\Khorstmann_Key_-_Java_Biblioteka_Professionala_Tom_1_Osnovy_11-E_Izdanie_-_2019.pdf");

        File file2 = new File("C:\\Users\\X\\Desktop\\Вечер\\IdeaProjects\\Classes\\out\\production\\Classes\\Main.class");
        var process = new ProcessBuilder()
            .command("notepad.exe", String.valueOf(file));
//        Thread.sleep(2000);

        var pr = new ProcessBuilder()
                .directory(new File("C:\\Users\\X\\Desktop\\Вечер"));
        pr.command("C:\\Program Files\\PDF24\\pdf24-Creator.exe", String.valueOf(file1)).start().waitFor();
//        Thread.sleep(2000);

        var jshell = new ProcessBuilder("java",String.valueOf(file2)).start();


        process.redirectInput(ProcessBuilder.Redirect.INHERIT).redirectOutput(ProcessBuilder.Redirect.
                appendTo(new File("C:\\Users\\X\\Desktop\\Вечер\\inputText.txt")));
        process.redirectErrorStream(true);

        Process ff = process.start();
        ff.waitFor();
        ProcessHandle ph = ff.toHandle();
        var info = ph.info().user();
        var info1 = ProcessHandle.of(ff.pid());
        System.err.println("INFO "+info+" "+info1);


//        var process1 = new ProcessBuilder("/bin/ls", "-l").start();

//        try (var in = new Scanner(process1.getInputStream())) {
//            while (in.hasNextLine())
//                System.out.println(in.nextLine());
//        }
//       try {
//           process.start().waitFor();
//       } catch (IOException e) {
//           e.printStackTrace();
//       }
        System.out.println("All processes "+ProcessHandle.allProcesses());
    }
}