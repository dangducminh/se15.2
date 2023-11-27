package vnu.hus.min.se152.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import vnu.hus.min.se152.model.User;
import vnu.hus.min.se152.repository.UserRepository;

import java.util.List;

/**
 * @author Minh Dang
 * @created 21/11/2023 - 12:06 AM
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * this function query all user from database
     * @return list all user
     */
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }


    /**
     * This method adds a new user to the database.
     *
     * @param user The User object representing the new user.
     * @return The User object after being added to the database.
     */
    public User addUser(User user) {
        return userRepository.save(user);
    }

    /**
     * This method retrieves a user from the database based on their ID.
     *
     * @param userId The ID of the user to be retrieved.
     * @return The User object associated with the provided ID, or null if not found.
     */
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
