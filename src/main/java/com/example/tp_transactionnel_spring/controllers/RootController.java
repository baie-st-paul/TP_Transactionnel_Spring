package com.example.tp_transactionnel_spring.controllers;

import com.example.tp_transactionnel_spring.service.ServiceLibrary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {
     Logger logger = LoggerFactory.getLogger(RootController.class);

    private ServiceLibrary serviceLibrary;

    public RootController(ServiceLibrary serviceLibrary){
        this.serviceLibrary = serviceLibrary;
    }

    @GetMapping("/")
    public String getRootRequest(Model model) {
        model.addAttribute("pageTitle1", "Mon Demo");
        return "index";
    }

    @GetMapping("/listBooks")
    public String listBooks(Model model){
        model.addAttribute("books", serviceLibrary.findAllBook());
        return "listBooks";
    }
}
