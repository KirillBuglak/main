package GenericClassesBounds;

public class Class111<T> {

     private T first;
     private T second;

   // public Class111() {first=null; second=null;}

    public Class111(T first, T second){
        this.first=first;
        this.second=second;
    }
    public T getFirst() {
        return first;
    }
    public T getSecond() {
        return second;
    }
    public void setFirst(T val){
        first=val;
    }
    public void setSecond(T second) {
        this.second = second;
    }

}
