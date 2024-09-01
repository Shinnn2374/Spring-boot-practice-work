package com.example.skillboxthirdtask.repository;

import com.example.skillboxthirdtask.entity.Contact;

public interface ContactRepository
{
    String listContacts();
    String addContact(Contact contact);
    String updateContact(Long id, Contact contact);
    String deleteContact(Long id);
    Contact findById(Long id);
}
