package Base;

public class Main2 {

    public static void main(String[] args) {

        try {
            tryThis();
        }
        catch (Exception e){
            System.out.println("Exception is "+e);
            System.out.println("Cause of exception is "+e.getCause());
        }
    }
    static void tryThis(){
        var problem = new ArithmeticException("Do not div by ZERO!!!");
        problem.initCause(new NullPointerException());
        throw problem;
    }
}
