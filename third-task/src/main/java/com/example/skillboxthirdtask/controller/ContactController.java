package com.example.skillboxthirdtask.controller;

import com.example.skillboxthirdtask.entity.Contact;
import com.example.skillboxthirdtask.service.ContactService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contacts")
@RequiredArgsConstructor
@Slf4j
public class ContactController
{
    private final ContactService contactService;

    @GetMapping
    public String listContacts(Model model) {
        log.debug("CONTACT SERVICE SAY : listContacts");
        model.addAttribute("contact", contactService.listContacts());
        return "contact-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact-form";
    }

    @PostMapping("/add")
    public String addContact(@ModelAttribute("contact") Contact contact) {
        log.debug("CONTACT SERVICE SAY : addContact");
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
        return "redirect:/";
    }

    @PostMapping("/edit/{id}")
    public String updateContact(@PathVariable("id") Long id, @ModelAttribute("contact") Contact contact) {
        log.debug("CONTACT SERVICE SAY : updateContact");
        contactService.updateContact(id, contact);
        return "redirect:/contacts";
    }

    @GetMapping("/delete/{id}")
    public String deleteContact(@PathVariable("id") Long id) {
        log.debug("CONTACT SERVICE SAY : deleteContact");
        contactService.deleteContact(id);
        return "redirect:/contacts";
    }

}
