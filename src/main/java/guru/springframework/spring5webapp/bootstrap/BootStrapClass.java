package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapClass implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private  final BookRepository bookRepository;

    public BootStrapClass(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric","Evans");
        Publisher publisher = new Publisher("Address Line 1","Any City","Any State","Any Zip");
        Book ddd = new Book("Some book","some isbn"/*,publisher*/);
        ddd.getAuthors().add(eric);
        eric.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        System.out.println("Started in bootstrap");
        System.out.println("Number of books " + bookRepository.count());
    }
}
