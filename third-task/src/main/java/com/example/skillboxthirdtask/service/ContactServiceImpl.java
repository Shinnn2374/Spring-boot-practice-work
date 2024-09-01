package com.example.skillboxthirdtask.service;

import com.example.skillboxthirdtask.entity.Contact;
import com.example.skillboxthirdtask.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContactServiceImpl implements ContactService
{
    private final ContactRepository contactRepository;

    @Override
    public String listContacts() {
        log.debug("CONTACT SERVICE SAY: listContacts");
        contactRepository.listContacts();
        return "";
    }

    @Override
    public String addContact(Contact contact) {
        log.debug("CONTACT SERVICE SAY: addContact");
        contactRepository.addContact(contact);
        return "";
    }

    @Override
    public String updateContact(Long id, Contact contact) {
        log.debug("CONTACT SERVICE SAY: updateContact");
        contactRepository.updateContact(id, contact);
        return "";
    }

    @Override
    public String deleteContact(Long id) {
        log.debug("CONTACT SERVICE SAY: deleteContact");
        contactRepository.deleteContact(id);
        return "";
    }

    @Override
    public Contact findById(Long id) {
        log.debug("CONTACT SERVICE SAY: findById");
        contactRepository.findById(id);
        return null;
    }
}
