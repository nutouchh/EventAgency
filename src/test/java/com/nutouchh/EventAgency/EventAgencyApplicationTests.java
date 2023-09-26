package com.nutouchh.EventAgency;

import com.nutouchh.EventAgency.controllers.ActionController;
import com.nutouchh.EventAgency.controllers.EventController;
import com.nutouchh.EventAgency.dao.models.Action;
import com.nutouchh.EventAgency.dao.models.Event;
import com.nutouchh.EventAgency.dao.repositories.ActionRepository;
import com.nutouchh.EventAgency.dao.repositories.EventRepository;
import com.nutouchh.EventAgency.services.ActionService;
import com.nutouchh.EventAgency.services.CallbackService;
import com.nutouchh.EventAgency.services.EventService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Transactional
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@TestPropertySource(locations = "classpath:application.properties")
public class EventAgencyApplicationTests {
    @Autowired
    private EventService eventService;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private EventController eventController;

    @Autowired
    private ActionService actionService;
    @Autowired
    private ActionRepository actionRepository;
    @Autowired
    private ActionController actionController;

    @Test
    public void testSaveEvent() {
        String title = "testCreateEvent";
        Event event1 = new Event(1L, title, "testCreateEvent", new LinkedList<Action>());

        eventService.saveEvent(event1);

        Assertions.assertEquals(event1, eventRepository.findEventByTitle(title).get(0));
    }

    @Test
    public void testCreateEvent() {
        Event event1 = new Event(1L, "1", "2", new LinkedList<Action>());
        String response = eventController.createEvent(event1);

        Assertions.assertEquals(response, "redirect:/create/event/success");
    }

    @Test
    public void testDeleteEvent() {
        String title = "testDeleteEvent";
        Long id = 1L;
        Event event1 = new Event(id, title, "testDeleteEvent", new LinkedList<Action>());
        eventService.saveEvent(event1);

        eventRepository.deleteById(id);

        long count = eventRepository.count();
        Assertions.assertEquals(0, count);

        List<Event> events = eventRepository.findEventByTitle(title);
        Assertions.assertTrue(events.isEmpty());
    }

    @Test
    public void testBadGetEventById() {
        String title = "testBadGetEventById";
        Long id = 5L;
        Event event1 = new Event(id, title, "testBadGetEventById", new LinkedList<Action>());
        eventService.saveEvent(event1);

        Assertions.assertEquals(Optional.empty(), eventRepository.findById(123L));
    }

    @Test
    public void testGoodGetEventById() {
        String title = "testGoodGetEventById";
        Long id = 1L;
        Event event1 = new Event(id, title, "testGoodGetEventById", new LinkedList<Action>());
        eventService.saveEvent(event1);

        Assertions.assertEquals(event1, eventRepository.findById(id).get());
    }

    @Test
    public void TestGetAllActions() {
        Event event = new Event(1L, "event1", "des123", new LinkedList<Action>());
        eventRepository.save(event);
        List<Action> actionList = new ArrayList<>();
        Action action1 = new Action(2L, "Title1", "Description1", 12345, event);
        Action action2 = new Action(3L, "Title2", "Description2", 12345, event);
        actionRepository.save(action1);
        actionRepository.save(action2);
        actionList.add(action1);
        actionList.add(action2);

        Assertions.assertEquals(actionList, actionService.getActions(null));
    }

    @Test
    public void TestGetOneActions() {
        Event event = new Event(1L, "event1", "des123", new LinkedList<Action>());
        eventRepository.save(event);
        List<Action> actionList = new ArrayList<>();
        Action action1 = new Action(2L, "Title1", "Description1", 12345, event);
        Action action2 = new Action(3L, "Title2", "Description2", 12345, event);
        actionRepository.save(action1);
        actionRepository.save(action2);
        actionList.add(action1);
        actionList.add(action2);

        Assertions.assertEquals(action1, actionService.getActions("Title1").get(0));
    }

    @Test
    public void testSaveAction() {
        String title = "testSaveAction";
        Event event = new Event(1L, "event1", "des123", new LinkedList<Action>());
        eventRepository.save(event);
        Action action = new Action(2L, title, "Description1", 12345, event);
        actionRepository.save(action);

        Assertions.assertEquals(action, actionRepository.findActionByTitle(title).get(0));
    }

    @Test
    public void testDeleteAction() {
        String title = "testDeleteAction";
        Action action = new Action(2L, title, "Description1", 12345, new Event());
        actionRepository.save(action);
        actionRepository.deleteById(2L);

        long count = actionRepository.count();
        Assertions.assertEquals(0, count);

        List<Action> actions = actionRepository.findActionByTitle(title);
        Assertions.assertTrue(actions.isEmpty());

    }

    @Test
    public void testBadGetActionById() {
        String title = "testBadGetActionById";
        Long id = 5L;
        Action action = new Action(id, title, "Description1", 12345, new Event());
        actionRepository.save(action);

        Assertions.assertEquals(Optional.empty(), actionRepository.findById(123L));
    }
}