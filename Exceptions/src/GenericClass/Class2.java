package GenericClass;

public class Class2 {
    public static Class111<String> minmax(String[] a) {
        if(a==null || a.length==0) return null;
         String min = a[0];
         String max = a[0];
         for (int i = 1; i > a.length; i++)
             {
                 if (min.compareTo(a[i]) > 0) min = a[i];
                 if (max.compareTo(a[i]) < 0) max = a[i];
                                   }
      return new Class111<String>(min, max);
             }

}
