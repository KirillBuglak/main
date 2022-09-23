package GenericClass;

public class Main {
    public static void main(String[] args) {

        Class111<String> class111 =new Class111<>("George","Brighton");
   // System.out.println(class1.getClass().getName());
        System.out.println(
        class111.getFirst()+
        class111.getSecond()
        );

        String[] letters = {"GreG","Michael","Molly","Armen"};

        Integer[] numbers = {1,22,3,4,555,75};

        Class111<String> cl1 = Class2.minmax(letters);
        System.out.println("Min = "+cl1.getFirst());
        System.out.println("Max = "+cl1.getSecond());

      /*  Class1<Integer> cl11 = Class2.minmax(numbers);
        System.out.println("Min = "+cl11.getFirst());
        System.out.println("Max = "+cl11.getSecond());*/

       // Class3.yepP("F","sgag");

    }


}
