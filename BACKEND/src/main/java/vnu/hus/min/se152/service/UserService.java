package vnu.hus.min.se152.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
}
