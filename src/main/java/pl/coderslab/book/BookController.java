//package pl.coderslab.book;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import pl.coderslab.author.Author;
//import pl.coderslab.author.AuthorDao;
//import pl.coderslab.publisher.Publisher;
//import pl.coderslab.publisher.PublisherDao;
//import java.util.logging.Logger;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//public class BookController {
//
//    private final BookDao bookDao;
//    private final PublisherDao publisherDao;
//    private final AuthorDao authorDao;
//
//    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
//        this.bookDao = bookDao;
//        this.publisherDao = publisherDao;
//        this.authorDao = authorDao;
//    }
//
//
//
//    @ResponseBody
//    @GetMapping("/save/{id}/{id2}")
//    public String save(@PathVariable long id, @PathVariable long id2) {
//        Book book = new Book();
//        book.setTitle("Tinking in JAva");
//        Publisher build = Publisher.builder().name("Helion").street("Pułtuska").number("90").build();
//        publisherDao.save(build);
//        book.setPublisher(build);
//
//
//        Author author1=authorDao.findById(id);
//        Author author2=authorDao.findById(id2);
//
//        List<Author> authors = new ArrayList<>();
//        authors.add(author1);
//        authors.add(author2);
//       // book.setAuthors(authors);
//
//        bookDao.save(book);
//        return "danke";
//
//    }
////
////    @RequestMapping("/book/get/{id}")
////    @ResponseBody
////    public String getBook(@PathVariable long id) {
////        Book book = bookDao.findById(id);
////     return book.toString();
////    }
//
////
////    @RequestMapping("/book/update/{id}/{title}")
////    @ResponseBody
////    public String updateBook(@PathVariable long id, @PathVariable String title) {
////        Book book = bookDao.findById(id);
////        book.setTitle(title);
////        bookDao.update(book);
////        return book.toString();
////    }
//
//    @RequestMapping("/book/delete/{id}")
//    @ResponseBody
//    public String deleteBook(@PathVariable long id) {
//        Book book = bookDao.findById(id);
//        bookDao.delete(book);
//        return "deleted";
//    }
//
//    @RequestMapping("/book/all")
//    @ResponseBody
//    public String findAll() {
//        Logger logger = Logger.getGlobal();
//        List<Book> all = bookDao.findAll();
//        all.forEach(b -> logger.info(b.toString()));
//
//        return "findAll";
//    }
//
//}
