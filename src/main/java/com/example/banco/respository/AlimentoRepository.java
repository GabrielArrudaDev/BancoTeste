package com.example.banco.respository;

// AlimentoRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.banco.entity.Alimento;


@Repository
public interface AlimentoRepository extends JpaRepository<Alimento, Long> {
}
