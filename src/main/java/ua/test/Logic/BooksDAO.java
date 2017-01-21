package ua.test.Logic;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Рома on 05.01.2017.
 */
public class BooksDAO {
    private static Connection conn = null;
    private static String URL = "jdbc:mysql://localhost:3306/bookStore";

    public static void getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Author> initAuthors(List<Author> authors){
        for (Author a: authors){
            a.setBooks(getBooksByAuthor(a.getName()));
        }
        return authors;
    }

    public static List<Book> initBooks(List<Book> books){
        for (Book b: books){
            b.setAuthors(getAuthorsByBook(b.getName()));
        }
        return books;
    }

    public static List<Author> getAuthorsByBook(String book) {
        getConnection();
        List<Author> authors = new ArrayList<Author>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = conn.prepareStatement("SELECT id, name, book FROM authors WHERE book=?");
            statement.setString(1,book);
            resultSet=statement.executeQuery();
            while (resultSet.next()) {
                authors.add(new Author(resultSet.getInt(1), resultSet.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return authors;
    }

    public static List<Book> getBooksByAuthor(String author) {
        getConnection();
        List<Book> books = new ArrayList<Book>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = conn.prepareStatement("SELECT id ,name ,author FROM books WHERE author=?");
            statement.setString(1,author);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                books.add(new Book(resultSet.getInt(1), resultSet.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return books;
    }
}

