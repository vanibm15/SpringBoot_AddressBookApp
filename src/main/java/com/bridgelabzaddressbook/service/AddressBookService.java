package com.bridgelabzaddressbook.service;

import com.bridgelabzaddressbook.dto.AddressBookDTO;
import com.bridgelabzaddressbook.model.AddressBook;
import com.bridgelabzaddressbook.repository.IaddressBookRepo;
import com.bridgelabzaddressbook.utilpackage.EmailSenderService;
import com.bridgelabzaddressbook.utilpackage.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AddressBookService implements IAddressBookService {

    @Autowired
    EmailSenderService sender;
    @Autowired
    IaddressBookRepo repo;
    @Autowired
    TokenUtil tokenutil;

    @Override
    public String getMessage() {
        return "Welcome to AddressBookService";
    }

    /**
     * create contact in addressbook
     *
     * @param addressBookdto
     * @return
     */


    @Override
    public String addData(AddressBookDTO addressBookdto) {
        AddressBook addressBook = new AddressBook(addressBookdto);
        repo.save(addressBook);
        String token = tokenutil.createToken(addressBook.getId());
        sender.sendEmail(addressBook.getEmail(), "Test Email", "Registered SuccessFully1 : click here" + " " +
                "" + "http://localhost:8080/addressBookService/retrieve/"+token);
        return token;
    }
//    @Override
//    public AddressBook AddAddressBook(AddressBookDTO addressBookdto) {
//        AddressBook addressBook = new AddressBook(addressBookdto);
//        repo.save(addressBook);
//        return addressBook;
//
//    }


    @Override
    public Optional<AddressBook> getAddressBookData(String token) {
        long id = tokenutil.decodeToken(token);
        Optional<AddressBook> addressbook = repo.findById(id);
        if (addressbook.isPresent()) {
            sender.sendEmail(addressbook.get().getEmail(), "test email", "retrieved contact successfully :click here" +
                    "http://localhost:8080/addressBookService/retrieve/"+token);
            return addressbook;
        } else {
            return null;
        }
    }


    /**
     * getting contact details by ID
     *
     * @param getId
     * @return
     */
    @Override
    public Optional<AddressBook> getContactById(long getId) {
        Optional<AddressBook> addressBook = repo.findById(getId);
        if (addressBook.isPresent()) {
            sender.sendEmail(addressBook.get().getEmail(), "TestMail..!",
                    "To get Contact Details Of ID :click here-> "
                            +"http://localhost:8080/addressBookService/getContactById/"+getId);
            return addressBook;
        } else {
            return null;
        }
    }

    /**
     * getting list of contact details
     *
     * @return
     */
    @Override
    public List<AddressBook> getListOfContacts() {

        List<AddressBook> contacts = repo.findAll();
        sender.sendEmail("vanibm15@gmail.com", "text mail",
                "To get List Of Contacts :click here->"+"http://localhost:8080/addressBookService/getContacts");
        return contacts;
    }

    /**
     * delete contact by ID
     *
     * @param id
     */
    @Override
    public void deleteContact(long id) {
        Optional<AddressBook> addressBook = repo.findById(id);
            repo.deleteById(id);
            sender.sendEmail(addressBook.get().getEmail(), "test email", "user deleted successfully..!  "
                    + addressBook.toString());
        }

    /**
     * Update contact details by ID
     *
     * @param getId
     * @param addressBook
     * @return
     */
    @Override
    public AddressBook updateContact(long getId, AddressBookDTO addressBook) {
        Optional<AddressBook> newContact = repo.findById((long) getId);
        if (newContact.isPresent()) {
            newContact.get().setFullName(addressBook.getFullName());
            newContact.get().setAddress(addressBook.getAddress());
            newContact.get().setCity(addressBook.getCity());
            newContact.get().setState(addressBook.getState());
            newContact.get().setZip(addressBook.getZip());
            newContact.get().setPhone(addressBook.getPhone());
            newContact.get().setEmail(addressBook.getEmail());
            repo.save(newContact.get());
            sender.sendEmail(newContact.get().getEmail(), "test email", "To get Updated Contact :Click here->"
                    + "http://localhost:8080/addressBookService/getContactById/"+getId);
            return newContact.get();
        } else {
            return null;
        }
    }
}






