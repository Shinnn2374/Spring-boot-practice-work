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
        return contactRepository.listContacts();
    }

    @Override
    public String addContact(Contact contact) {
        log.debug("CONTACT SERVICE SAY: addContact");
        return contactRepository.addContact(contact);
    }

    @Override
    public String updateContact(Long id, Contact contact) {
        log.debug("CONTACT SERVICE SAY: updateContact");
        return contactRepository.updateContact(id, contact);
    }

    @Override
    public String deleteContact(Long id) {
        log.debug("CONTACT SERVICE SAY: deleteContact");
        return contactRepository.deleteContact(id);
    }

    @Override
    public Contact findById(Long id) {
        log.debug("CONTACT SERVICE SAY: findById");
        contactRepository.findById(id);
        return null;
    }
}
