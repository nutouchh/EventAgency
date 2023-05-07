package com.nutouchh.EventAgency.services;

import com.nutouchh.EventAgency.models.Event;
import com.nutouchh.EventAgency.models.Image;
import com.nutouchh.EventAgency.models.User;
import com.nutouchh.EventAgency.repositories.EventRepository;
import com.nutouchh.EventAgency.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

class EventServiceTest {

    @Mock
    private EventRepository eventRepository;

    @Mock
    private UserRepository userRepository;

    private EventService eventService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        eventService = new EventService(eventRepository, userRepository);
    }

    @Test
    void getEventsWithTitleTest() {
        String title = "Test";
        List<Event> expectedEvents = new ArrayList<>();
        when(eventRepository.findEventByTitle(title)).thenReturn(expectedEvents);

        List<Event> actualEvents = eventService.getEvents(title);

        assertEquals(expectedEvents, actualEvents);
        verify(eventRepository).findEventByTitle(title);
        verifyNoMoreInteractions(eventRepository);
    }

    @Test
    void getEventsWithoutTitleTest() {
        List<Event> expectedEvents = new ArrayList<>();
        when(eventRepository.findAll()).thenReturn(expectedEvents);

        List<Event> actualEvents = eventService.getEvents(null);

        assertEquals(expectedEvents, actualEvents);
        verify(eventRepository).findAll();
        verifyNoMoreInteractions(eventRepository);
    }

    @Test
    void saveEventWithFileTest() throws IOException {
        Principal principal = mock(Principal.class);
        Event event = new Event();
        MultipartFile file = new MockMultipartFile("test.jpg", new byte[0]);
        Image image = new Image();
        when(eventRepository.save(event)).thenReturn(event);
        when(eventRepository.findById(event.getId())).thenReturn(java.util.Optional.of(event));

        eventService.saveEvent(principal, event, file);

        verify(eventRepository).save(event);
    }

    @Test
    void getUserByPrincipalTest() {
        Principal principal = mock(Principal.class);
        String email = "test@example.com";
        User expectedUser = new User();
        when(principal.getName()).thenReturn(email);
        when(userRepository.findByEmail(email)).thenReturn(expectedUser);

        Object actualUser = eventService.getUserByPrincipal(principal);

        assertEquals(expectedUser, actualUser);
        verify(userRepository).findByEmail(email);
        verifyNoMoreInteractions(userRepository);
    }

    @Test
    void deleteEventTest() {
        Long eventId = 1L;

        eventService.deleteEvent(eventId);

        verify(eventRepository).deleteById(eventId);
        verifyNoMoreInteractions(eventRepository);
    }

    @Test
    void getEventByIdTest() {
        Long eventId = 1L;
        Event expectedEvent = new Event();
        when(eventRepository.findById(eventId)).thenReturn(java.util.Optional.of(expectedEvent));

        Event actualEvent = eventService.getEventById(eventId);

        assertEquals(expectedEvent, actualEvent);
        verify(eventRepository).findById(eventId);
        verifyNoMoreInteractions(eventRepository);
    }

    @Test
    void getEventByIdWithNonExistingIdTest() {
        Long eventId = 1L;
        when(eventRepository.findById(eventId)).thenReturn(java.util.Optional.empty());

        Event actualEvent = eventService.getEventById(eventId);

        assertNull(actualEvent);
        verify(eventRepository).findById(eventId);
        verifyNoMoreInteractions(eventRepository);
    }
}
