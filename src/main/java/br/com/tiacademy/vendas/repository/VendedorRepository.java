package br.com.tiacademy.vendas.repository;

import br.com.tiacademy.vendas.core.crud.CrudRepositry;
import br.com.tiacademy.vendas.domain.Vendedor;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepository extends CrudRepositry<Vendedor, Long> {
}
