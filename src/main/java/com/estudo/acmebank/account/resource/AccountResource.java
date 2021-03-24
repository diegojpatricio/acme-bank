package com.estudo.acmebank.account.resource;

import com.estudo.acmebank.account.model.Account;
import com.estudo.acmebank.account.repository.AccountRepository;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/contas")
public class AccountResource {

    @Autowired
    private AccountRepository ar;

    @GetMapping
    public List<Account> listarContas(){
        return this.ar.findAll();
    }

    @PostMapping
    public ResponseEntity<Account> addCliente(@Valid @RequestBody Account account){
        Account accountAdd = ar.save(account);

        return ResponseEntity.status(HttpStatus.CREATED).body(accountAdd);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> buscarConta(@PathVariable Long id){
        Optional<Account> account = ar.findById(id);

        if(account.isPresent()) {
            return ResponseEntity.ok(account.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> atualizarConta(@PathVariable Long id, @RequestBody Account account){

        if (!ar.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        account.setIdAccount(id);
        ar.save(account);

        return ResponseEntity.ok(account);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarConta(@PathVariable Long id){

        if (!ar.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        ar.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
