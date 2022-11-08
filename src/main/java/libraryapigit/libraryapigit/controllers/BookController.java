package libraryapigit.libraryapigit.controllers;

import java.util.List;
import java.util.Optional;
import libraryapigit.libraryapigit.model.Book;
import libraryapigit.libraryapigit.repositories.BookRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

  //receiving a BookRepository object through dependency injection
  private BookRepository bookRepository;

  public BookController(BookRepository bookRepository) {
    this.bookRepository = bookRepository;

  }
  @RequestMapping(value = "/books", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody Book registerNewBook(@RequestBody Book newBook) {
    return bookRepository.save(newBook);
  }

  @RequestMapping(value = "/books", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody List<Book> getAllBooks() {
    List<Book> listOfAllBooks = bookRepository.findAll();

    return listOfAllBooks;
  }

  @RequestMapping(value = "/books/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody Optional<Book> getBookById(@PathVariable String id) {

    long bookId = Long.parseLong(id);

    Optional<Book> book = bookRepository.findById(bookId);

    return book;
  }

  @RequestMapping(value = "/books/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody Optional<Book> updateBookById(@PathVariable String id, @RequestBody Book newBookDetails) {

    long bookId = Long.parseLong(id);

    return bookRepository.findById(bookId).map(book-> {
      book.setTitle(newBookDetails.getTitle());
      book.setAuthor(newBookDetails.getAuthor());
      book.setCopiesAvailable(newBookDetails.getCopiesAvailable());
      book.setCopiesBorrowed(newBookDetails.getCopiesBorrowed());

      return bookRepository.save(book);
    });

  }

  @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
  public void deleteBookById(@PathVariable String id) {

    long bookId = Long.parseLong(id);

    bookRepository.deleteById(bookId);
  }






}
