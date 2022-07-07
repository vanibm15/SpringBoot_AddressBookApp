package com.bridgelabzaddressbook.model;

import com.bridgelabzaddressbook.dto.AddressBookDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@ToString
public class AddressBook {


    @Id
    @GeneratedValue
    private long Id;
    private String email;

    private String fullName;

    private String address;

    private String state;

    private String city;

    private String zip;

    private String phone;



  public AddressBook(AddressBookDTO addressBookdto){
        this.fullName=addressBookdto.getFullName();
        this.address=addressBookdto.getAddress();
        this.city=addressBookdto.getCity();
        this.state=addressBookdto.getState();
        this.zip=addressBookdto.getZip();
        this.phone=addressBookdto.getPhone();
        this.email=addressBookdto.getEmail();
  }




}

