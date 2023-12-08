package vnu.hus.min.se152.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vnu.hus.min.se152.model.User;
import vnu.hus.min.se152.service.UserService;

import java.util.List;

/**
 * @author Minh Dang
 * @created 21/11/2023 - 12:05 AM
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * define api get all user from database
     * @return
     */
    @GetMapping(value = "/get-all-users")
    public ResponseEntity<List<User>> testApi(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }


    @PostMapping(value = "/add-user")
    public ResponseEntity<User> addUser(@RequestBody User newUser) {
        User addedUser = userService.addUser(newUser);
        return new ResponseEntity<>(addedUser, HttpStatus.CREATED);
    }

    @GetMapping("/get-user/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        User user = userService.getUserById(userId);

        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/delete-user/{userId}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long userId) {
        boolean deleted = userService.deleteUserById(userId);

        if (deleted) {
            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update-user/{userId}")
    public ResponseEntity<User> updateUserById(@PathVariable Long userId, @RequestBody User updatedUser) {
        User existingUser = userService.getUserById(userId);

        if (existingUser != null) {
            updatedUser.setId(userId);
            User updatedUserResult = userService.updateUserById(userId, updatedUser);
            return new ResponseEntity<>(updatedUserResult, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
