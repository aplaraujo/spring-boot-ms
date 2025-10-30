package com.example.pedido.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.pedido.model.ItemPedido;
import com.example.pedido.model.Pedido;
import com.example.pedido.repositories.PedidoRepository;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido salvaPedido(Pedido pedido) {
        if (pedido.getItens() != null) {
            for(ItemPedido item: pedido.getItens()) {
                item.setPedido(pedido);
            }
        }
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listaPedidos() {
        return pedidoRepository.findAll();
    }
}
