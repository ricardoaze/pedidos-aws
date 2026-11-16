package br.com.pedidos.pedidos_aws.repository;

import br.com.pedidos.pedidos_aws.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
