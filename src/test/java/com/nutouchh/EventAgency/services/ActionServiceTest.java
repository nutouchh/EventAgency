package com.nutouchh.EventAgency.services;

import com.nutouchh.EventAgency.models.Action;
import com.nutouchh.EventAgency.repositories.ActionRepository;
import com.nutouchh.EventAgency.repositories.EventRepository;
import com.nutouchh.EventAgency.repositories.UserRepository;
import com.nutouchh.EventAgency.services.ActionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ActionServiceTest {

    @Mock
    private ActionRepository actionRepository;

    private ActionService actionService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        actionService = new ActionService(actionRepository, null, null); // Внедрение Logger через конструктор
    }

    @Test
    void getActionsTest() {
        String title = "Test";
        List<Action> expectedActions = Arrays.asList(new Action(), new Action());
        when(actionRepository.findActionByTitle(title)).thenReturn(expectedActions);

        List<Action> actualActions = actionService.getActions(title);

        assertEquals(expectedActions, actualActions);
        verify(actionRepository).findActionByTitle(title);
    }

    @Test
    void getActionsWithoutTitleTest() {
        List<Action> expectedActions = Arrays.asList(new Action(), new Action());
        when(actionRepository.findAll()).thenReturn(expectedActions);

        List<Action> actualActions = actionService.getActions(null);

        assertEquals(expectedActions, actualActions);
        verify(actionRepository).findAll();
    }
}
