package com.example.pedido.controllers;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
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

    private final RabbitTemplate rabbitTemplate;

    private final PedidoService pedidoService;

    public PedidoController(RabbitTemplate rabbitTemplate, PedidoService pedidoService) {
        this.rabbitTemplate = rabbitTemplate;
        this.pedidoService = pedidoService;
    }

    @Value("${broker.queue.processamento.name}")
    private String routingKey;

    @PostMapping
    public String criarPedido(@RequestBody Pedido pedido) {
        Pedido pedidoSalvo = pedidoService.salvaPedido(pedido);
        rabbitTemplate.convertAndSend("", routingKey, pedidoSalvo.getDescricao());
        return "Pedido salvo e enviado para processamento: " + pedido.getDescricao();
    }

    @GetMapping
    public List<Pedido> listaPedidos() {
        return pedidoService.listaPedidos();
    }
}
