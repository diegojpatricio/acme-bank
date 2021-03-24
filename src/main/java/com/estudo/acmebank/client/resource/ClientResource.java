package com.estudo.acmebank.client.resource;

import com.estudo.acmebank.client.model.Client;
import com.estudo.acmebank.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/clientes")
public class ClientResource {

    /**
     * No Spring, para marcar os pontos de injeção dentro da sua classe, você utiliza a anotação @Autowired.
     */
    @Autowired
    private ClientRepository cr;

    @GetMapping
    public List<Client> listarClientes(){

        return this.cr.findAll();
    }

    /**
     * O @Valid ativa a validação do Bean Validation para o paramento client.
     * Bean Validation é uma especificação que permite validar objetos com facilidade
     * em diferentes camadas da aplicação. A vantagem de usar Bean Validation é que as
     * restrições ficam inseridas nas classes de modelo.
     * */
    /**
     * ResponseEntity representa toda a resposta HTTP: código de status, cabeçalhos e corpo .
     * Como resultado, podemos usá-lo para configurar totalmente a resposta HTTP.
     * */

    @PostMapping
    public ResponseEntity<Client> addCliente(@Valid @RequestBody Client client){
        Client clientAdd = cr.save(client);

        return ResponseEntity.status(HttpStatus.CREATED).body(clientAdd);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> buscarCliente(@PathVariable Long id){
        Optional<Client> client = cr.findById(id);

        if(client.isPresent()) {
            return ResponseEntity.ok(client.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> atualizarPessoa(@PathVariable Long id, @RequestBody Client client){

        if (!cr.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        client.setIdClient(id);
        cr.save(client);

        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id){

        if (!cr.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        cr.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
