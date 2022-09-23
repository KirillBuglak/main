package pack1;

public class Main {

    public static void main(String[] args) {
        Class1 one = new Class1("dild", 3);
       // System.out.println(one.getName());
      //  one.setDicklength(23);

        Class1[] array = new Class1[2];//Cannot change to Class2 since it's a subclass
        array[0] = one;
        array[1]= new Class1("fuck",7);
        Class2 two = (Class2) array[0];//why?

        for (Class1 e: array) {
            System.out.println(e.getName());//executes methods from Class1 and Class2 respectively - good thing to have
        }
    }
}
