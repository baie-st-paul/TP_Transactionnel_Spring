package com.example.tp_transactionnel_spring.controllers;

import com.example.tp_transactionnel_spring.service.ServiceLibrary;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

@Controller
public class RootController {
  //  Logger logger = LoggerFactory.getLogger(RootController.class);

    private final ServiceLibrary serviceLibrary;

    public RootController(ServiceLibrary serviceLibrary){
        this.serviceLibrary = serviceLibrary;
    }

    @GetMapping("/")
    public String getRootRequest(Model model) {
        model.addAttribute("pageTitle", "Mon Demo");
        return "index";
    }

    @GetMapping("/livres")
    public String getProfs(Model model) {
        model.addAttribute("pageTitle", "Mon Demo");
        var books = serviceLibrary.findAllBook();
        model.addAttribute("books", books);
        return "books";
    }
}
