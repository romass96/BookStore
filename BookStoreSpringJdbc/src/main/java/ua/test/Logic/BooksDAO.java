package ua.test.Logic;

import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.springframework.jdbc.core.RowMapper;

/**
 * Created by Рома on 05.01.2017.
 */
public class BooksDAO {
    private ApplicationContext context;
    private JdbcTemplate jdbc;
    private static final Logger log = LoggerFactory.getLogger(BooksDAO.class);

    public BooksDAO() {
        context = new ClassPathXmlApplicationContext(new String[]{"springContext.xml"});
        jdbc = context.getBean("jdbcTemplate", JdbcTemplate.class);
    }
    private  void separator(String title) {
        log.debug("\r\n\r\n\r\n\r\n");
        log.debug("========== {} ==========", title);
        log.debug("");
    }

    public  List<Author> getAuthorsByBook( String book) {
            separator("getAuthorsByBook");
            List<Author> authors = jdbc.query("SELECT id, name, book FROM authors WHERE book=?",new String[]{book},
                    new RowMapper<Author>() {
                        public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
                            Author author = new Author();
                            author.setId(rs.getInt("id"));
                            author.setName(rs.getString("name"));
                            return author;
                        }
                    });
        for (final Author author : authors) {
            List<Book> books = jdbc.query("SELECT id ,name ,author FROM books WHERE author=?", new String[]{author.getName()}, new RowMapper<Book>() {
                public Book mapRow(ResultSet rs, int i) throws SQLException {
                    return new Book(rs.getInt("id"), rs.getString("name"));
                }
            });
            author.setBooks(books);
        }
            for (Author r : authors) {
                log.debug("Author: id: {}, name: {}", r.getId(), r.getName());
            }

        return authors;
    }

    public  List<Book> getBooksByAuthor( String author) {
        separator("getBooksByAuthor");
        List<Book> books = jdbc.query("SELECT id ,name ,author FROM books WHERE author=?",new String[]{author},
                new RowMapper<Book>() {
                    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Book book = new Book();
                        book.setId(rs.getInt("id"));
                        book.setName(rs.getString("name"));
                        return book;
                    }
                });
        for (final Book book : books) {
            List<Author> authors = jdbc.query("SELECT id, name, book FROM authors WHERE book=?", new String[]{book.getName()}, new RowMapper<Author>() {
                public Author mapRow(ResultSet rs, int i) throws SQLException {
                    return new Author(rs.getInt("id"), rs.getString("name"));
                }
            });
            book.setAuthors(authors);
        }
        for (Book b : books) {
            log.debug("Book: id: {}, name: {}", b.getId(), b.getName());
        }

        return books;
    }



}

