package MethMultParams;

public class Class1 {
    public void manyInts(int...ints){
        for (int x: ints){
            System.out.println("Summ of x +2 is "+(x+2));
        }
    }
    public void minValue(long...longs){
        long min = Long.MAX_VALUE;
        for(long x:longs) if (x<min) {
            min = x;
        }else{continue;}
        System.out.println("The minimum Value is "+min);
    }
    public static int maximumV(int...ints){
        int max = Integer.MIN_VALUE;
        for (int x : ints) if(x>max) max=x;
        return max;
            }

    /**
     * Continue from here
     * Create STATIC meth for practice and use the name of a CLASS to call it
     */
    public enum Just{Didl,Buts,Fusk,Cockpit}

}
