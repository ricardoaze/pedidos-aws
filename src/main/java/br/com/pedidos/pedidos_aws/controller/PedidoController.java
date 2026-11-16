package br.com.pedidos.pedidos_aws.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import jakarta.validation.Valid;
import br.com.pedidos.pedidos_aws.model.Pedido;
import br.com.pedidos.pedidos_aws.service.PedidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public Pedido cadastrar(@Valid @RequestBody Pedido pedido) {
        return pedidoService.cadastrar(pedido);
    }

    @GetMapping
    public List<Pedido> listar() {
        return pedidoService.listar();
    }

    @GetMapping("/{id}")
    public Pedido buscarPorId(@PathVariable Long id) {
        return pedidoService.buscarPorId(id);
    }
    @PutMapping("/{id}")
    public Pedido atualizar(
            @PathVariable Long id,
            @Valid @RequestBody Pedido pedido) {

        return pedidoService.atualizar(id, pedido);
    }
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        pedidoService.excluir(id);
    }
}

