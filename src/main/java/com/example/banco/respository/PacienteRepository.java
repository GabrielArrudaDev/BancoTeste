package com.example.banco.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.banco.entity.Paciente;


public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}

