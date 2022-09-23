package Hash;

public class Hash11 extends Hash1{
private int just;
    public Hash11(String name, String age,int just) {
        super(name, age);
        this.just=just;
    }
    public String toString(){
        return super.toString()+"["+just+"]";
    }
}
