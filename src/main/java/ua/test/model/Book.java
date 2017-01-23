package ua.test.model;

import java.util.List;

/**
 * Created by Рома on 05.01.2017.
 */
public class Book {
    private long id;
    private String name;
    private List<Author> authors;

    public Book(long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Book() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
