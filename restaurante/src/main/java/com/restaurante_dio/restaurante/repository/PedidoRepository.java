package com.restaurante_dio.restaurante.repository;

import com.restaurante_dio.restaurante.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByConcluido(boolean concluido);
}
