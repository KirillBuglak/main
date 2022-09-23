package Enums;

import java.util.Objects;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {

        NotAClass notAClass = NotAClass.MOPED;
        NotAClass notAClass2 = NotAClass.DIRTBIKE;
        NotAClass notAClass3 = NotAClass.MOTORCYCLE;

        notAClass.doStuff();
        notAClass2.doStuff();
        notAClass3.doStuff();

       // NotAClass val = Enum.valueOf(NotAClass.class, "MOPED");
       // out.println(val);
        out.println("Prints out the relative position in Enum for implicit \'first\' arg = " +notAClass.compareTo(notAClass3));

        out.println(NotAClass.DIRTBIKE.ordinal());
        out.println(notAClass==notAClass2);

    }
}
