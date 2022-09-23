package WrappersAndAutoboxing;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String numbSstring = "2";
        int numb = Integer.parseInt(numbSstring);

        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i=0;i <=10;i++){
           int x = random.nextInt(100,200);
             numbers.add(i,x);
        }

        numbers.add(0,(int)34.2);
        numbers.add(12,1);

        System.out.println("ArrayList ti string\n"+numbers.toString());
        System.out.println("\nSumm of numb and 3 is "+(numb+3)+"\nShould be 5");
        System.out.println("Integer Maximum value is "+Integer.MAX_VALUE);
        Integer first = new Integer(10);
        Integer second = new Integer(10);
        int firsti =10;
        int secondi =10;
      //  System.out.println(first.equals(second)); //True
        System.out.println(first==second); //False
        System.out.println(first.hashCode());
        System.out.println(second.hashCode());


        System.out.println(firsti==secondi);
       // System.out.println(firsti.hashCode());    Doesn't work
       // System.out.println(secondi.hashCode());   Doesn't work

    }
}
