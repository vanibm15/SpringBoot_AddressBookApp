package com.bridgelabzaddressbook.controller;


import com.bridgelabzaddressbook.model.AddressBook;
import com.bridgelabzaddressbook.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/addressBookService")
public class AddressBookController {


    @Autowired
    IAddressBookService addressbookservice;

    @GetMapping("/home")
    public String home() {
        String message = addressbookservice.getMessage();
        return message;
    }

    @PostMapping("/AddContact")
    public String AddContact(@RequestBody AddressBook addressBook) {
        String AddContact = addressbookservice.AddAddressBook(addressBook);
        return AddContact;

    }

    @GetMapping("/getContact/{getId}")
    public AddressBook getContact(@PathVariable long getId) {
        AddressBook contactId = addressbookservice.getContactId(getId);
        return contactId;
    }


    @GetMapping("/getContact")
    public List<AddressBook> getContact() {
        List<AddressBook> contacts=addressbookservice.getListOfContacts();
        return contacts;
    }
    @DeleteMapping("/delete")
    public String deleteContact(@RequestParam long id){
        addressbookservice.deleteContact(id);
        return "Deleted....!";
    }
    @PutMapping("/updateContact/{getId}")
    public AddressBook updateContact(@PathVariable long getId,@RequestBody AddressBook  addressBook){
        AddressBook updateContact=addressbookservice.updateContact(getId,addressBook);
        return updateContact;
    }

}






