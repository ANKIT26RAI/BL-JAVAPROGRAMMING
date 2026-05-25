package com.fundoo.contactsapp.controller;

import com.fundoo.contactsapp.model.Contact;
import com.fundoo.contactsapp.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping
    public Contact createContact(@Valid @RequestBody Contact contact) {
        return contactService.createContact(contact);
    }

    @GetMapping
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/{id}")
    public Contact getContactById(@PathVariable Long id) {
        return contactService.getContactById(id);
    }

    @PutMapping("/{id}")
    public Contact updateContact(@PathVariable Long id, @Valid @RequestBody Contact contact) {
        return contactService.updateContact(id, contact);
    }

    @DeleteMapping("/{id}")
    public String deleteContact(@PathVariable Long id) {
        return contactService.deleteContact(id);
    }

    @GetMapping("/search/name/{name}")
    public List<Contact> searchByName(@PathVariable String name) {
        return contactService.searchByName(name);
    }

    @GetMapping("/search/email/{email}")
    public List<Contact> searchByEmail(@PathVariable String email) {
        return contactService.searchByEmail(email);
    }
}