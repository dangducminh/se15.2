package vnu.hus.min.se152.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
