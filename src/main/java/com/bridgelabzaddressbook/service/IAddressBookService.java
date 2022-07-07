package com.bridgelabzaddressbook.service;

import com.bridgelabzaddressbook.dto.AddressBookDTO;
import com.bridgelabzaddressbook.model.AddressBook;

import java.util.List;
import java.util.Optional;

public interface IAddressBookService {

    String getMessage();

   // AddressBook AddAddressBook(AddressBookDTO addressBookdto);
    Optional<AddressBook> getContactById(long getId);
    List<AddressBook> getListOfContacts();

    void deleteContact(long id);


    AddressBook updateContact(long getId, AddressBookDTO addressBookdto);

    String addData(AddressBookDTO addressBook);
    Optional<AddressBook> getAddressBookData(String token);


}

