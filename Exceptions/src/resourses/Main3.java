package resourses;

public class Main3 {
    public static void main(String[] args)/* throws Exception */{

        try {
            wraps();
        }catch (Exception e){
            e.printStackTrace();
            Throwable[] supressed = e.getSuppressed();
        }
    }
    public static void wraps() throws Exception {
           /* try (Class3 one = new Class3("ONE", true);
                 Class3 two = new Class3("TWO", false)) {

                one.doStuff(true);
                two.doStuff(false);
            } catch (Exception e) {
                e.printStackTrace();
                Throwable[] suppressed = e.getSuppressed();
                System.out.println(suppressed);
            }*/
            try (Class3 one = new Class3("ONE", true);
                 Class3 two = new Class3("TWO", false)) {

                one.doStuff(true);
                two.doStuff(false);
            } catch (Exception e) {
                Throwable[] suppressed = e.getSuppressed();
                throw e;
            }
            finally {
                throw new Exception("FINAL DESTINATION!");/**DISREGARD ALL OTHER EXCEPTIONS FROM CATCH AND TRY*/
            }
        }
    }
