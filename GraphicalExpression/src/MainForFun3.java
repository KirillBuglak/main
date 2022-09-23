import java.lang.reflect.*;
import java.util.*;

public class MainForFun3 {

    public static void main(String[] args) {
        String name;
        if (args.length > 0) name = args[0];
        else {
            try (var scanner = new Scanner(System.in)) {
                System.out.println("Enter class's name");
                name = scanner.next();
            }
        }
        try {
            Class<?> cl = Class.forName(name);
//            printCl(cl);
            for (Method m : cl.getDeclaredMethods())
                printMeth(m);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
//        public static void printCl(Class<?> cl) {
//        System.out.print(cl);
//        printTyps(cl.getTypeParameters(),"< "," , "," >",true);
//        Type tp = cl.getGenericSuperclass();
//        if (tp!=null){
//            System.out.print(" extends ");
//            printTp(tp, false);
//        }
//        printTyps(cl.getGenericInterfaces(), " implements ",", "," ", false);
//        System.out.println();
//    }
        public static void printMeth(Method m){
        String name = m.getName();
//            System.out.print(Modifier.toString(m.getModifiers()));
//            System.out.print(" ");
//            printTyps(m.getTypeParameters(),"< "," , "," >",true);
//            printTp(m.getGenericReturnType(),false);
//            System.out.print(" ");
//            System.out.print(name);
//            System.out.print("(");
    /** **/        printTyps(m.getGenericParameterTypes(),"< "," , "," >",false);
//            System.out.println(")");
        }
        public static void printTyps(Type[] typs, String pre, String sep, String suf, boolean b){
//        if (pre.equalsIgnoreCase(" extends ")&&Arrays.equals(typs, new Type[]{Object.class}))
//            return;
//        if (typs.length>0) System.out.print(pre);
        for (int i = 0; i< typs.length; ++i){
//            if (i>0) System.out.print(sep);
            printTp(typs[i], b);
            System.out.println("_");
        }
//        if (typs.length>0) System.out.print(suf);
        }

        public static void printTp(Type tp, boolean b){
        if (tp instanceof Class){
            var t = (Class<?>) tp;
            System.out.print(t.getName());
        }
//        else
//            if (tp instanceof TypeVariable){
//            var t = (TypeVariable<?>) tp;
//            System.out.print(t.getName());
//            if (b) printTyps(t.getBounds()," extends ","&", " ",false);
//        }
//        else if (tp instanceof WildcardType){
//            var t = (WildcardType) tp;
//            System.out.print("?");
//            printTyps(t.getUpperBounds()," extends ","&", " ",false);
//            printTyps(t.getLowerBounds()," super ","&", "",false);
//        }
//        else
            if (tp instanceof ParameterizedType){
            var t = (ParameterizedType) tp;
//            Type own = t.getOwnerType();
//            if (own!=null){
//                printTp(own,false);
//                System.out.print(".");
//            }
//            printTp(t.getRawType(),false);
            printTyps(t.getActualTypeArguments(),"< "," , "," >",false);
        }
//        else if (tp instanceof GenericArrayType){
//            var t = (GenericArrayType) tp;
//            System.out.print("");
//            printTp(t.getGenericComponentType(),b);
//            System.out.print("[]");
//        }
    }
}