package com.fundoo.addressbook.repository;

import com.fundoo.addressbook.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBook, Long> {

    List<AddressBook> findByFullNameContainingIgnoreCase(String fullName);

    List<AddressBook> findByCityContainingIgnoreCase(String city);

    List<AddressBook> findByStateContainingIgnoreCase(String state);
}