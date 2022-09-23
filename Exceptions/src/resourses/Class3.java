package resourses;

public class Class3 implements AutoCloseable{
    private String name;
    private boolean throwExeption;

    public Class3(String name, boolean throwExeption){
        this.name = name;
        this.throwExeption=throwExeption;
    }
    public void doStuff(boolean x) throws Exception{
        System.out.println("Resource "+this.name+" doing Stuff");
        if (x){
            throw new Exception("doStuff CRASH, COLLAPSE and THE END!!! "+this.name);
        }
    }
    @Override
    public void close() throws Exception {
        System.out.println("Resource "+this.name+" Closed() called");
        if (this.throwExeption){
            throw new Exception("BOOOMMM Close Error " + this.name);
        }
    }
}
