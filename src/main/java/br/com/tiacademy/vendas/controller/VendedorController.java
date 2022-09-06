package br.com.tiacademy.vendas.controller;

import br.com.tiacademy.vendas.domain.Vendedor;
import br.com.tiacademy.vendas.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/vendedor")
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;

    @GetMapping
    public ResponseEntity<List<Vendedor>> listar() {
        var vendedores = vendedorService.listar();
        return ResponseEntity.ok(vendedores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vendedor> especifico(@PathVariable("id") Long id) {
        var resultado = vendedorService.porID(id);

        if (Objects.isNull(resultado)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(resultado);
    }

    @PostMapping
    public ResponseEntity<Vendedor> criar(@RequestBody Vendedor vendedor) {
        var salvo = vendedorService.criar(vendedor);
        return ResponseEntity.ok(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vendedor> editar(@PathVariable("id") Long id, @RequestBody Vendedor vendedor) {
        return ResponseEntity.ok(vendedorService.editar(id, vendedor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        vendedorService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
