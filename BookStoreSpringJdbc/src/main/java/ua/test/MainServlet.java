package ua.test;

import ua.test.Logic.Author;
import ua.test.Logic.Book;
import ua.test.Logic.BooksDAO;

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
public class MainServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int answer = checkAction(req);
        if(answer==1){
            String findAuthor=req.getParameter("author");
            BooksDAO dao= new BooksDAO();
            List<Book> books=dao.getBooksByAuthor(findAuthor);
            req.setAttribute("bookList",books);
            getServletContext().getRequestDispatcher("/books.jsp").forward(req,resp);
        }
        if (answer==2){
            String findBook=req.getParameter("book");
            BooksDAO dao= new BooksDAO();
            List<Author> authors=dao.getAuthorsByBook(findBook);
            req.setAttribute("authorList",authors);
            getServletContext().getRequestDispatcher("/authors.jsp").forward(req,resp);

        }
        getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req,resp);
    }

    public int checkAction(HttpServletRequest request){
        if(request.getParameter("getBooks")!=null) {return 1;}
        if (request.getParameter("getAuthors")!=null) return 2;
        return 0;

    }
}
