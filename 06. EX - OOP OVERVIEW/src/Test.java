import java.util.*;
import java.util.stream.DoubleStream;

public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useLocale(Locale.ENGLISH);
        List<String> list = Arrays.asList("pesso gosho min daia stopper".split(" "));
        Collections.addAll(list, "one", "two");
        list.stream().forEach(s -> System.out.println(s));


//
//        DoubleStream doubleStream = list
//                .stream()
//                .mapToDouble(Double::parseDouble);
    }
}

