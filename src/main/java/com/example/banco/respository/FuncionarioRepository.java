package com.example.banco.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.banco.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    
    List<Funcionario> findAllByOrderByIdAscNomeAscCpfAscFuncaoAsc();
}