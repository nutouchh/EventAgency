package com.nutouchh.EventAgency.services;

import com.nutouchh.EventAgency.dao.models.Event;
import com.nutouchh.EventAgency.dao.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;

    public List<Event> getEvents(String title) {
        log.info("Get event with title = {}", title);
        if (title != null) return eventRepository.findEventByTitle(title);
        log.info("There is no such event, get all events");
        return eventRepository.findAll();
    }

    public void saveEvent(Event event) {
        log.info("Saving new event {}", event.getTitle());
        eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        log.info("Delete event with ID = {}", id);
        eventRepository.deleteById(id);
    }

    public Event getEventById(Long id) {
        log.info("Get event with ID = {}", id);
        return eventRepository.findById(id).orElse(null);
    }
}
