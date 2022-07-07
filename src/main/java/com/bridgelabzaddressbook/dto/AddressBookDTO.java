package com.bridgelabzaddressbook.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Data
@NoArgsConstructor
@ToString
public class AddressBookDTO {


    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "Invalid Name")
    private String fullName;

    @NotNull(message = "address should not be null")
    private String address;

    @NotNull(message = "state should not be null")
    private String state;

    @NotNull(message = "city should not be null")
    private String city;

    @NotBlank(message = "Zip cannot be null")
    private String zip;

    @NotNull(message = "phone number should not be null")
    private String phone;

    private String email;



}





