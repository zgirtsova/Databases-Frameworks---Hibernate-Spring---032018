package P08_Book_Library_Best_Solution_Ever;

import java.util.*;

public class Library {
    private String name;
    private List<Book> books;
    Map<String, Double> moneyByAuthor;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
        this.moneyByAuthor = new TreeMap<>();
    }

    public String getName() {
        return name;
    }

    public Iterator<Book> getBooks() {
        return this.books.iterator();
    }
    public void addBook(Book book) {
        this.books.add(book);
        this.moneyByAuthor.putIfAbsent(book.getAuthor(), 0d);
        this.moneyByAuthor.put(book.getAuthor(), this.moneyByAuthor.get(book.getAuthor()) + book.getPrice());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.moneyByAuthor
                .entrySet()
                .stream()
                .sorted((a1,a2) -> Double.compare(a2.getValue(), a1.getValue()))
                .forEach(e -> {
                    String inp = String.format("%s -> %.2f", e.getKey(), e.getValue());
                    sb.append(inp).append(System.lineSeparator());
                });
        return sb.toString().trim();
    }
}
