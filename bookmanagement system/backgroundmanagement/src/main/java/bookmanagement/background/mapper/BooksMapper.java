package bookmanagement.background.mapper;

import bookmanagement.background.pojo.Books;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
@Component
@Mapper
public interface BooksMapper {
    void insertBooks(Books book);
    List<Books> selectAllBooks(Map fenpage);
    void deleteBook(int id);
    Books selectBooksById(int id);
    void updateBook(Books book);
    List<Books> test();

}
