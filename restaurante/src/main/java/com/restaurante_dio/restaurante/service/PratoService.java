package com.restaurante_dio.restaurante.service;

import com.restaurante_dio.restaurante.model.Prato;
import com.restaurante_dio.restaurante.repository.PratoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PratoService {

    private final PratoRepository pratoRepository;

    public PratoService(PratoRepository pratoRepository) {
        this.pratoRepository = pratoRepository;
    }

    public List<Prato> listarPratosDisponiveis() {
        return pratoRepository.findByDisponivel(true);
    }

    public Prato adicionarPrato(Prato prato) {
        return pratoRepository.save(prato);
    }

    public Optional<Prato> buscarPratoPorId(Long id) {
        return pratoRepository.findById(id);
    }

    public Prato atualizarDisponibilidade(Long id, boolean disponivel) {
        Prato prato = pratoRepository.findById(id).orElseThrow(() -> new RuntimeException("Prato não encontrado"));
        prato.setDisponivel(disponivel);
        return pratoRepository.save(prato);
    }
}
