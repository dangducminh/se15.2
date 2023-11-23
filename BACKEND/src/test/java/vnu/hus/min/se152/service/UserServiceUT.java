package vnu.hus.min.se152.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import vnu.hus.min.se152.model.User;
import vnu.hus.min.se152.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Minh Dang
 * @created 23/11/2023 - 11:24 PM
 */

@ExtendWith(MockitoExtension.class)
public class UserServiceUT {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    void given2RecordUserInDB_whenCallFindAll_thenReturnAllDataInDB() {
        // 1. create mock data
        List<User> mockUser = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            mockUser.add(new User());
        }

        // 2. define behavior of Repository
        when(userRepository.findAll()).thenReturn(mockUser);

        // 3. call service method
        List<User> actualBooks = userService.getAllUsers();

        // 4. assert the result
        assertThat(actualBooks.size()).isEqualTo(mockUser.size());

        // 4.1 ensure repository is called
        verify(userRepository).findAll();
    }

    @Test
    void given0RecordUserInDB_whenCallFindAll_thenReturnEmptyData() {
        // 1. create mock data
        List<User> mockUser = new ArrayList<>();

        // 2. define behavior of Repository
        when(userRepository.findAll()).thenReturn(mockUser);

        // 3. call service method
        List<User> actualBooks = userService.getAllUsers();

        // 4. assert the result
        assertThat(actualBooks.size()).isEqualTo(mockUser.size());

        // 4.1 ensure repository is called
        verify(userRepository).findAll();
    }
}