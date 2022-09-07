package br.com.tiacademy.vendas.controller;

import br.com.tiacademy.vendas.domain.Cliente;
import br.com.tiacademy.vendas.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        var clientes = clienteService.listar();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> especifico(@PathVariable("id") Long id) {
        var resultado = clienteService.porID(id);

        if (Objects.isNull(resultado)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(resultado);
    }

    @PostMapping
    public ResponseEntity<Cliente> criar(@RequestBody Cliente cliente) {
        var salvo = clienteService.criar(cliente);
        return ResponseEntity.ok(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> editar(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.editar(id, cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        clienteService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
