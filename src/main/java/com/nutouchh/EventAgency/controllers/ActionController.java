package com.nutouchh.EventAgency.controllers;

import com.nutouchh.EventAgency.models.Action;
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

    @GetMapping("/")
    public String actions(Model model){
        model.addAttribute("actions", actionService.getActions());
        return "actions";
    }

    @GetMapping("/action/{id}")
    public String actionInfo(@PathVariable Long id, Model model){
        model.addAttribute("action", actionService.getActionById(id));
        return "action-info";
    }
    @PostMapping("/action/create" )
    public String createAction(Action action){
        actionService.saveAction(action);
        return "redirect:/";
    }

    @PostMapping("/action/delete/{id}" )
    public String deleteAction(@PathVariable Long id){
        actionService.deleteAction(id);
        return "redirect:/";
    }
}
