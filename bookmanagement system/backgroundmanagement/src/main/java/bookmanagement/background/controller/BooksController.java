package bookmanagement.background.controller;

import bookmanagement.background.pojo.Books;
import bookmanagement.background.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
@Primary
public class BooksController  implements BooksService{

@Autowired
private BooksService work;
    @Override
    @RequestMapping(value="/add", method = RequestMethod.POST)
public String addBooks(@RequestBody Books book){

        return this.work.addBooks(book);
}


   /* @RequestMapping("/add")
    public String addBooks1() {
       Books b=new Books();
       b.setBookname("给大忙人看的快乐佛法书");
       b.setAuthor("九戒居士");
       b.setPrice((float) 23.3);

      return this.work.addBooks(b);
    }*/

   @Override
@RequestMapping("/findAll/{page}/{size}")
    @ResponseBody
    public List<Books> showAllBooks(@PathVariable("page")int page , @PathVariable("size") int size){
    int a=page;
    int b=size;

        List<Books> l1;
    l1=this.work.showAllBooks(a, b);
    System.out.println(l1.get(1));
        return l1;
    }

    @Override
    @RequestMapping(value="/delete/{id}",method = RequestMethod.POST)
    public String deleteBook(@PathVariable int id) {
       this.work.deleteBook(id);
        return "success!";
    }

    @Override
    @RequestMapping("/retrieve/{id}")
    public Books retrieve(@PathVariable int id) {
        return this.work.retrieve(id);
    }

    @Override
    @RequestMapping(value="/update",method = RequestMethod.POST)
    public String updateBook(@RequestBody Books book) {
this.work.updateBook(book);
return "success!";
    }

    @Override
    @ResponseBody
    @RequestMapping("/see")
    public List<Books> test() {
      System.out.println("测试方法被调用！");
        return this.work.test();
    }

}
