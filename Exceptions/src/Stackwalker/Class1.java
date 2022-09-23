package Stackwalker;

import java.util.List;
import java.util.stream.Collectors;

public class Class1 {

    public static void main(String[] args) {

        stalkWalkFillterSoOn().forEach(System.out::println);

    }
        private static List<String> stalkWalkFillterSoOn(){
            return StackWalker.getInstance().walk(x ->
                    x.map(frame -> frame.getClassName()+"_"+frame.getMethodName())
                            .limit(10).collect(Collectors.toList()));
        }
    }
