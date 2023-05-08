package com.nutouchh.EventAgency.services;

import com.nutouchh.EventAgency.dao.models.User;
import com.nutouchh.EventAgency.dao.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.security.Principal;

public class UserServiceTest {

    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        userService = new UserService(userRepository, passwordEncoder);
    }

    @Test
    public void testCreateUserReturnsTrueTest() {
        User user = new User();
        user.setEmail("test@test.com");
        user.setPassword("password");

        when(userRepository.findByEmail(user.getEmail())).thenReturn(null);
        when(passwordEncoder.encode(user.getPassword())).thenReturn("encodedPassword");

        assertTrue(userService.createUser(user));
    }

    @Test
    public void testCreateUserReturnsFalseTest() {
        User user = new User();
        user.setEmail("test@test.com");
        user.setPassword("password");

        when(userRepository.findByEmail(user.getEmail())).thenReturn(user);

        assertFalse(userService.createUser(user));
    }

    @Test
    public void testGetUserByPrincipalTest() {
        User user = new User();
        user.setEmail("test@test.com");

        Principal principal = () -> user.getEmail();

        when(userRepository.findByEmail(user.getEmail())).thenReturn(user);

        User result = (User) userService.getUserByPrincipal(principal);

        assertTrue(result.getEmail().equals(user.getEmail()));
    }

    @Test
    public void testGetUserByPrincipalEmptyTest() {
        User result = (User) userService.getUserByPrincipal(null);

        assertTrue(result.getEmail() == null);
    }
}
