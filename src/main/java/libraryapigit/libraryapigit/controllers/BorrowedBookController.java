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

  // user and book should be modified from their controllers. Might delete later
  @RequestMapping(value = "/borrowed-books/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody Optional<BorrowedBook> updateBorrowedBookById(@PathVariable String id, @RequestBody BorrowedBook newBorrowedBookDetails) {

    long borrowedBookId = Long.parseLong(id);

    return borrowedBookRepository.findById(borrowedBookId).map(borrowedBook -> {

      borrowedBook.setUser(newBorrowedBookDetails.getUser());
      borrowedBook.setBook(newBorrowedBookDetails.getBook());

      return borrowedBookRepository.save(borrowedBook);
    });
  }

  @RequestMapping(value = "/borrowed-books/{id}", method = RequestMethod.DELETE)
  public void deleteBorrowedBookById(@PathVariable String id) {

    long borrowedBookId = Long.parseLong(id);

    borrowedBookRepository.deleteById(borrowedBookId);

  }

}
