package MethMultParams;

import static MethMultParams.Class1.maximumV;

public class Main {

    public static void main(String[] args) {
        Class1 class1 = new Class1();
        class1.manyInts(1,2,3,4,5,64);
        class1.minValue(-256,2,3,4,1,4,5,123,4);

        System.out.println("\nMAXIMUM VALUE IS "+maximumV(23424,235362547,23,1));

    }
}
