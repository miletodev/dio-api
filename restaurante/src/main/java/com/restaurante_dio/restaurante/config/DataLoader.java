package com.restaurante_dio.restaurante.config;

import com.restaurante_dio.restaurante.model.Prato;
import com.restaurante_dio.restaurante.repository.PratoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final PratoRepository pratoRepository;

    public DataLoader(PratoRepository pratoRepository) {
        this.pratoRepository = pratoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (pratoRepository.count() == 0) {
            Prato prato1 = new Prato("Bolo 41", "Ao contrário do bolo 42, o bolo 41 é uma grande mistura de nada com nada!", 41.99, true);
            pratoRepository.save(prato1);

            System.out.println("Prato inicial carregado no banco de dados");
        }
    }
}
