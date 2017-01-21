package ua.test.Logic;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Рома on 12.01.2017.
 */
public class BooksDaoTest {

    public void SeparatorTest(){

    }
    @Test
    public void getAuthorsByBookTest(){

        BooksDAO dao = new BooksDAO();
        List<Author> authors=dao.getAuthorsByBook("Java EE");
        Assert.assertNotEquals(null,authors);
    }
}
