package com.blockchain.kyc.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name="customer")
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String password;
    private String email;
    private String aadharNo;
    private String panNo;
    private String address;
    private String phoneNo;
    private String nationality;
    private String gender;
    private String selectedBank;
    private String isAccountVerified;
    //private List<Document> documentList;

}

/*{
        "firstName":"Paryush",
        "middleName":"Mukesh",
        "lastName":"Jain",
        "password":"123",
        "email":"paryushjain@gmail.com",
        "aadharNo":"1234567890",
        "panNo":"ABCD1234",
        "address":"Nagpur",
        "phoneNo":"1234567890",
        "nationality":"Indian",
        "gender":"Male"
        }*/
