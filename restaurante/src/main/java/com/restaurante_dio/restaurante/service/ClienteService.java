package com.restaurante_dio.restaurante.service;

import com.restaurante_dio.restaurante.model.Cliente;
import com.restaurante_dio.restaurante.model.Endereco;
import com.restaurante_dio.restaurante.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final ViaCepService viaCepService;

    public ClienteService(ClienteRepository clienteRepository, ViaCepService viaCepService) {
        this.clienteRepository = clienteRepository;
        this.viaCepService = viaCepService;
    }

    public Cliente registrarCliente(Cliente cliente) {
        if (cliente.getEndereco() != null && cliente.getEndereco().getCep() != null) {
            Endereco enderecoPreenchido = viaCepService.consultarCep(cliente.getEndereco().getCep());
            if (enderecoPreenchido != null) { //Atualiza os campos que são nulos no cliente com os retornos da API
                atualizarCampoEndereco(cliente.getEndereco(), enderecoPreenchido);
            }
        }

        return clienteRepository.save(cliente);
    }

    private void atualizarCampoEndereco(Endereco enderecoCliente, Endereco enderecoPreenchido) {
        if (isCampoVazio(enderecoCliente.getLogradouro())) {
            enderecoCliente.setLogradouro(enderecoPreenchido.getLogradouro());
        } else if (isCampoVazio(enderecoCliente.getBairro())) {
            enderecoCliente.setBairro(enderecoPreenchido.getBairro());
        } else (isCampoVazio(enderecoCliente.getLocalidade())) {
            enderecoCliente.setLocalidade(enderecoPreenchido.getLocalidade());
        }
        registrarCliente().setEndereco(enderecoCliente);
    }
 private boolean isCampoVazio(String campo) {
        return campo == null || campo.isEmpty();
 }

 public Optional<Cliente>buscarClientePorId(Long id) {
        return clienteRepository.findById(id);
 }
}
