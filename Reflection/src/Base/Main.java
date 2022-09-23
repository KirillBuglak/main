package Base;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class1 class1 = new Class1("Dick Dickson");
        System.out.println(class1.getClass().getName() +" "+ class1.getName());

        System.out.println("\nUsing Class. meths\n");

        Class.forName("Base.Class2").newInstance();
        String classs = "Base.Class2";
        Class cl = Class.forName(classs);
        Class2 class2 = new Class2();


    }
}
