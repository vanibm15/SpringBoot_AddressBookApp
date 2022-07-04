package com.bridgelabzaddressbook.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AddressBook {


    @Id
    @GeneratedValue


    private long Id;

    private String fullName;

    private String address;

    private String state;

    private String city;

    private String zip;

    private String phone;

    public AddressBook(long id, String fullName, String address, String state, String city, String zip, String phone) {
        Id = id;
        this.fullName = fullName;
        this.address = address;
        this.state = state;
        this.city = city;
        this.zip = zip;
        this.phone = phone;
    }

    public AddressBook() {

    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "Id=" + Id +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

