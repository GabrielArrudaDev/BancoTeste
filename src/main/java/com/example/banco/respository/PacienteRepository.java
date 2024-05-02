package com.example.banco.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.banco.entity.Paciente;
import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    List<Paciente> findAllByOrderByIdAscNomeAscIdadeAscCondicaoAsc();
}
