import java.util.function.Consumer;
import java.util.Comparator;
import java.util.Random;



public class Main {
    static Random random = new Random(123);

    public static String genString(){
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0123456789";
        String data = letters + digits;

        int length = random.nextInt(5);
        length +=5;
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int rnd = random.nextInt(data.length());
            char randomChar = data.charAt(rnd);
            stringBuilder.append(randomChar);
        }
        return stringBuilder.toString();
    }



    public static void main(String[] args) {
        List<String> list = new List<>();
        Consumer<String> printer = s -> System.out.print(s + " ");
        Comparator<String> comparator = (s1, s2) -> s1.compareToIgnoreCase(s2);

        List<Integer> list1 = new List<>();
        Consumer<Integer> printer1 = s -> System.out.print(s + " ");
        Comparator<Integer> comparator1 = (i1, i2) -> i1.compareTo(i2);

        for (int i = 0; i < 10; i++){
            String s = genString();
            list.pushBack(s);
            int l = random.nextInt(100);
            list1.pushBack(l);
        }
        list.forEach(printer);
        System.out.println();

        list.sort(comparator);

        list.forEach(printer);
        System.out.println();

        list1.forEach(printer1);
        System.out.println();

        list1.sort(comparator1);

        list1.forEach(printer1);
        System.out.println();
    }
}
