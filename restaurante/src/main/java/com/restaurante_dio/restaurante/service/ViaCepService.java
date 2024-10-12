package com.restaurante_dio.restaurante.service;

import com.restaurante_dio.restaurante.model.Endereco;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepService {
    private final RestTemplate restTemplate;

    public ViaCepService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Endereco consultarCep(String cep) {
        String url = String.format("https://viacep.com.br/ws/%s/json/", cep);
        Endereco endereco = restTemplate.getForObject(url, Endereco.class);
        return endereco;
    }
}
