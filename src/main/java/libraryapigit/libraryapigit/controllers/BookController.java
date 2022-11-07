package libraryapigit.libraryapigit.controllers;

import java.util.ArrayList;
import java.util.List;
import libraryapigit.libraryapigit.model.Book;
import libraryapigit.libraryapigit.repositories.BookRepository;
import org.springframework.http.MediaType;
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




}
