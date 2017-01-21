package ua.test;

import ua.test.Logic.Author;
import ua.test.Logic.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Рома on 05.01.2017.
 */
public class BookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Book> books = new ArrayList<Book>();
        List<Author> authors = new ArrayList<Author>();
        authors.add(new Author(1L,"Roma Babiy"));
        authors.add(new Author(2L,"Ben Aflek"));
        authors.add(new Author(3L,"Key Hortsmann"));

        books.add(new Book(1L,"JSP"));
        books.add(new Book(2L,"JSF"));
        books.add(new Book(3L,"Servlets"));

        books.get(0).setAuthors(authors);
        books.get(0).getAuthors().remove(2);

        books.get(1).setAuthors(authors);
        books.get(1).getAuthors().remove(0);

        books.get(2).setAuthors(authors);
        books.get(2).getAuthors().remove(1);


        req.setAttribute("bookList",books);

        getServletContext().getRequestDispatcher("/books.jsp").forward(req,resp);

    }
}
