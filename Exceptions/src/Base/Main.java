package Base;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your length");
        int length = scan.nextInt();
        try {
            checkLength(length);
        }
        catch (Exception e){
          System.out.println("hmm..."+e+e.getMessage()+e.getCause());
        }
        System.out.println("The rests of this program");

    }
    static void checkLength(int length) throws MyOwnException{
        if (length>=15) {
            System.out.println("You are ok");
        }else{ throw new MyOwnException("\nProblem is that you are too short!");
        }

    }
}
