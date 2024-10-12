package com.restaurante_dio.restaurante.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Endereco {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;


}
