package com.user;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.user.controller.UserController;
import com.user.exception.UserAlreadyExistsException;
import com.user.exception.UserNotFoundException;
import com.user.model.User;
import com.user.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@AutoConfigureMockMvc
@SpringBootTest
class UserInstaSellApplicationTests {

	@Mock
    private UserServiceImpl userService;

    @InjectMocks
    private UserController userController;

    private ResponseEntity<?> responseEntity;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveUserHandler_Success() throws UserAlreadyExistsException {
        // Prepare data
        User user = new User();
        user.setUserName("john.doe");
        user.setUserPassword("password");

        // Mock UserServiceImpl.saveUser() method
        when(userService.saveUser(user)).thenReturn(user);

        // Execute the controller method
        ResponseEntity<?> response = userController.saveUserHandler(user);

        // Verify the response
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    public void testSaveUserHandler_UserAlreadyExistsException() throws UserAlreadyExistsException {
        // Prepare data
        User user = new User();
        user.setUserName("john.doe");
        user.setUserPassword("password");

        // Mock UserServiceImpl.saveUser() method to throw UserAlreadyExistsException
        doThrow(UserAlreadyExistsException.class).when(userService).saveUser(user);

        // Execute the controller method and assert the exception
        assertThrows(UserAlreadyExistsException.class, () -> {
            userController.saveUserHandler(user);
        });
    }

    @Test
    public void testSaveUserHandler_InternalServerError() throws UserAlreadyExistsException {
        // Prepare data
        User user = new User();
        user.setUserName("john.doe");
        user.setUserPassword("password");

        // Mock UserServiceImpl.saveUser() method to throw an Exception
        doThrow(Exception.class).when(userService).saveUser(user);

        // Execute the controller method
        ResponseEntity<?> response = userController.saveUserHandler(user);

        // Verify the response
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Some internal error occurred..", response.getBody());
    }

    @Test
    public void testGetAllUsers_Success() {
        // Prepare data
        List<User> usersList = new ArrayList<>();
        usersList.add(new User("john.doe", "john", "cena", "password", "jh@gmail.com" ));
        usersList.add(new User("jane_sting", "john", "sting", "password", "js@gmail.com"));

        // Mock UserServiceImpl.getAllUsers() method
        when(userService.getAllUsers()).thenReturn(usersList);

        // Execute the controller method
        ResponseEntity<?> response = userController.getAllUsers();

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(usersList, response.getBody());
    }

    @Test
    public void testGetAllUsers_InternalServerError() {
        // Mock UserServiceImpl.getAllUsers() method to throw an Exception
        doThrow(Exception.class).when(userService).getAllUsers();

        // Execute the controller method
        ResponseEntity<?> response = userController.getAllUsers();

        // Verify the response
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Some internal error occurred..", response.getBody());
    }

    @Test
    public void testGetUserByName_Success() throws UserNotFoundException {
        // Prepare data
        String userName = "john.doe";
        User user = new User(userName, "new", "user", "password", "u@gm.com");

        // Mock UserServiceImpl.getUser() method
        when(userService.getUser(userName)).thenReturn(Optional.of(user));

        // Execute the controller method
        ResponseEntity<?> response = userController.getUserByName(userName);

        // Verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(Optional.of(user), response.getBody());
    }

    @Test
    public void testGetUserByName_InternalServerError() throws UserNotFoundException {
        // Prepare data
        String userName = "john.doe";

        // Mock UserServiceImpl.getUser() method to throw an Exception
        doThrow(Exception.class).when(userService).getUser(userName);

        // Execute the controller method
        ResponseEntity<?> response = userController.getUserByName(userName);

        // Verify the response
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Some internal error occurred..", response.getBody());
    }
}
