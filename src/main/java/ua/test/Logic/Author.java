package ua.test.Logic;

import java.util.List;

/**
 * Created by Рома on 05.01.2017.
 */
public class Author {
    private long Id;
    private String name;
    private List<Book> books;

    public Author(long id, String name) {
        Id = id;
        this.name = name;
    }

    public Author(long id, String name, List<Book> books) {
        Id = id;
        this.name = name;
        this.books = books;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
