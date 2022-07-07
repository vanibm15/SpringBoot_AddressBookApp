package com.bridgelabzaddressbook.controller;





import com.bridgelabzaddressbook.dto.AddressBookDTO;
import com.bridgelabzaddressbook.dto.ResponseDTO;
import com.bridgelabzaddressbook.model.AddressBook;
import com.bridgelabzaddressbook.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


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

    /**
     * Creating insert API ,to insert data
     * @param addressBook
     * @return
     */

    @PostMapping(value = "/insert")
    public ResponseEntity<ResponseDTO> addEmployeePayRollData(@Valid @RequestBody AddressBookDTO addressBook)
    {
        String addData = addressbookservice.addData(addressBook);
        ResponseDTO dto = new ResponseDTO("Contact added successfully", addData);
        return new ResponseEntity<ResponseDTO>(dto, HttpStatus.OK);
    }


    /** creating Retrieve API to retrieve data
     *
     * @param token
     * @return
     */

    @GetMapping(value = "/retrieve/{token}")
    public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable String token)
    {
        Optional<AddressBook> addressBooks = addressbookservice.getAddressBookData(token);
        ResponseDTO dto = new ResponseDTO("Contact retrieved successfully ",addressBooks);
        return new ResponseEntity<ResponseDTO>(dto, HttpStatus.OK);
    }



    /**
     * Creating getContacts API, to get the list of contact in addressbook
     *
     * @return
     */

    @GetMapping("/getContacts")
    public ResponseDTO getContacts() {
        List<AddressBook> contacts = addressbookservice.getListOfContacts();
        ResponseDTO dto = new ResponseDTO("retrieved teh list of contact successfully", contacts);
        return dto;
    }



    /**
     * created getContact API to get the contact details by id
     *
     * @param getId
     * @return
     */


    @GetMapping("/getContactById/{getId}")
    public ResponseEntity<ResponseDTO> getContactById(@PathVariable long getId) {
        Optional<AddressBook> contactId = addressbookservice.getContactById(getId);
        ResponseDTO dto = new ResponseDTO("contact  retrieved successfully by id:" + " " + getId, contactId);
        return new ResponseEntity<ResponseDTO>(dto, HttpStatus.OK);
    }



    /**
     * Creating delete API ,to delete the contact by id in addressbook
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteContact(@RequestParam long id) {
        addressbookservice.deleteContact(id);
        ResponseDTO dto = new ResponseDTO("deleted contact successfully....!", id);
        return new ResponseEntity<ResponseDTO>(dto, HttpStatus.OK);
    }

    /**
     * creating update contact API ,to update contact by ID in addressbook
     *
     * @param getId
     * @param addressBook
     * @return
     */
    @PutMapping("/updateContact/{getId}")
    public ResponseDTO updateContact(@PathVariable long getId, @Valid @RequestBody AddressBookDTO addressBook) {
        AddressBook updateContact = addressbookservice.updateContact(getId, addressBook);
        ResponseDTO dto = new ResponseDTO("updated  contact  successfully", updateContact);
        return dto;
    }


//
//    /**
//     * created addContacts API to add contact in addressbook
//     *
//     * @param addressBook
//     * @return
//     */

//    @PostMapping("/AddContact")
//    public ResponseEntity<ResponseDTO> AddContact(@Valid @RequestBody AddressBookDTO addressBook) {
//        AddressBook AddContact = addressbookservice.AddAddressBook(addressBook);
//        ResponseDTO dto = new ResponseDTO("Contact added successfully", AddContact);
//        return new ResponseEntity<ResponseDTO>(dto, HttpStatus.OK);
//
//    }

}






