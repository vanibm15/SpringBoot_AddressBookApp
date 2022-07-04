package com.bridgelabzaddressbook.service;

import com.bridgelabzaddressbook.dto.AddressBookDTO;
import com.bridgelabzaddressbook.model.AddressBook;

import java.util.List;

public interface IAddressBookService {

    String getMessage();



    String AddAddressBook(AddressBookDTO addressBookdto);

    AddressBook getContactId(long getId);

    List<AddressBook> getListOfContacts();

    void deleteContact(long id);

    AddressBook updateContact(long getId, AddressBookDTO addressBookdto);
}
