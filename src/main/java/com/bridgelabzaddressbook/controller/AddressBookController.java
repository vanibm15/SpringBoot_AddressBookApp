package com.bridgelabzaddressbook.controller;


import com.bridgelabzaddressbook.dto.AddressBookDTO;
import com.bridgelabzaddressbook.dto.ResponseDTO;
import com.bridgelabzaddressbook.model.AddressBook;
import com.bridgelabzaddressbook.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ResponseDTO> AddContact(@RequestBody AddressBookDTO addressBook) {
        String AddContact = addressbookservice.AddAddressBook(addressBook);
       ResponseDTO dto =new ResponseDTO("Contact added successfully",AddContact);
        return new ResponseEntity<ResponseDTO>(dto, HttpStatus.OK);

    }

    @GetMapping("/getContact/{getId}")
    public ResponseEntity<ResponseDTO> getContact(@PathVariable long getId) {
        AddressBook contactId = addressbookservice.getContactId(getId);
        ResponseDTO dto=new ResponseDTO("Got Contact by id is syccessfulll....!",contactId);
        return new ResponseEntity<ResponseDTO>(dto,HttpStatus.OK);
    }


    @GetMapping("/getContact")
    public ResponseDTO getContacts(){
        List<AddressBook> contacts=addressbookservice.getListOfContacts();
        ResponseDTO dto=new ResponseDTO("Got Contacts List is syccessfulll....!",contacts);
        return dto;
    }
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteContact(@RequestParam long id){
        addressbookservice.deleteContact(id);
        ResponseDTO dto = new ResponseDTO("deleted contact successfully....!", id);
         return new ResponseEntity<ResponseDTO>(dto, HttpStatus.OK);
    }
    @PutMapping("/updateContact/{getId}")
    public ResponseDTO updateContact(@PathVariable long getId, @RequestBody AddressBookDTO  addressBook){
        AddressBook updateContact=addressbookservice.updateContact(getId,addressBook);
        ResponseDTO dto = new ResponseDTO("updated  contact  successfully", updateContact);
        return dto;
    }

}






