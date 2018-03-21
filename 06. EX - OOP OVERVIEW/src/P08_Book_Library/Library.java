package P08_Book_Library;

import java.util.List;

public class Library {
    public Library(String name, List<Book> bookList) {
        this.name = name;
        this.bookList = bookList;
    }

    public Library() {
    }

    private String name;
    private List<Book> bookList;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBookList() {
        return bookList;
    }
    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
