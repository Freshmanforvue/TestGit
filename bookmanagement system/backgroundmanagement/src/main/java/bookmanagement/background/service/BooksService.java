package bookmanagement.background.service;

import bookmanagement.background.mapper.BooksMapper;
import bookmanagement.background.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
//@Repository
//@Component
public interface BooksService {


    String addBooks(Books books);
    List<Books> showAllBooks(int a ,int b);
    String deleteBook(int id);
    Books retrieve(int id);
    String updateBook(Books book);
    List<Books> test();
}
