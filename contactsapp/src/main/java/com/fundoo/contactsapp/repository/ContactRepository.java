package com.fundoo.contactsapp.repository;

import com.fundoo.contactsapp.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findByNameContainingIgnoreCase(String name);

    List<Contact> findByEmailContainingIgnoreCase(String email);
}