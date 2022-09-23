package Base;

import Hash.Hash1;
import Hash.Hash11;

import java.awt.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	var string1 = "HY U!";
    var sb1 = new StringBuilder(string1);
    var string2 = "HY U!";
    var sb2 = new StringBuilder(string2);
    var point = new Point(5, 23);
    String points = "Coordinates are "+point;

    System.out.println(points);
    System.out.println(string1.hashCode()+"\n"+sb1.hashCode()+"\n");
    System.out.println(string2.hashCode()+"\n"+sb2.hashCode()+"\n");
    System.out.println(string1.hashCode()-sb1.hashCode());


        Hash1 h1 = new Hash1("Nyde","sixteen");
        Hash1 h2 = new Hash1("Hyde","twelve");
        Hash11 hash11 = new Hash11("Dyde","twenty",123);

    System.out.println("\nGet meths");
        h1.getHash();
        h1.getHashAll();
        h2.getHash();
        h2.getHashAll();
        hash11.getHash();
        hash11.getHashAll();

    System.out.println("\ntoString meths");
        System.out.println(h1.toString());
        System.out.println(h2.toString());
        System.out.println(hash11.toString());

        System.out.println(System.out);

        System.out.println("\nArrays\n");
        int [] array = {1,36,4,32,1};
        System.out.println(Arrays.toString(array));

    }
}
