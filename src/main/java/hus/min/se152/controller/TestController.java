package hus.min.se152.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author Minh Dang
 * @created 01/11/2023 - 7:35 PM
 */
@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping(value = "/hello-word")
    public ResponseEntity<String> testApi(){
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }
}
