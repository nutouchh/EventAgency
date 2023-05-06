package com.nutouchh.EventAgency.controllers;

import com.nutouchh.EventAgency.models.Callback;
import com.nutouchh.EventAgency.services.CallbackService;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Call;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

//@RequestMapping("/callback")
@Controller
@RequiredArgsConstructor
public class CallbackController {
    public final CallbackService callbackService;

    @GetMapping("/callback")
    public String callback(Model model, Principal principal) {
        model.addAttribute("user", callbackService.getUserByPrincipal(principal));
        model.addAttribute("callbackForm", new Callback());
        return "callback";
    }

    @PostMapping("/callback/create")
    public String callback(Callback callback) {
        callbackService.sendMessage("ev3ntagency@yandex.ru", "Новая заявка от " + callback.getPhone(), callback.toString());
//        callbackService.sendMessage("ev3ntagency@yandex.ru", "Новая заявка от ", "это тпекст заявки");
        return "redirect:/callback/success";
    }

    @GetMapping("/callback/success")
    public String success(Model model, Principal principal) {
        model.addAttribute("user", callbackService.getUserByPrincipal(principal));
        return "callback-success";
    }
}