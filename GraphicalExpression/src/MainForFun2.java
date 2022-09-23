import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

public class MainForFun2 {
    public static void main(String[] args) {
        var numbers = new Object[1000];
        for (int i=0;i < numbers.length;++i){
            Integer val = i+1;
            Object protoxy = Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                    new Class[]{Comparable.class},new Somehandler(val));
            numbers[i] = protoxy;
        }
        Integer hole = new Random().nextInt(numbers.length)+1;
        int result = Arrays.binarySearch(numbers,hole);
        if (result>=0) System.out.println(numbers[result]);
    }
}

class Somehandler implements InvocationHandler{
    private Object aim;
    Somehandler(Object aim){
        this.aim=aim;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print(aim);
        System.out.print("."+method.getName()+"(");
        if (args!=null) {
            for (int i=0;i< args.length;++i){
                System.out.print(args[i]);
                if (i< args.length-1) System.out.print(", ");
            }
        }
        System.out.println(")");
        return method.invoke(aim,args);
    }
}