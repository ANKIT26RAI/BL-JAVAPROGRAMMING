package com.fundoo.addressbook.service;

import com.fundoo.addressbook.model.AddressBook;
import com.fundoo.addressbook.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;

    public AddressBook createAddress(AddressBook addressBook) {
        return addressBookRepository.save(addressBook);
    }

    public List<AddressBook> getAllAddresses() {
        return addressBookRepository.findAll();
    }

    public Optional<AddressBook> getAddressById(Long id) {
        return addressBookRepository.findById(id);
    }

    public AddressBook updateAddress(Long id, AddressBook addressDetails) {

        AddressBook existingAddress = addressBookRepository.findById(id).orElse(null);

        if (existingAddress == null) {
            return null;
        }

        existingAddress.setFullName(addressDetails.getFullName());
        existingAddress.setEmail(addressDetails.getEmail());
        existingAddress.setPhoneNumber(addressDetails.getPhoneNumber());
        existingAddress.setAddress(addressDetails.getAddress());
        existingAddress.setCity(addressDetails.getCity());
        existingAddress.setState(addressDetails.getState());
        existingAddress.setZipCode(addressDetails.getZipCode());

        return addressBookRepository.save(existingAddress);
    }

    public boolean deleteAddress(Long id) {

        AddressBook existingAddress = addressBookRepository.findById(id).orElse(null);

        if (existingAddress == null) {
            return false;
        }

        addressBookRepository.delete(existingAddress);
        return true;
    }

    public List<AddressBook> searchByFullName(String fullName) {
        return addressBookRepository.findByFullNameContainingIgnoreCase(fullName);
    }

    public List<AddressBook> searchByCity(String city) {
        return addressBookRepository.findByCityContainingIgnoreCase(city);
    }

    public List<AddressBook> searchByState(String state) {
        return addressBookRepository.findByStateContainingIgnoreCase(state);
    }
}