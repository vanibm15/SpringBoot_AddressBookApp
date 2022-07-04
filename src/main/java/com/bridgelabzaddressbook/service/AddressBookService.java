package com.bridgelabzaddressbook.service;

import com.bridgelabzaddressbook.model.AddressBook;
import com.bridgelabzaddressbook.repository.IaddressBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AddressBookService implements IAddressBookService {

    @Autowired
    IaddressBookRepo repo;

    @Override
    public String getMessage() {
        return "Welcome to AddressBookService";
    }

    @Override
    public String AddAddressBook(AddressBook addressBook) {
        repo.save(addressBook);
        return addressBook.toString();

    }
    @Override
    public AddressBook getContactId(long getId) {
        Optional<AddressBook> addressBook = repo.findById((long) getId);
        return addressBook.get();
    }
    @Override
    public List<AddressBook> getListOfContacts() {
        List<AddressBook> contacts = repo.findAll();
        return contacts;
    }
    @Override
    public void deleteContact(long id) {
        repo.deleteById((long) id);

    }
    @Override
    public AddressBook updateContact(long getId, AddressBook addressBook) {
        Optional<AddressBook> newContact = repo.findById((long) getId);
        if (newContact.isPresent()) {
            newContact.get().setFullName(addressBook.getFullName());
            newContact.get().setAddress(addressBook.getAddress());
            newContact.get().setCity(addressBook.getCity());
            newContact.get().setState(addressBook.getState());
            newContact.get().setZip(addressBook.getZip());
            newContact.get().setPhone(addressBook.getPhone());
            repo.save(newContact.get());
            return newContact.get();
        } else {
            return null;
        }
    }
}



