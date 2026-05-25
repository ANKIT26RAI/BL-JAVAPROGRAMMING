package com.fundoo.contactsapp.service;

import com.fundoo.contactsapp.exception.ContactNotFoundException;
import com.fundoo.contactsapp.model.Contact;
import com.fundoo.contactsapp.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Contact getContactById(Long id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new ContactNotFoundException("Contact not found with id: " + id));
    }

    public Contact updateContact(Long id, Contact contactDetails) {

        Contact existingContact = contactRepository.findById(id)
                .orElseThrow(() -> new ContactNotFoundException("Contact not found with id: " + id));

        existingContact.setName(contactDetails.getName());
        existingContact.setEmail(contactDetails.getEmail());
        existingContact.setPhone(contactDetails.getPhone());
        existingContact.setAddress(contactDetails.getAddress());

        return contactRepository.save(existingContact);
    }

    public String deleteContact(Long id) {

        Contact existingContact = contactRepository.findById(id)
                .orElseThrow(() -> new ContactNotFoundException("Contact not found with id: " + id));

        contactRepository.delete(existingContact);

        return "Contact deleted successfully with id: " + id;
    }

    public List<Contact> searchByName(String name) {
        return contactRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Contact> searchByEmail(String email) {
        return contactRepository.findByEmailContainingIgnoreCase(email);
    }
}