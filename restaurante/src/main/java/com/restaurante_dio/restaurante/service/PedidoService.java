package com.restaurante_dio.restaurante.service;

import com.restaurante_dio.restaurante.model.Pedido;
import com.restaurante_dio.restaurante.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final NotificacaoService notificacaoService;
    
    public PedidoService(PedidoRepository pedidoRepository, NotificacaoService notificacaoService) {
        this.pedidoRepository = pedidoRepository;
        this.notificacaoService = notificacaoService;
    }
    
    public Pedido salvarPedido(Pedido pedido) {
        Pedido salvo = pedidoRepository.save(pedido);
        notificacaoService.notificarPedido(salvo);
        return salvo;
    }

    public List<Pedido> listarPedidosConcluidos() {
        return pedidoRepository.findByConcluido(true);
    }

    public Optional<Pedido> buscarPedidoPorId(Long id) {
        return pedidoRepository.findById(id);

        public Pedido atualizarStatusPedido(Long id, boolean concluido) {
            Pedido pedido = pedidoRepository.findById(id);

            pedido.setConcluido(concluido);

            return pedidoRepository.save(pedido);
        }
    }
}
