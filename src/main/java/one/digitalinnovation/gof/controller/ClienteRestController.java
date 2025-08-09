package one.digitalinnovation.gof.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.service.ClienteService;

import java.net.URI;
import java.util.Optional;

/**
 * Esse {@link RestController} representa nossa <b>Facade</b>, pois abstrai toda
 * a complexidade de integrações (Banco de Dados H2 e API do ViaCEP) em uma
 * interface simples e coesa (API REST).
 * 
 * @author falvojr
 */
@RestController
@RequestMapping("clientes")
public class ClienteRestController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<Iterable<Cliente>> buscarTodos() {
        return ResponseEntity.ok(clienteService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        Optional<Cliente> cliente = clienteService.buscarPorId(id);
        return cliente.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cliente> inserir(@Valid @RequestBody Cliente cliente) {
        clienteService.inserir(cliente);
        return ResponseEntity
                .created(URI.create("/clientes/" + cliente.getId()))
                .body(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
        Optional<Cliente> existente = clienteService.buscarPorId(id);
        if (existente.isPresent()) {
            clienteService.atualizar(id, cliente);
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<Cliente> existente = clienteService.buscarPorId(id);
        if (existente.isPresent()) {
            clienteService.deletar(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
