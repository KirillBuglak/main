package Enums;

public enum NotAClass {
    MOTORCYCLE("moto"), MOPED("mop"), DIRTBIKE("dirt");
    private String constrvalue;
    /**Constuctor comes after variables it has to construct
     * because this constructor is private:Thus - can only be used inside this class
     * this is pretty much why it comes after variables*/
 NotAClass (String constrvalue){
        this.constrvalue=constrvalue;
    }
    public void doStuff(){
        System.out.println(constrvalue+" Wrum Wrum!!!\n");
    }
}
