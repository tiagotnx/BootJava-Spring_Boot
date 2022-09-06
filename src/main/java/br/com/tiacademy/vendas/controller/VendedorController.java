package br.com.tiacademy.vendas.controller;

import br.com.tiacademy.vendas.domain.Vendedor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/vendedor")
public class VendedorController {

    @GetMapping
    public ResponseEntity<List<Vendedor>> listar() {
        return ResponseEntity.ok(vendedores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vendedor> especifico(@PathVariable("id") Long id) {
        var resultado = vendedores().stream().filter(vendedor -> vendedor.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (Objects.isNull(resultado)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(resultado);
    }

    private List<Vendedor> vendedores() {

        Vendedor dois = new Vendedor();
        dois.setId(2L);
        dois.setNome("Manuel");

        Vendedor um = new Vendedor();
        um.setId(1L);
        um.setNome("João");

        return Arrays.asList(um, dois);
    }

}
