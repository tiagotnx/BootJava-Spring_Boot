package br.com.tiacademy.vendas.service;

import br.com.tiacademy.vendas.core.crud.CrudService;
import br.com.tiacademy.vendas.domain.Vendedor;
import org.springframework.stereotype.Service;

@Service
public class VendedorService extends CrudService<Vendedor, Long> {
    @Override
    protected Vendedor editarEntidade(Vendedor recuperado, Vendedor entidade) {
        recuperado.setNome(entidade.getNome());
        return recuperado;
    }
}
