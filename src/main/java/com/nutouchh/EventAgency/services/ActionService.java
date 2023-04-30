package com.nutouchh.EventAgency.services;

import com.nutouchh.EventAgency.models.Action;
import com.nutouchh.EventAgency.models.Image;
import com.nutouchh.EventAgency.repositories.ActionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ActionService {
    private final ActionRepository actionRepository;

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

    public void saveAction(Action action, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
        Image image1;
        Image image2;
        Image image3;
        if (file1.getSize() != 0) {
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            action.addImageToAction(image1);
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
        if (file2.getSize() != 0) {
            image2 = toImageEntity(file2);
            action.addImageToAction(image2);
        }
        if (file3.getSize() != 0) {
            image3 = toImageEntity(file3);
            action.addImageToAction(image3);
        }
        log.info("Saving new action {}", action.getTitle());
        Action actionFromDb = actionRepository.save(action);
        actionFromDb.setPreviewImageId(actionFromDb.getImages().get(0).getId());
        actionRepository.save(action);
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
