package br.com.tiacademy.vendas.repository;

import br.com.tiacademy.vendas.core.crud.CrudRepositry;
import br.com.tiacademy.vendas.domain.Cliente;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepositry<Cliente, Long> {
}
