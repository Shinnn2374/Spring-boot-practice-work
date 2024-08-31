package com.example.skillboxthirdtask.service;

import com.example.skillboxthirdtask.entity.Contact;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ContactServiceImpl implements ContactService
{
    Map<Long, Contact> contactMap = new HashMap<>();
    Integer key = 0;

    @Override
    public Contact findById(Long id) {
        return contactMap.get(id);
    }

    @Override
    public String addContact(Contact contact) {
        key++;
        contactMap.put((long)key,contact);
        return "";
    }

    @Override
    public String updateContact(Long id, Contact contact) {
        Contact existContact = contactMap.get(id);
        existContact.setFirstName(contact.getFirstName());
        existContact.setLastName(contact.getLastName());
        existContact.setEmail(contact.getEmail());
        existContact.setPhone(contact.getPhone());
        contactMap.put(id, existContact);
        return "";
    }

    @Override
    public String deleteContact(Long id) {
        contactMap.remove(id);
        return "";
    }

    @Override
    public String listContacts() {
        for (Contact contact : contactMap.values()) {
            System.out.println(contact.getFirstName() + " " + contact.getLastName() + " " + contact.getEmail() + " " + contact.getPhone());
        }
        return "";
    }
}
