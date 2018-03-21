package P08_Book_Library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        List<Book> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] in = reader.readLine().split(" ");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

            Book b = new Book();
            b.setTitle(in[0]);
            b.setAuthor(in[1]);
            b.setPublisher(in[2]);
            b.setReleaseDate(LocalDate.parse(in[3], formatter));
            b.setBarcode(in[4]);
            b.setPrice(Double.parseDouble(in[5]));
            list.add(b);
        }
        Library lib = new Library("Library", list);

        // groups books in a map by their author and sums all prices
        Map<String, Double> result = lib
                .getBookList().stream()
                .collect(Collectors.groupingBy(Book::getAuthor,
                        Collectors.summingDouble(Book::getPrice)));

        //calls method {sortHash} which sorts the map descending by price
        //then ascending by author's name
        Map<String, Double> sorted = sortHash(result);

        //prints the Map.Entry
        for (String name:sorted.keySet()) {
            System.out.printf("%s -> %.2f%n",name, sorted.get(name));
        }
    }
    private static Map<String, Double> sortHash(Map<String, Double> map) {
        List<Map.Entry<String, Double>> list = new ArrayList<>(map.entrySet());

        // Sort list by integer values then by string keys
        Collections.sort(list, (a, b) -> {
            int cmp1 = b.getValue().compareTo(a.getValue());
            if (cmp1 != 0)
                return cmp1;
            else
                return a.getKey().compareTo(b.getKey());
        });

        Map<String, Double> result = new LinkedHashMap<>();
        for (Map.Entry<String, Double> entry : list)
            result.put(entry.getKey(), entry.getValue());

        return result;
    }

}
