package GennereiicClassesMyTurn;

public class Class1 <T extends Number, U extends Number, Y>{
     T num1;
     U num2;

    Class1(T num1, U num2){
        this.num1=num1;
        this.num2=num2;
    }

    public void doSmth(){
        System.out.println(num1.intValue()+num2.doubleValue());
    }

    public void getSecond(int a, int b, int c){
        System.out.println(b);
    }
}
