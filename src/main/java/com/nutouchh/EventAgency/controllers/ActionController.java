package com.nutouchh.EventAgency.controllers;

import com.nutouchh.EventAgency.dao.models.Action;
import com.nutouchh.EventAgency.dao.repositories.EventRepository;
import com.nutouchh.EventAgency.services.ActionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class ActionController {
    private final ActionService actionService;
    private final EventRepository eventRepository;

    @GetMapping("/action/{id}")
    public String actionInfo(@PathVariable Long id, Model model, Principal principal) {
        Action action = actionService.getActionById(id);
        model.addAttribute("action", action);
        model.addAttribute("image", action.getImage());
        model.addAttribute("user", actionService.getUserByPrincipal(principal));
        return "action-info";
    }

    @PostMapping("/action/create")
    public String createAction(@RequestParam("file") MultipartFile file, Action action, Principal principal, String eventTitle) throws IOException {
        actionService.saveAction(principal, action, file, eventTitle);
        return "redirect:/create/action/success";
    }

    @GetMapping("/create/action")
    public String createActionPage(Model model, Principal principal) {
        model.addAttribute("user", actionService.getUserByPrincipal(principal));
        model.addAttribute("events", eventRepository.findAll());
        return "create-action";
    }

    @GetMapping("/create/action/success")
    public String success(Model model, Principal principal) {
        model.addAttribute("user", actionService.getUserByPrincipal(principal));
        return "create-success";
    }

    @PostMapping("/action/delete/{id}")
    public String deleteAction(@PathVariable Long id) {
        actionService.deleteAction(id);
        return "redirect:/";
    }
}
