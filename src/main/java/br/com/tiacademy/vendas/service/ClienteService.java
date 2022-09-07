package br.com.tiacademy.vendas.service;

import br.com.tiacademy.vendas.domain.Cliente;
import br.com.tiacademy.vendas.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    public Cliente porID(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente criar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente editar(Long id, Cliente editado) {
        var recuperado = porID(id);

        if (Objects.isNull(recuperado)) {
            throw new RuntimeException("Não foi encontrado!");
        }

        recuperado.setNome(editado.getNome());
        return clienteRepository.save(recuperado);
    }

    public void excluir(Long id) {
        clienteRepository.deleteById(id);
    }
}
