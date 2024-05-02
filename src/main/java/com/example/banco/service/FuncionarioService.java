package com.example.banco.service;

import org.springframework.stereotype.Service;

import com.example.banco.entity.Funcionario;
import com.example.banco.respository.FuncionarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> listarTodosFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Optional<Funcionario> encontrarFuncionarioPorId(Long id) {
        return funcionarioRepository.findById(id);
    }

    public Funcionario salvarFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public void deletarFuncionarioPorId(Long id) {
        funcionarioRepository.deleteById(id);
    }

    public List<Funcionario> findAllByOrderByIdAscNomeAscCpfAscFuncaoAsc() {
        return funcionarioRepository.findAllByOrderByIdAscNomeAscCpfAscFuncaoAsc();
    }
}

