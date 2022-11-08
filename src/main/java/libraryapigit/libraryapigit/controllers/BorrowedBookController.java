package libraryapigit.libraryapigit.controllers;

import java.util.List;
import java.util.Optional;
import libraryapigit.libraryapigit.model.BorrowedBook;
import libraryapigit.libraryapigit.repositories.BorrowedBookRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BorrowedBookController {

  private BorrowedBookRepository borrowedBookRepository;

  public BorrowedBookController(BorrowedBookRepository borrowedBookRepository) {
    this.borrowedBookRepository = borrowedBookRepository;
  }

  @RequestMapping(value = "/borrowed-books", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody BorrowedBook registerNewBorrowedBook(@RequestBody BorrowedBook newBorrowedBook) {
    return borrowedBookRepository.save(newBorrowedBook);
  }

  @RequestMapping(value = "/borrowed-books", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody List<BorrowedBook> getBorrowedBooks() {
    List<BorrowedBook> listOfBorrowedBooks = borrowedBookRepository.findAll();

    return listOfBorrowedBooks;
  }

  @RequestMapping(value = "/borrowed-books/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody Optional<BorrowedBook> getBorrowedBookById(@PathVariable String id) {

    long borrowedBookId = Long.parseLong(id);

    Optional<BorrowedBook> borrowedBook = borrowedBookRepository.findById(borrowedBookId);

    return borrowedBook;
  }
}
