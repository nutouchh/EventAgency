package com.nutouchh.EventAgency.controllers;

import com.nutouchh.EventAgency.dao.models.Event;
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

@Controller
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping("/")
    public String events(@RequestParam(name = "title", required = false) String title, Model model) {
        model.addAttribute("events", eventService.getEvents(title));
        return "events";
    }

    @GetMapping("/event/{id}")
    public String eventInfo(@PathVariable Long id, Model model) {
        Event event = eventService.getEventById(id);
        model.addAttribute("event", event);
        model.addAttribute("actions", event.getActions());
        return "event-actions";
    }

    @PostMapping("/event/create")
    public String createEvent(Event event) {
        eventService.saveEvent(event);
        return "redirect:/create/event/success";
    }

    @GetMapping("/create/event")
    public String createEventPage() {
        return "create-event";
    }

    @GetMapping("/create/event/success")
    public String success() {
        return "create-success";
    }

    @PostMapping("/event/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return "redirect:/";
    }
}
