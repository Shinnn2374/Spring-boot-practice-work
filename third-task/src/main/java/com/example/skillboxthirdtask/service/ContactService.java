package com.example.skillboxthirdtask.service;

import com.example.skillboxthirdtask.entity.Contact;

public interface ContactService
{
    String listContacts();
    String addContact(Contact contact);
    String updateContact(Long id, Contact contact);
    String deleteContact(Long id);
    Contact findById(Long id);
}
