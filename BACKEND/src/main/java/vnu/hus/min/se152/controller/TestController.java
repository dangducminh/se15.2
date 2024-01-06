package vnu.hus.min.se152.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Minh Dang
 * @created 12/11/2023 - 9:46 AM
 */
@RestController
@RequestMapping("/api")
public class TestController {
    @GetMapping(value = "/hello-world")
    public ResponseEntity<String> testApi(){
        return new ResponseEntity<>("Hello World6", HttpStatus.OK);
    }
}
