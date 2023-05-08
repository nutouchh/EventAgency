package com.nutouchh.EventAgency.services;

import com.nutouchh.EventAgency.dao.models.Event;
import com.nutouchh.EventAgency.dao.models.Image;
import com.nutouchh.EventAgency.dao.models.User;
import com.nutouchh.EventAgency.dao.repositories.EventRepository;
import com.nutouchh.EventAgency.dao.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public List<Event> getEvents(String title) {
        log.info("Get event with title = {}", title);
        if (title != null) return eventRepository.findEventByTitle(title);
        log.info("There is no such event, get all events");
        return eventRepository.findAll();
    }

    public void saveEvent(Principal principal, Event event, MultipartFile file) throws IOException {
        Image image;
        if (file.getSize() != 0) {
            image = toImageEntity(file);
            event.addImageToEvent(image);
        }
        log.info("Saving new event {}", event.getTitle());
        eventRepository.save(event);
    }

    public Object getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
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
