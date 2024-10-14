package com.pedidos.dio.restaurante_pedidos_api.controllers;

import com.pedidos.dio.restaurante_pedidos_api.Exceptions.ResourceNotFoundException;
import com.pedidos.dio.restaurante_pedidos_api.model.Prato;
import com.pedidos.dio.restaurante_pedidos_api.services.PratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.nodes.Tag;

import java.util.List;

@RestController
@RequestMapping("/cardapio")
@Tag(name = "Cardapio", description = "RESTful API para gerenciamento de cardápio")
public class PratoController {

    @Autowired
    private PratoService pratoService;

    // R: Listar todos os pratos
    @GetMapping
    @Operation(summary = "Listar todos os pratos")
    @ApiResponse(value = {
            @ApiResponse(responseCode = "200", description = "Lista de pratos retornada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhum prato encontrado")
    })
    public ResponseEntity<List<Prato>> findAll() {
        var pratos = pratoService.findAll();
        return ResponseEntity.ok(pratos);
    }

    // R: Buscar prato por ID
    @GetMapping("/{id}")
    public ResponseEntity<Prato> getPratoById(@PathVariable Long id) {
        Prato prato = pratoService.getPratoById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prato não encontrado: " + id));
        return ResponseEntity.ok().body(prato);
    }

    // C: Criar novo prato
    @PostMapping
    public Prato criarPrato(@RequestBody Prato prato) {
        return pratoService.criarPrato(prato);
    }

    // U: Atualizar prato
    @PutMapping("/{id}")
    public ResponseEntity<Prato> atualizarPrato(@PathVariable Long id, @RequestBody Prato pratoDetails) {
        Prato pratoAtualizado = pratoService.atualizarPrato(id, pratoDetails);
        return ResponseEntity.ok(pratoAtualizado);
    }

    // D: Deletar prato
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPrato(@PathVariable Long id) {
        pratoService.deletarPrato(id);
        return ResponseEntity.ok().build();
    }
}
