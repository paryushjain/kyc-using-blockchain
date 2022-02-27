package com.blockchain.kyc.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="bank")
public class Bank {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String nameOfBank;
    private String password;
}
