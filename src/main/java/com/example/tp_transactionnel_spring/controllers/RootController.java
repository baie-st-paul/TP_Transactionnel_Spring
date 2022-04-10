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

    public RootController(ServiceLibrary serviceLibrary){
    }

    @GetMapping("/")
    public String getRootRequest(Model model) {
        model.addAttribute("pageTitle", "Mon Demo");
        return "index";
    }

}
