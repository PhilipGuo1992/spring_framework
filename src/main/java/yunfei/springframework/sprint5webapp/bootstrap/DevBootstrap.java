package yunfei.springframework.sprint5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import yunfei.springframework.sprint5webapp.model.Author;
import yunfei.springframework.sprint5webapp.model.Book;
import yunfei.springframework.sprint5webapp.model.Publisher;
import yunfei.springframework.sprint5webapp.repositories.AuthorRepository;
import yunfei.springframework.sprint5webapp.repositories.BookRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{


    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData() {
        // James
        Author james = new Author("James", "Harden");
        Publisher pp = new Publisher();
        pp.setName("Harper");
        Book jjd = new Book("See you tomorrow", "2341", pp);
       // add book to the author
        james.getBooks().add(jjd);
        jjd.getAuthors().add(james);

        // this is based on: DDD- domain driven design
        // find that book, and read it.

        // you need to save publisher first, then save book.
        // otherwise, it will get error
        publisherRepository.save(pp);

        authorRepository.save(james);
        bookRepository.save(jjd);

        // Scott
        Author scott = new Author("Scott", "Millett");
        Publisher plis = new Publisher();
        plis.setName("Nick");
        Book sss = new Book("Patterns, Principles, and Practice of DDD", "12332", plis);
        scott.getBooks().add(sss);
        sss.getAuthors().add(scott);

        publisherRepository.save(plis);

        authorRepository.save(scott);
        bookRepository.save(sss);



    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
