import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.IntConsumer;
import java.util.function.ToIntBiFunction;

import static java.util.Comparator.*;

public class MainForFunUnnececery {

    public static StCl StCl(String[] a){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int av=0;
        for (String x:a){
            if (x.length()>max) max=x.length();
            if (x.length()<min) min=x.length();
            av = (max+min)/2;
        }
        return new StCl(max,min,av);
    }
    static class StCl{
        int x,y,z;
        StCl(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    public static void main(String[] args){
        var cust = new ArrayList<People>();
        var strings = new String[]{"a","aaaaA","A","aa"};
        System.out.println("HEY"+StCl(strings).x+"_"+StCl(strings).y+"_"+StCl(strings).z);

        cust.add(new People(183,"Small"));
        cust.add(new People(175,"Big"));
        cust.add(new People(175,null));
        cust.add(new People(190,"Medium2"));
        cust.add(new People(190,"Medium1"));
       /** cust.removeIf(p -> p.height<185);
        for (People x : cust)
            System.out.println(x.toString());**/
        var mainOne = new MainForFunUnnececery();
        mainOne.doStuff(cust, People::some);
        mainOne.runnn(5,(x)->System.out.println("YEPP"+x));
        System.out.println(
                mainOne.intgr(new People(10,"HUGE"), new Animals(23,"atThePeak"),
                (x,y)-> x.height+y.age));
        cust.sort(Comparator.comparing(People::getS,nullsFirst(naturalOrder())));
        for (People x : cust) System.out.println(x.toString());
    }
    void doStuff(ArrayList<People> p, Inter i){
        for (People x : p) i.str(x);
    }
    void runnn(int x, IntConsumer r){
        for (int i=0;i<x;++i){
            r.accept(x);
        }
    }
    int intgr(People p, Animals a,ToIntBiFunction<People, Animals> x) {
        return x.applyAsInt(p, a);
    }
}
class Animals{
    int age;
    String growth;
    Animals(int age, String growth) {
        this.age = age;
        this.growth = growth;
        }
}
class People{
    public int height;
    public String size;
People(int height, String size){
    this.height=height;
    this.size=size;
    }
public void some(){
    System.out.println("Height: " + this.height +" Size: " + this.size);
    }
public int getH(){
    return this.height;
    }
public String getS(){
    return this.size;
    }
public String toString(){
    return "Height: "+height+" "+"Size: "+size;
}
}
interface Inter{
    void str(People p);
}
/**class ComparatorImplementor implements Comparator<TryToDoSmth>{

    @Override
    public int compare(TryToDoSmth o1, TryToDoSmth o2) {
        return o1.a-o2.a;
    }
}
class TryToDoSmth{
    int a,b;
    String str;
    public TryToDoSmth(int a, int b, String str){
        this.a = a;
        this.b = b;
        this.str = str;
    }
    public void getA(){
        System.out.println(a);
    }
}**/
/**enum Enum{
    One("one"), Two("two"), Three("three");
    private String a;

    private Enum(String a){
        this.a = a;
    }
    public String getA(){
        return a;
    }
}
class Class2 extends Class{

    Class2(int num, String str, double d) {
        super(num, str, d);
    }
}
class Class extends AbstractClass {
    double d;
    Class(int num, String str, double d) {
        super(num, str);
        this.d=d;
    }
}
abstract class AbstractClass{

    {System.out.println("Abstract initializing");}
    int num;
    String str;

    AbstractClass(int num,String str){
        this.num=num;
        this.str=str;
    }
}**/
