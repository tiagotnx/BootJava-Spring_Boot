package br.com.tiacademy.vendas.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendedor")
public class VendedorController {

    @GetMapping
    public ResponseEntity<String> nomeVendedor() {
        return ResponseEntity.ok("Tiago");
    }

}
