package Stackwalker;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        first().forEach(x->System.out.println(x));

    }
    private static List<String> first(){
        return second();
    }
    private static List<String> second(){
        return StackWalker.getInstance().walk(x->x.map(frame -> frame.getClassName()+
                "_"+frame.getMethodName())
                .collect(Collectors.toList()));
    }
}
