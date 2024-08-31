package com.example.skillboxthirdtask.service;

import com.example.skillboxthirdtask.entity.Contact;

public interface ContactService
{
     Contact findById(Long id);
    String addContact(Contact contact);
    String updateContact(Long id, Contact contact);
    String deleteContact(Long id);
    String listContacts();
}
