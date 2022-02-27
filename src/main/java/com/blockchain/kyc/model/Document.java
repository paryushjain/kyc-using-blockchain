package com.blockchain.kyc.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name="document")
@Entity
public class Document {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String documentType;
    private String isVerified;
    private String rejectReason;
    private String additionalComment;
    private String url;
}
