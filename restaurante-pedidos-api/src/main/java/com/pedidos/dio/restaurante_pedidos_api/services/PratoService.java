package com.pedidos.dio.restaurante_pedidos_api.services;

import com.pedidos.dio.restaurante_pedidos_api.Exceptions.ResourceNotFoundException;
import com.pedidos.dio.restaurante_pedidos_api.model.Prato;
import com.pedidos.dio.restaurante_pedidos_api.repositories.PratoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PratoService {

    @Autowired
    private PratoRepository pratoRepository;

    // Listar todos os pratos
    public List<Prato> findAll() {
        return pratoRepository.findAll();
    }

    // Buscar prato por ID
    public Optional<Prato> getPratoById(Long id) {
        return pratoRepository.findById(id);
    }

    // Criar novo prato
    public Prato criarPrato(Prato prato) {
        return pratoRepository.save(prato);
    }

    // Atualizar prato existente
    public Prato atualizarPrato(Long id, Prato pratoDetails) {
        Prato prato = pratoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prato não encontrado: " + id));

        prato.setNome(pratoDetails.getNome());
        prato.setPreco(pratoDetails.getPreco());
        prato.setDescricao(pratoDetails.getDescricao());
        prato.setCategoria(pratoDetails.getCategoria());
        prato.setDisponivel(pratoDetails.isDisponivel());

        return pratoRepository.save(prato);
    }

    // Deletar prato
    public void deletarPrato(Long id) {
        Prato prato = pratoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prato não encontrado: " + id));
        pratoRepository.delete(prato);
    }
}
