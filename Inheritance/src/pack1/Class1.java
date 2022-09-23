package pack1;

import java.util.Scanner;

class Class1 {
    Scanner scan = new Scanner(System.in);
    private String name;
    public double weight;
    Class1(String par1, int par2){
        System.out.println("Print name");
        this.name = scan.nextLine();
        System.out.println("Print weight");
        this.weight = scan.nextDouble();
        System.out.println(par1+par2+"\n");
    }

    public String getName(){
        return this.name;
    }
}
