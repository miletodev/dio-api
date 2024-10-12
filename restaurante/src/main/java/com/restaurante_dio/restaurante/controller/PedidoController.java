package com.restaurante_dio.restaurante.controller;

import com.restaurante_dio.restaurante.model.ItemPedido;
import com.restaurante_dio.restaurante.model.Pedido;
import com.restaurante_dio.restaurante.model.Prato;
import com.restaurante_dio.restaurante.service.PedidoService;
import com.restaurante_dio.restaurante.service.PratoService;
import com.restaurante_dio.restaurante.dtos.PedidoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Optional;

@RestController
@RequestMapping("/api/pedidos")
@SessionAttributes("pedido")
public class PedidoController<pedidoDTO> {
    private final PratoService pratoService;
    private final PedidoService pedidoService;

    public PedidoController(PratoService pratoService, PedidoService pedidoService) {
        this.pratoService = pratoService;
        this.pedidoService = pedidoService;
    }

    @ModelAttribute("pedido")
    public Pedido getPedido() {
        return new Pedido();
    }

    @PostMapping("/adicionarItem")
    public ResponseEntity<Pedido> adicionarItem(@ModelAttribute("pedido")
                                                    Pedido pedido, @RequestBody PedidoDTO pedidoDTO) {
        Optional<Prato> pratoOpt = pratoService.buscarPratoPorId(pedidoDTO.getPratoId());
        if (pratoOpt.isPresent()) { Prato prato  = pratoOpt.get();
        if (!prato.isDisponivel()) {
            return ResponseEntity.badRequest().body(null);
        }
            ItemPedido item = new ItemPedido(prato, pedidoDTO.getQuantidade());
        
        pedidoAdicionarItem(item);
        return ResponseEntity.ok().body(pedido);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }
    @PostMapping("/removerItem")
    public ResponseEntity<Pedido> removerItem(@ModelAttribute("pedido") Pedido pedido,
                                              @RequestBody PedidoDTO, pedidoDTO) {
        Optional<Prato>pratoOpt = pratoService.buscarPratoPorId(pedidoDTO.getPratoId());
        if (pratoOpt.isPresent()) {
            Prato prato = pratoOpt.get();
            ItemPedido item = new ItemPedido(prato, pedidoDTO.getQuantidade());
            
            pedido.removerItem(item);
            return ResponseEntity.ok().body(pedido);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/concluir")
    public ResponseEntity<Pedido>concluirPedido(@ModelAttribute("pedido") Pedido pedido,
                                                @RequestBody PedidoDTO pedidoDTO, SessionStatus status) {
        pedido.setConcluido(true);
        Pedido salvo = pedidoService.salvarPedido(pedido);

        status.setComplete();
        return ResponseEntity.ok().body(salvo);
    }
}
