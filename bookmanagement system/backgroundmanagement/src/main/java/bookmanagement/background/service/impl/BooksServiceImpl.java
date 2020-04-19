package bookmanagement.background.service.impl;

import bookmanagement.background.mapper.BooksMapper;
import bookmanagement.background.pojo.Books;
import bookmanagement.background.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
@Transactional
public class BooksServiceImpl implements BooksService {

    @Autowired
    private BooksMapper booksMapper;


    @Override
    public String addBooks(Books books) {
        // TODO Auto-generated method stub
        this.booksMapper.insertBooks(books);
        return "success!";
    }
    @Override
   public List<Books> showAllBooks(int a, int b) {
         int pageSize=b;
         int pageNumber=a;
         Map<String,Object> map = new HashMap<>();
         map.put("pageSize", pageSize);
         map.put("pageStart", pageSize*(pageNumber-1));
         return this.booksMapper.selectAllBooks(map);

     }
    @Override
    public String deleteBook(int id) {
        this.booksMapper.deleteBook(id);
        return "success!";
    }
    @Override
    public Books retrieve(int id) {
        return this.booksMapper.selectBooksById(id);
    }
    @Override
    public String updateBook (Books book) {
        this.booksMapper.updateBook(book);
        return "success!";
    }

    @Override
    public List<Books> test() {
        return this.booksMapper.test();
    }
}
