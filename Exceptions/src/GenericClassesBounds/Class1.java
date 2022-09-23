package GenericClassesBounds;

 class Class1 {
     public static <T extends Comparable> Class111<T> minmax(T[] a){
        if(a==null || a.length==0) return null;
        T min = a[0];
        T max = a[0];
        for (int i =1; i<a.length; i++)
        {
            if (min.compareTo(a[i])>0) min=a[i];
            if (min.compareTo(a[i])<0) max=a[i];
         }
        return new Class111<>(min, max);
     }

}
