package com.nutouchh.EventAgency.services;

import com.nutouchh.EventAgency.models.Action;
import com.nutouchh.EventAgency.models.Event;
import com.nutouchh.EventAgency.models.Image;
import com.nutouchh.EventAgency.models.User;
import com.nutouchh.EventAgency.repositories.ActionRepository;
import com.nutouchh.EventAgency.repositories.EventRepository;
import com.nutouchh.EventAgency.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ActionService {
    private final ActionRepository actionRepository;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

//    public List<Action> getAllActions() {
//        log.info("Get all actions");
//        return actionRepository.findAll();
//    }
//
//    public List<Action> getActions(String title) {
////        log.info("Get action with title = {}", title);
////        if (title != null) return actionRepository.findActionByTitle(title);
////        return null;
////    }

    public List<Action> getActions(String title) {
        log.info("Get action with title = {}", title);
        if (title != null) return actionRepository.findActionByTitle(title);
        log.info("There is no such action, get all actions");
        return actionRepository.findAll();
    }

    public void saveAction(Principal principal, Action action, MultipartFile file, String eventTitle) throws IOException {
//        action.setUser(getUserByPrincipal(principal));
        Image image;
        if (file.getSize() != 0) {
            image = toImageEntity(file);
            action.addImageToAction(image);
//            System.out.println(" ");
//            System.out.println(" ");
//            System.out.println(" ");
//
//            System.out.println(action.getImages().get(0).getOriginalFileName());
//
//            System.out.println(" ");
//            System.out.println(" ");
//            System.out.println(" ");
        }
//        if (file2.getSize() != 0) {
//            image2 = toImageEntity(file2);
//            action.addImageToAction(image2);
//        }
//        if (file3.getSize() != 0) {
//            image3 = toImageEntity(file3);
//            action.addImageToAction(image3);
//        }
        log.info("Saving new action {}", action.getTitle());
//        Action actionFromDb = actionRepository.save(action);
//        actionFromDb.setPreviewImageId(actionFromDb.getImages().get(0).getId());
        if (eventTitle != null){
            eventRepository.findEventByTitle(eventTitle).forEach(event -> event.addActionToEvent(action));
//          Long eventId = 47L;
//            for (Event ev : eventsByTitle) {
//                if (ev.getTitle() == eventTitle){
//                    System.out.println("Равенство нашлось");
//                    eventId = ev.getId();
//                }
//            }
//            eventRepository.findById(eventId).ifPresent(event -> event.addActionToEvent(action));

            actionRepository.save(action);
        }

    }

//    public void deleteEntity(String name, String address) {
//        List<Market> toDelete = marketRepository.findByNameAndAddress(name, address);
//        marketRepository.deleteAll(toDelete);
//    }

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

    public void deleteAction(Long id) {
        log.info("Delete action with ID = {}", id);
        actionRepository.deleteById(id);
    }

    public Action getActionById(Long id) {
        log.info("Get action with ID = {}", id);
        return actionRepository.findById(id).orElse(null);
    }
}
