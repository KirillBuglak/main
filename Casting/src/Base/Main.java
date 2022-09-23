package Base;

public class Main {
static double x = 12.34;
    public static void main(String[] args) {
 //       System.out.println((int)x);
        Class1 class1 = new Class1();
        Class2 class2 = new Class2();
        Class1 class11 = new Class2();/** UPCASTING*/
      //  Class2 class21=(Class2) class1;
        class11.getclass(); /** Calls an overriden meth from Class2 */
        class11.onlyClass1();/** The same object Calls meth from Class1*/
        Class2 class22 = (Class2) class11;/** DOWNCASTING*/
       if (class22 instanceof Class1){
        System.out.println("\nYEP it's an instance of Class1");
           class22.onlyClass1();} /** allows an object from class2 to use meths from Superclass -Class1 */
        else{
            System.out.println("NOPE it's not an instance of Class1");
       }
           /**
         * WE have to upcast to downcast thereafter
         * Class1 class11 = new Class2();
         * Class2 class22 = (Class2) class11;
         * !!!class22 is a new variable!!!
         */
     //   class21.onlyClass2();
      //  class2.onlyClass2();
      //  class11.getclass();
    }
}
