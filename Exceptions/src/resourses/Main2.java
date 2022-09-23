package resourses;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class Main2 {

    public static void main(String[] args) {
        var array = new String[]{"Derek","john"};
        var array2 = new int[]{1,3};
        var writer = new PrintWriter(new Writer() {
            @Override
            public void write(char[] cbuf, int off, int len) throws IOException {
            }
            @Override
            public void flush() throws IOException {
            }
            @Override
            public void close() throws IOException {
            }
        });

        Class1 class1 = new Class1();
        class1.getSrings(array,writer);
    }
}