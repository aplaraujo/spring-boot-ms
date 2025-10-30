package com.example.pedido.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pedido.model.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long>{

}
