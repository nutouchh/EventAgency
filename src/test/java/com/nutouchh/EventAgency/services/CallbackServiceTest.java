package com.nutouchh.EventAgency.services;


import com.nutouchh.EventAgency.models.User;
import com.nutouchh.EventAgency.repositories.UserRepository;
import com.nutouchh.EventAgency.services.CallbackService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.security.Principal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CallbackServiceTest {

    @Mock
    private JavaMailSender mailSender;

    @Mock
    private UserRepository userRepository;

    private CallbackService callbackService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        callbackService = new CallbackService(mailSender, userRepository);
    }

    @Test
    void sendMessageTest() {
        String to = "recipient@example.com";
        String subject = "Test Subject";
        String text = "Test Message";

        callbackService.sendMessage(to, subject, text);

        verify(mailSender).send(any(SimpleMailMessage.class));
    }

    @Test
    void getUserByPrincipalTest() {
        Principal principal = mock(Principal.class);
        String email = "test@example.com";
        User expectedUser = new User();
        when(principal.getName()).thenReturn(email);
        when(userRepository.findByEmail(email)).thenReturn(expectedUser);

        Object actualUser = callbackService.getUserByPrincipal(principal);

        assertEquals(expectedUser, actualUser);
        verify(principal).getName();
        verify(userRepository).findByEmail(email);
        verifyNoMoreInteractions(principal, userRepository);
    }
}
