package com.nutouchh.EventAgency.services;

import com.nutouchh.EventAgency.dao.models.Action;
import com.nutouchh.EventAgency.dao.models.Image;
import com.nutouchh.EventAgency.dao.models.User;
import com.nutouchh.EventAgency.dao.repositories.ActionRepository;
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
public class ActionService {
    private final ActionRepository actionRepository;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public List<Action> getActions(String title) {
        log.info("Get action with title = {}", title);
        if (title != null) return actionRepository.findActionByTitle(title);
        log.info("There is no such action, get all actions");
        return actionRepository.findAll();
    }

    public void saveAction(Principal principal, Action action, MultipartFile file, String eventTitle) throws IOException {
        Image image;
        if (file.getSize() != 0) {
            image = toImageEntity(file);
            action.addImageToAction(image);
        }
        log.info("Saving new action {}", action.getTitle());
        if (eventTitle != null) {
            eventRepository.findEventByTitle(eventTitle).forEach(event -> event.addActionToEvent(action));
            actionRepository.save(action);
        }

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

    public void deleteAction(Long id) {
        log.info("Delete action with ID = {}", id);
        actionRepository.deleteById(id);
    }

    public Action getActionById(Long id) {
        log.info("Get action with ID = {}", id);
        return actionRepository.findById(id).orElse(null);
    }
}
