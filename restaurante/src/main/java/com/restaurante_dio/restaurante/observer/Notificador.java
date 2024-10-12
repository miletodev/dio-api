package com.restaurante_dio.restaurante.observer;

import com.restaurante_dio.restaurante.model.Pedido;

public interface Notificador {
    void notificar(Pedido pedido);
}
