package com.example.pedido.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pedido.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
