package libraryapigit.libraryapigit.controllers;

import java.util.List;
import java.util.Optional;
import libraryapigit.libraryapigit.model.User;
import libraryapigit.libraryapigit.repositories.UserRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  //receiving a UserRepository object through dependency injection
  private UserRepository userRepository;

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @RequestMapping(value = "/users", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody User registerNewUser(@RequestBody User newUser) {
    return userRepository.save(newUser);
  }

  @RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody List<User> getAllUsers() {
    List<User> listOfAllUsers = userRepository.findAll();

    return listOfAllUsers;
  }

  @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody Optional<User> getUserById(@PathVariable String id) {

    long userId = Long.parseLong(id);

    Optional<User> user = userRepository.findById(userId);

    return user;

  }

}
