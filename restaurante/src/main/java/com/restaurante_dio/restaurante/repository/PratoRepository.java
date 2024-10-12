package com.restaurante_dio.restaurante.repository;

import com.restaurante_dio.restaurante.model.Prato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PratoRepository extends JpaRepository<Prato, Long> {
    List<Prato> findByDisponivel(boolean disponivel);
}
