package com.example.banco.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.banco.entity.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {
    List<Medicamento> findAllByOrderByIdAscNomeAscMedicamentoAscTipoAscDosagemAscHorarioAscObservacaoAsc();
}

