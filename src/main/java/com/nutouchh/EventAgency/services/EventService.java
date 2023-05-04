package com.nutouchh.EventAgency.services;

import com.nutouchh.EventAgency.models.Event;
import com.nutouchh.EventAgency.models.Event;
import com.nutouchh.EventAgency.models.Image;
import com.nutouchh.EventAgency.models.User;
import com.nutouchh.EventAgency.repositories.EventRepository;
import com.nutouchh.EventAgency.repositories.EventRepository;
import com.nutouchh.EventAgency.repositories.UserRepository;
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

//    public List<Event> getAllEvents() {
//        log.info("Get all events");
//        return eventRepository.findAll();
//    }
//
//    public List<Event> getEvents(String title) {
////        log.info("Get event with title = {}", title);
////        if (title != null) return eventRepository.findEventByTitle(title);
////        return null;
////    }

    public List<Event> getEvents(String title) {
        log.info("Get event with title = {}", title);
        if (title != null) return eventRepository.findEventByTitle(title);
        log.info("There is no such event, get all events");
        return eventRepository.findAll();
    }

//    public void saveEvent(Principal principal, Event event) throws IOException {
//        log.info("Saving new event {}", event.getTitle());
////        Event eventFromDb = eventRepository.save(event);
////        eventFromDb.setPreviewImageId(eventFromDb.getImages().get(0).getId());
//        eventRepository.save(event);
//    }


    public void saveEvent(Principal principal, Event event, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
//        event.setUser(getUserByPrincipal(principal));
        Image image1;
        Image image2;
        Image image3;
        if (file1.getSize() != 0) {
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            event.addImageToEvent(image1);
        }
        if (file2.getSize() != 0) {
            image2 = toImageEntity(file2);
            event.addImageToEvent(image2);
        }
        if (file3.getSize() != 0) {
            image3 = toImageEntity(file3);
            event.addImageToEvent(image3);
        }
        log.info("Saving new event {}", event.getTitle());
        Event eventFromDb = eventRepository.save(event);
        eventFromDb.setPreviewImageId(eventFromDb.getImages().get(0).getId());
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
