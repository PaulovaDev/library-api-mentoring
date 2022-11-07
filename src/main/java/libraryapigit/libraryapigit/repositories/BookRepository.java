package libraryapigit.libraryapigit.repositories;

import libraryapigit.libraryapigit.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
  // There is no need to call any method within the interface BookRepository, since they will be called on BookController.

}
