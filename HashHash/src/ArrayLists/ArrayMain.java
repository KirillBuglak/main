package ArrayLists;
import Hash.*;

import java.util.ArrayList;

public class ArrayMain {

    public static void main(String[] args) {
        /**
         * Try to make an array being filled up from SCANNER
         * Through a while loop with x as an exit code
         */

        Hash1 h1 = new Hash1("Didl","thirty one");  //1
        Hash1 h2 = new Hash1("Midl","forty one");   //22
        Hash1 h3 = new Hash1("Ashley","twony one"); //3
        Hash1 h4 = new Hash1("INTRUDER","DOESN'T MATTER!"); //4

        var firstONe = new ArrayList<Hash1>(5);

        firstONe.add(h1);
        firstONe.add(h2);
        firstONe.add(h3);
        firstONe.add(1,h4); //setting the element in the middle of the array
        firstONe.remove(2); //removes h2

        System.out.println("First array\n");
        System.out.println(firstONe);
        firstONe.trimToSize(); //just for fun
        System.out.println("The size of this arraylist is "+firstONe.size());
        System.out.println("\nFirst element of First arraylist is "+firstONe.get(0));


        var secondONe = new ArrayList<Hash11>();

        secondONe.ensureCapacity(2); /** Fuckery?! Why should I state minCapacity? */

        secondONe.add(new Hash11("Pidl","thirty one",31));    //1
        secondONe.add(new Hash11("Pidr","fifty three",53));   //2
        secondONe.add(new Hash11("Buts","seventy eight",78)); //3
        System.out.println("\nSecond array\n");
        System.out.println(secondONe);
        secondONe.trimToSize(); //just for fun
        System.out.println("The size of this arraylist is "+secondONe.size());
        System.out.println("\nFirst element of Second arraylist is "+secondONe.get(0));


    }
}
