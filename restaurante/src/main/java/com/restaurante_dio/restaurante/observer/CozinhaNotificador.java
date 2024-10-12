package com.restaurante_dio.restaurante.observer;

import com.restaurante_dio.restaurante.model.Pedido;

public class CozinhaNotificador implements Notificador{

    @Override
    public void notificar(Pedido pedido) {
        System.out.println("Novo pedido: " + pedido.getId());
        System.out.println(pedido);
    }
}
