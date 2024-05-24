package com.example.banco.service;

import com.example.banco.entity.Diario;
import com.example.banco.respository.DiarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiarioService {

    @Autowired
    private DiarioRepository diarioRepository;

    public List<Diario> getAllDiarios() {
        return diarioRepository.findAll();
    }

    public Optional<Diario> getDiarioById(Long id) {
        return diarioRepository.findById(id);
    }

    public Diario createDiario(Diario diario) {
        return diarioRepository.save(diario);
    }

    public Optional<Diario> updateDiario(Long id, Diario diarioDetails) {
        return diarioRepository.findById(id).map(diario -> {
            diario.setNomePaciente(diarioDetails.getNomePaciente());
            diario.setFuncionario(diarioDetails.getFuncionario());
            diario.setFuncaoFuncionario(diarioDetails.getFuncaoFuncionario());
            diario.setDiario(diarioDetails.getDiario());
            diario.setData(diarioDetails.getData());
            diario.setHorario(diarioDetails.getHorario());
            return diarioRepository.save(diario);
        });
    }

    public boolean deleteDiario(Long id) {
        return diarioRepository.findById(id).map(diario -> {
            diarioRepository.delete(diario);
            return true;
        }).orElse(false);
    }
}
