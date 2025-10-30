package com.example.processamento.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.processamento.dto.PedidoDTO;

@Component
public class ProcessamentoConsumer {

    @RabbitListener(queues="${broker.queue.processamento.name}")
    public void listenerProcessamentoQueue(PedidoDTO dto) {
        System.out.println(dto.getDescricao());
    }
}
