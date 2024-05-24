package com.example.banco.respository;

import com.example.banco.entity.Diario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiarioRepository extends JpaRepository<Diario, Long> {
}
