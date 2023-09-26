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
@Controller
@RequiredArgsConstructor
public class ActionController {
    private final ActionService actionService;
    private final EventRepository eventRepository;

    @GetMapping("/action/{id}")
    public String actionInfo(@PathVariable Long id, Model model) {
        Action action = actionService.getActionById(id);
        model.addAttribute("action", action);
        return "action-info";
    }

    @PostMapping("/action/create")
    public String createAction( Action action,  String eventTitle){
        actionService.saveAction(action, eventTitle);
        return "redirect:/create/action/success";
    }

    @GetMapping("/create/action")
    public String createActionPage(Model model) {
        model.addAttribute("events", eventRepository.findAll());
        return "create-action";
    }

    @GetMapping("/create/action/success")
    public String success() {
        return "create-success";
    }

    @PostMapping("/action/delete/{id}")
    public String deleteAction(@PathVariable Long id) {
        actionService.deleteAction(id);
        return "redirect:/";
    }
}
