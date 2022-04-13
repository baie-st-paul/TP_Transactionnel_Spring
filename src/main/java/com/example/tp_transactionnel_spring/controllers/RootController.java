package com.example.tp_transactionnel_spring.controllers;

import com.example.tp_transactionnel_spring.forms.BookForm;
import com.example.tp_transactionnel_spring.forms.ClientForm;
import com.example.tp_transactionnel_spring.models.client.Client;
import com.example.tp_transactionnel_spring.models.document.Book;
import com.example.tp_transactionnel_spring.service.ServiceLibrary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/listClients")
    public String listClients(Model model){
        model.addAttribute("clients",serviceLibrary.findAllClient());
        return "listClients";
    }

    @GetMapping("/createClient")
    public String getClientCreate(@ModelAttribute ClientForm clientForm, Model model, RedirectAttributes redirectAttributes){
        clientForm = new ClientForm(new Client());
        model.addAttribute("clientForm", clientForm);
        return "clientEdit";
    }

    @PostMapping("/createClient")
    public String clientPost(@ModelAttribute ClientForm clientForm, BindingResult errors, Model model, RedirectAttributes redirectAttributes){
        logger.info("client: " + clientForm);
        serviceLibrary.saveClient(clientForm.toClient());
        redirectAttributes.addFlashAttribute("clientForm", clientForm);
        model.addAttribute("pageTitle1", "Client");
        model.addAttribute("clientForm",clientForm );
        return "redirect:listClients";
    }

    @GetMapping("/createBook")
    public String getBookCreate(@ModelAttribute BookForm bookForm, Model model, RedirectAttributes redirectAttributes){
        bookForm = new BookForm(new Book());
        model.addAttribute("bookForm" , bookForm);
        return "bookEdit";
    }

    @PostMapping("/createBook")
    public String bookPost(@ModelAttribute BookForm bookForm, BindingResult errors, Model model, RedirectAttributes redirectAttributes){
        logger.info("book: " + bookForm);
        serviceLibrary.saveBook(bookForm.getTitle(), bookForm.getAuthor(),bookForm.getEditor(), bookForm.getPublicationYear(), bookForm.getNb_pages(), bookForm.getGenre());
        redirectAttributes.addFlashAttribute("bookForm", bookForm);
        model.addAttribute("pageTitle1", "Book");
        model.addAttribute("bookForm", bookForm);
        return "redirect:listBooks";
    }
}
