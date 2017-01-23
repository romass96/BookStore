package ua.test.dao;


import ua.test.model.Author;
import ua.test.model.Book;

import java.util.List;

/**
 * Created by Рома on 23.01.2017.
 */
public interface Dao {
    public List<Book> getBooksByAuthor(String author);
    public List<Author> getAuthorsByBook(String book);
}
