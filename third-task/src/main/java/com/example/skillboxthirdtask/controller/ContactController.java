package com.example.skillboxthirdtask.controller;

import com.example.skillboxthirdtask.entity.Contact;
import com.example.skillboxthirdtask.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @GetMapping
    public String listContacts(Model model) {
        model.addAttribute("list", contactService.listContacts());
        return "contact-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact-form";
    }

    @PostMapping("/add")
    public String addContact(@ModelAttribute("contact") Contact contact) {
        contactService.addContact(contact);
        return "redirect:/contacts";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Contact contact = contactService.findById(id);
        if (contact != null)
        {
            model.addAttribute("contact", contact);
            return "/edit";
        }
        return "contact-form";
    }

    @PostMapping("/edit/{id}")
    public String updateContact(@PathVariable("id") Long id, @ModelAttribute("contact") Contact contact) {
        contactService.updateContact(id, contact);
        return "redirect:/contacts";
    }

    @GetMapping("/delete/{id}")
    public String deleteContact(@PathVariable("id") Long id) {
        contactService.deleteContact(id);
        return "redirect:/contacts";
    }

}
