package Hash;
import java.awt.*;
import java.util.Objects;

public class Hash1 {
    protected String name;
    protected String age;
    public Hash1(String name, String age){
        this.name=name;
        this.age=age;
        Color color = new Color(0x8000FF);

    }
    public void getHash(){
        System.out.println("The hash code for an object "+name+" is\n"+name.hashCode()+age.hashCode()+"\n");
    }
    public void getHashAll(){
        System.out.println("The ALL hash code for an object "+name+" is\n"+Objects.hash(name,age)+"\n");
    }
    public String toString(){
       return getClass()+"["+name+", "+age+"]";
    }
}
