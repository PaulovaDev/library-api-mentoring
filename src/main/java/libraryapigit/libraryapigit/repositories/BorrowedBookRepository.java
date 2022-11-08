package libraryapigit.libraryapigit.repositories;

import libraryapigit.libraryapigit.model.BorrowedBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowedBookRepository extends JpaRepository<BorrowedBook, Long> {
  // There is no need to call any method within the interface UserRepository, since they will be called on UserController.

}
