package GenericClassesVariousMeths.Wheels;

public class Stocks extends Wheels{

    public Stocks(int numberOFSpokes, String rimType) {
        super(numberOFSpokes, rimType);
    }
    public void dirt(){
        System.out.println("SPLASH!!!");
    }
}