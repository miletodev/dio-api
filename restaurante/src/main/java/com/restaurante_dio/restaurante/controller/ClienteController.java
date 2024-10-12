package com.restaurante_dio.restaurante.controller;

import com.restaurante_dio.restaurante.model.Cliente;
import com.restaurante_dio.restaurante.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Cliente>registrarCliente(@RequestBody Cliente cliente) {
        Cliente registrado = clienteService.registrarCliente(cliente);
        return ResponseEntity.ok(registrado);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long id) {
        clienteService.buscarClientePorId(id).map(ResponseEntity.notFound().build());
    }
}
