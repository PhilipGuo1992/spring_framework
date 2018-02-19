package yunfei.springframework.sprint5webapp.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import yunfei.springframework.sprint5webapp.repositories.BookRepository;

@Controller
public class BookController {

    private BookRepository bookRepository;

    // dependent injection
    // spring will automatically inject bookRepository for you.
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){

        // tell spring data JPA: Find all book from database
        // under the hood: it uses Hibernate to handle database
        model.addAttribute("books", bookRepository.findAll());

        return "books";
    }
}
