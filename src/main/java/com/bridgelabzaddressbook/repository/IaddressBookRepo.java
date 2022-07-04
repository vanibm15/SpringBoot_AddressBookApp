package com.bridgelabzaddressbook.repository;

import com.bridgelabzaddressbook.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface IaddressBookRepo extends JpaRepository<AddressBook,Long> {

}
