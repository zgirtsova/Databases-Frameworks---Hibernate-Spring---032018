package LAB;


import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P08_Book_Store {
    public static void main(String[] args) {
        Stream<Book> books = Stream.of(
                new Book("Vinetu3", 20.00, "Karl Mai"),
                new Book("Vinetu1", 20.00, "Karl Mai"),
                new Book("Vinetu2", 15.00, "Karl Mai"),
                new Book("Sherlock Holmes", 12.00, "Arthur C. Doyl"),
                new Book("The Lost World", 43.00, "Arthur C. Doyl"));

        // превръща Stream books в Map чрез collect.Collectors....etc.
        Map<String,Double> map = books.collect(
                Collectors.groupingBy(Book::getAuthor,
                Collectors.summingDouble(Book::getPrice)));

             map.entrySet()
                .stream()
                //.sorted(Comparator.comparing(Map.Entry<String, Double>::getValue)
                //.reversed()
                //.thenComparing(Map.Entry::getKey))
                .sorted(Map.Entry.<String, Double>comparingByValue()
                        .reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                // горните три реда правят едно и също
                .forEach(System.out::println);

    }
}
class Book {
    private String author;
    private Double price;
    private String name;

    public Book(String name, Double price, String author) {
        this.author = author;
        this.price = price;
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
