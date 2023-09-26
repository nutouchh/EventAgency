package com.nutouchh.EventAgency.services;

import com.nutouchh.EventAgency.dao.models.Action;
import com.nutouchh.EventAgency.dao.repositories.ActionRepository;
import com.nutouchh.EventAgency.dao.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ActionService {
    private final ActionRepository actionRepository;
    private final EventRepository eventRepository;

    public List<Action> getActions(String title) {
        log.info("Get action with title = {}", title);
        if (title != null) return actionRepository.findActionByTitle(title);
        log.info("There is no such action, get all actions");
        return actionRepository.findAll();
    }

    public void saveAction(Action action, String eventTitle){
        log.info("Saving new action {}", action.getTitle());
        if (eventTitle != null) {
            eventRepository.findEventByTitle(eventTitle).forEach(event -> event.addActionToEvent(action));
            actionRepository.save(action);
        }

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
