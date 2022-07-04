package com.bridgelabzaddressbook.service;

import com.bridgelabzaddressbook.model.AddressBook;

import java.util.List;

public interface IAddressBookService {

    String getMessage();


    String AddAddressBook(AddressBook addressBook);

    AddressBook getContactId(long getId);

    List<AddressBook> getListOfContacts();

    void deleteContact(long id);

    AddressBook updateContact(long getId, AddressBook addressBook);
}
