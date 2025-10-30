package com.example.pedido.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pedido.model.Pedido;
import com.example.pedido.services.PedidoService;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public String criarPedido(@RequestBody Pedido pedido) {
        pedidoService.salvaPedido(pedido);
        return "Pedido salvo e enviado para processamento: " + pedido.getDescricao();
    }

    @GetMapping
    public List<Pedido> listaPedidos() {
        return pedidoService.listaPedidos();
    }
}
