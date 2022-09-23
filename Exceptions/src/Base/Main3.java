package Base;

public class Main3 {
    public static void main(String[] args) {
        int[] one= {1,3,4,5,0,0,2,1};
        int[] two= {0,2,2,0,2,2,1,0};

        try {

            for (int i = 0; i <= one.length; i++) {
                try {
                    System.out.println(one[i] / two[i]);
                } catch (ArithmeticException ex) {
                    System.out.println("You just can't do whatever you want,\n" +
                            "I mean - DIVIDE BY ZERO!!!");
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("\nCheck your for statement plz"+ex);
        }
        finally {
            System.out.println("IN FINALLY BLOCK");
        }
        System.out.println("\nCode after all this shit");
    }
}
