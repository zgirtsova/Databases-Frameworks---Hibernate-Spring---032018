package P08_Book_Library_Best_Solution_Ever;

import java.time.LocalDate;
import java.util.Date;

public class Book {
    private String title;
    private String author;
    private String publisher;
    private String releaseDate;
    private String ISBN;
    private double price;

    public Book() {
    }

    public Book(String title, String author, String publisher, String releaseDate, String ISBN, double price) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
        this.ISBN = ISBN;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getISBN() {
        return ISBN;
    }

    public double getPrice() {
        return price;
    }
}
