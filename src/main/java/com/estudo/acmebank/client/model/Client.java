package com.estudo.acmebank.client.model;


import com.estudo.acmebank.account.model.Account;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Entity
@Table(name="tb_Client")
public class Client {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;

    @Column(name="name")
    @NotBlank
    @Size(max = 60)
    private String name;

    @Column(name="login", unique = true)
    @NotBlank
    @Size(max = 60)
    private String login;

    @NotBlank
    @Email
    @Size(max = 255)
    @Column(name="email")
    private String email;

    @NotBlank
    @Size(max = 20)
    @Column(name="phone")
    private String phone;

    @NotBlank
    @Column(name="password")
    private String password;

    @NotBlank
    @CPF
    @Column(name="cpf")
    private String cpf;

    @OneToOne
    @JoinTable(name="tb_client_account",
        joinColumns = @JoinColumn(name="idClient"),
        inverseJoinColumns = @JoinColumn(name="idAccount"))
    private Account account;



    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }
}
