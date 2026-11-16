package br.com.pedidos.pedidos_aws.service;

import br.com.pedidos.pedidos_aws.model.Pedido;
import org.springframework.stereotype.Service;
import br.com.pedidos.pedidos_aws.repository.PedidoRepository;


import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido cadastrar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    public Pedido buscarPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() ->
                        new org.springframework.web.server.ResponseStatusException(
                                org.springframework.http.HttpStatus.NOT_FOUND,
                                "Pedido não encontrado: " + id




                        ));

    }

    public Pedido atualizar(Long id, Pedido pedidoAtualizado) {

        Pedido pedidoExistente = buscarPorId(id);

        pedidoExistente.setCliente(pedidoAtualizado.getCliente());
        pedidoExistente.setDescricao(pedidoAtualizado.getDescricao());
        pedidoExistente.setValor(pedidoAtualizado.getValor());

        return pedidoRepository.save(pedidoExistente);
    }

    public void excluir(Long id) {
        Pedido pedido = buscarPorId(id);
        pedidoRepository.delete(pedido);
    }

}



