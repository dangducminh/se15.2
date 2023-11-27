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
}
