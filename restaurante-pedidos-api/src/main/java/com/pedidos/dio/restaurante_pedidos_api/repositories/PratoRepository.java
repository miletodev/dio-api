package com.pedidos.dio.restaurante_pedidos_api.repositories;

import com.pedidos.dio.restaurante_pedidos_api.model.Prato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PratoRepository extends JpaRepository<Prato, Long> {

    Optional<Object> findById(Long id);
}
