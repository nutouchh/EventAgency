package com.nutouchh.EventAgency.controllers;

import com.nutouchh.EventAgency.models.Action;
import com.nutouchh.EventAgency.models.Event;
import com.nutouchh.EventAgency.services.ActionService;
import com.nutouchh.EventAgency.services.EventService;
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
public class EventController {

    private final EventService eventService;

    @GetMapping("/event")
    public String events(@RequestParam(name = "title", required = false) String title, Principal principal, Model model) {
        model.addAttribute("events", eventService.getEvents(title));
        model.addAttribute("user", eventService.getUserByPrincipal(principal));
        return "events";
    }

    @GetMapping("/event/{id}")
    public String eventInfo(@PathVariable Long id, Model model) {
        Event event = eventService.getEventById(id);
        model.addAttribute("event", event);
        model.addAttribute("image", event.getImage());
        return "event-info";
    }

//    @PostMapping("/event/create")
//    public String createEvent(Event event, Principal principal) throws IOException {
//        eventService.saveEvent(principal, event);
//        return "redirect:/";
//    }

    @PostMapping("/event/create")
    public String createEvent(@RequestParam("file") MultipartFile file, Event event, Principal principal) throws IOException {
        eventService.saveEvent(principal, event, file);
        return "redirect:/";
    }



    @PostMapping("/event/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return "redirect:/";
    }
}
