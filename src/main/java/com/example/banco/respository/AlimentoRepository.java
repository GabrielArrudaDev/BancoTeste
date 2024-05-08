package com.example.banco.respository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.banco.entity.Alimento;

public interface AlimentoRepository extends JpaRepository<Alimento, Long> {
    List<Alimento> findAllByOrderByIdAscNomeAscAlimentoAscHorarioAscObservacaoAsc();
}
