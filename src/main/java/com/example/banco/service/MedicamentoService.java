package com.example.banco.service;

import org.springframework.stereotype.Service;

import com.example.banco.entity.Medicamento;
import com.example.banco.respository.MedicamentoRepository;

import java.util.List;

@Service
public class MedicamentoService {

    private final MedicamentoRepository medicamentoRepository;

    public MedicamentoService(MedicamentoRepository medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }

    public List<Medicamento> getAllMedicamentos() {
        return medicamentoRepository.findAll();
    }

    public Medicamento createMedicamento(Medicamento medicamento) {
        return medicamentoRepository.save(medicamento);
    }

    public Medicamento updateMedicamento(Long id, Medicamento medicamento) {
        Medicamento medicamentoExistente = medicamentoRepository.findById(id)
                .orElseThrow();

        medicamentoExistente.setNome(medicamento.getNome());
        medicamentoExistente.setMedicamento(medicamento.getMedicamento());
        medicamentoExistente.setTipo(medicamento.getTipo());
        medicamentoExistente.setDosagem(medicamento.getDosagem());
        medicamentoExistente.setHorario(medicamento.getHorario());
        medicamentoExistente.setObservacao(medicamento.getObservacao());

        return medicamentoRepository.save(medicamentoExistente);
    }

    public void deleteMedicamento(Long id) {
        medicamentoRepository.deleteById(id);
    }
}
