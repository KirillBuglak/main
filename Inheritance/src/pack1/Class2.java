package pack1;
final class Class2 extends Class1 {
    private int dicklength;
    Class2(String par, int fusk) {
        super(par, fusk);
        dicklength=0;
    }

    public String getName() {
        if (weight <= 120) {
            return super.getName() + ", you're fat!";
        } else if (weight > 120 & weight <=130) {
            return super.getName() + ", you're a fat fuck!";
        } else {
            return super.getName() + ", I do not have words for that";
        }
    }
    public void setDicklength(int cm){
        dicklength=cm;
        System.out.println("Your disk is "+dicklength+"cm long");
    }

}
