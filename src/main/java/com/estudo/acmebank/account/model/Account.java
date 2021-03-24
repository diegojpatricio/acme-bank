package com.estudo.acmebank.account.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name="tb_Account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAccount;


    @NotBlank
    @Size(max = 3)
    @Column(name="bankCode")
    private String bankCode;

    @NotBlank
    @Size(max = 60)
    @Column(name="bankName")
    private String bankName;

    @NotBlank
    @Size(max = 10)
    @Column(name="agency")
    private String agency;

    @NotBlank
    @Size(max = 10)
    @Column(name="currentAccount")
    private String currentAccount;

    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }
}
