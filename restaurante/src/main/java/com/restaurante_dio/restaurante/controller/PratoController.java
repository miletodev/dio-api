package com.restaurante_dio.restaurante.controller;

import com.restaurante_dio.restaurante.model.Prato;
import com.restaurante_dio.restaurante.service.PratoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pratos")
public class PratoController {
    private final PratoService pratoService;

    public PratoController(PratoService pratoService) {
        this.pratoService = pratoService;
    }

    @GetMapping
    public ResponseEntity<List<Prato>>listarPratosDisponiveis() {
        List<Prato> pratos = pratoService.listarPratosDisponiveis();
        return ResponseEntity.ok(pratos);
    }

    @PostMapping
    public ResponseEntity<Prato> adicionarPrato(@RequestBody Prato prato) {
        Prato salvo = pratoService.adicionarPrato(prato);
        return ResponseEntity.ok(salvo);
    }

    @PutMapping("/caixa/dispobilidade")
    public ResponseEntity<Prato>atualizarDisponibilidade(@PathVariable Long id, @RequestParam boolean disponivel) {
        Prato atualizado = pratoService.atualizarDisponibilidade(id, disponivel);
        return ResponseEntity.ok(atualizado);
    }
}
