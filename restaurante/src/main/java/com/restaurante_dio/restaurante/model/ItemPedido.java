package com.restaurante_dio.restaurante.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor;
@Entity
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
        private Prato prato;
        private int quantidade;
    public ItemPedido(Prato prato, int quantidade) {
        this.prato = prato;
        this.quantidade = quantidade;
    }
}
