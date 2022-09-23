package Base;

public class MyOwnException extends Exception{
    MyOwnException(){};
    MyOwnException(String x){
        super(x);
      /*  var issue = new ArithmeticException();
        Throwable throwable = issue.initCause(NullPointerException);*/
    }
}
