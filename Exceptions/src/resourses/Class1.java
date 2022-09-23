package resourses;

import java.io.PrintWriter;

public class Class1 implements AutoCloseable{
    @Override
    public void close(){
    }
    public static void getSrings(String [] strings, PrintWriter prnt){
        try(prnt){
            for(String e : strings){
                prnt.println(e);
                            }
        }
    }
}
