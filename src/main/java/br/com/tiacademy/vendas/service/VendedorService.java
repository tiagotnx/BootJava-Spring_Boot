package br.com.tiacademy.vendas.service;

import br.com.tiacademy.vendas.domain.Vendedor;
import br.com.tiacademy.vendas.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    public List<Vendedor> listar() {
        return vendedorRepository.findAll();
    }

    public Vendedor porID(Long id) {
        return vendedorRepository.findById(id).orElse(null);
    }
}
