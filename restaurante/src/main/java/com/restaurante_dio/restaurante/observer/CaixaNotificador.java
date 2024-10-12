package com.restaurante_dio.restaurante.observer;

import com.restaurante_dio.restaurante.model.Pedido;
import org.springframework.stereotype.Component;

@Component
public class CaixaNotificador implements Notificador{

    @Override
    public void notificar(Pedido pedido) {
        System.out.println("Novo pedido: ");
        System.out.println(pedido);
    }
}
