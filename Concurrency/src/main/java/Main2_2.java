import java.util.*;

public class Main2_2 {
    private static Collection<Double> collection = new Vector<>();
    private static StringBuffer stringBuilder = new StringBuffer();

    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>();
        HashMap<Integer,String> hashMap = new HashMap<>();
        Map<Integer, String> integerStringMap = Collections.synchronizedMap(hashMap);

        for (int i = 0; i < 100; i++) {
            threads.add(new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
//                    collection.add(Math.random());
//                    stringBuilder.append('a');
                    integerStringMap.put(j,"a");
                }
//                System.out.println(collection.size());
//                System.out.println(stringBuilder.length());
                System.out.println(hashMap.size());
            }));
        }
        threads.forEach(Thread::start);
    }
}
