package vnu.hus.min.se152.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vnu.hus.min.se152.logging.Logging;
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
    @Logging
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }


    /**
     * This method adds a new user to the database.
     *
     * @param user The User object representing the new user.
     * @return The User object after being added to the database.
     */
    @Logging
    public User addUser(User user) {
        return userRepository.save(user);
    }

    /**
     * This method retrieves a user from the database based on their ID.
     *
     * @param userId The ID of the user to be retrieved.
     * @return The User object associated with the provided ID, or null if not found.
     */
    @Logging
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    /**
     * This method deletes a user from the database based on their ID.
     *
     * @param userId The ID of the user to be deleted.
     * @return True if the user is successfully deleted, false otherwise.
     */
    @Logging
    public boolean deleteUserById(Long userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    /**
     * This method updates a user in the database based on their ID.
     *
     * @param userId The ID of the user to be updated.
     * @param updatedUser The updated User object.
     * @return The User object after being updated, or null if the user with the provided ID is not found.
     */
    @Logging
    public User updateUserById(Long userId, User updatedUser) {
        if (userRepository.existsById(userId)) {
            updatedUser.setId(userId); // Ensure the ID of the updated user is set to the existing ID
            return userRepository.save(updatedUser);
        }
        return null; // User with the provided ID not found
    }


}
