package com.restaurante_dio.restaurante.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PedidoDTO {
    private Long pratoId;
    private String codigo;
    private String descricao;
    private int quantidade;
    private BigDecimal preco;
    private String observacao;
}
