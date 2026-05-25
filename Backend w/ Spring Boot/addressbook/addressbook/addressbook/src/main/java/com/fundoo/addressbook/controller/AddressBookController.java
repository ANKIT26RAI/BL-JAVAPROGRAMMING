package com.fundoo.addressbook.controller;

import com.fundoo.addressbook.model.AddressBook;
import com.fundoo.addressbook.service.AddressBookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    @PostMapping
    public AddressBook createAddress(@Valid @RequestBody AddressBook addressBook) {
        return addressBookService.createAddress(addressBook);
    }

    @GetMapping
    public List<AddressBook> getAllAddresses() {
        return addressBookService.getAllAddresses();
    }

    @GetMapping("/{id}")
    public Optional<AddressBook> getAddressById(@PathVariable Long id) {
        return addressBookService.getAddressById(id);
    }

    @PutMapping("/{id}")
    public AddressBook updateAddress(@PathVariable Long id, @Valid @RequestBody AddressBook addressBook) {
        return addressBookService.updateAddress(id, addressBook);
    }

    @DeleteMapping("/{id}")
    public String deleteAddress(@PathVariable Long id) {

        boolean deleted = addressBookService.deleteAddress(id);

        if (deleted) {
            return "Address deleted successfully with id: " + id;
        } else {
            return "Address not found with id: " + id;
        }
    }

    @GetMapping("/search/name/{fullName}")
    public List<AddressBook> searchByFullName(@PathVariable String fullName) {
        return addressBookService.searchByFullName(fullName);
    }

    @GetMapping("/search/city/{city}")
    public List<AddressBook> searchByCity(@PathVariable String city) {
        return addressBookService.searchByCity(city);
    }

    @GetMapping("/search/state/{state}")
    public List<AddressBook> searchByState(@PathVariable String state) {
        return addressBookService.searchByState(state);
    }
}