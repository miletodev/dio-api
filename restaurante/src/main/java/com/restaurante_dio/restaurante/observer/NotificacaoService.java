package com.restaurante_dio.restaurante.observer;

import com.restaurante_dio.restaurante.model.Pedido;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificacaoService {
    private final List<Notificador> notificadores = new ArrayList<>();

    public NotificacaoService(List<Notificador> notificadores) {
        this.notificadores.addAll(notificadores);
    }

    public void notificarPedido(Pedido pedido) {
        notificadores.forEach(notificador -> notificador.notificar(pedido));
    }
}
