package com.restaurante_dio.restaurante.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL) //Cada pedido tem vários itens
    private List<ItemPedido> itens = new ArrayList<>();
    private boolean concluido = false;
    @ManyToOne(cascade = CascadeType.ALL) //Um cliente pode ter vários pedidos
    private Cliente cliente;

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public void removerItem(ItemPedido item) {
        itens.remover(item);
    }
}
