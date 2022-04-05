package pl.coderslab.book;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.publisher.PublisherDao;

@Controller
@RequestMapping("/book")
public class BookFormController {
    private final BookDao bookDao;
    private final PublisherDao publisherDao;

    public BookFormController(BookDao bookDao, PublisherDao publisherDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
    }


    @GetMapping("/add")
    public String bookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("publishers", publisherDao.findAll());
        return "bookAdd";
    }

    @PostMapping("/add")
    public String addBook(Book book) {
        bookDao.save(book);
        return "redirect:/book/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("books", bookDao.findAll());
        return "list";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable long id) {

        bookDao.delete(bookDao.findById(id));
        return "redirect:/book/list";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable long id, Model model) {
        model.addAttribute("book", bookDao.findById(id));
        model.addAttribute("publishers", publisherDao.findAll());
        return "edit";
    }

    @PostMapping("/update")
    public String updateAdd(Book book) {
        bookDao.update(book);
        return "redirect:/book/list";
    }

}
