package resourses;

public class Class2 implements AutoCloseable{

   /* private String name;
    private boolean throwExceptionWhenClose;*/

    @Override
    public void close() throws Exception {
        System.out.println("Exception created by me!!!");
    }
}

