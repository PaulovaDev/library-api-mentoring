package libraryapigit.libraryapigit.repositories;

import libraryapigit.libraryapigit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  // There is no need to call any method within the interface UserRepository, since they will be called on UserController.

}
