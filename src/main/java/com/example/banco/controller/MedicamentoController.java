package com.example.banco.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.banco.entity.Medicamento;
import com.example.banco.service.MedicamentoService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/medicamentos")
public class MedicamentoController {

    private final MedicamentoService medicamentoService;

    // Adicionando um logger
    private static final Logger logger = LoggerFactory.getLogger(MedicamentoController.class);

    public MedicamentoController(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    @GetMapping
    public List<Medicamento> getAllMedicamentos() {
        logger.info("Recebida requisição para buscar todos os medicamentos.");
        return medicamentoService.getAllMedicamentos();
    }

    @PostMapping
    public ResponseEntity<Medicamento> createMedicamento(@RequestBody Medicamento medicamento) {
        logger.info("Recebida requisição para criar um novo medicamento: {}", medicamento);
        Medicamento novoMedicamento = medicamentoService.createMedicamento(medicamento);
        return new ResponseEntity<>(novoMedicamento, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medicamento> updateMedicamento(@PathVariable Long id, @RequestBody Medicamento medicamento) {
        logger.info("Recebida requisição para atualizar o medicamento com ID {}: {}", id, medicamento);
        Medicamento medicamentoAtualizado = medicamentoService.updateMedicamento(id, medicamento);
        return new ResponseEntity<>(medicamentoAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicamento(@PathVariable Long id) {
        logger.info("Recebida requisição para excluir o medicamento com ID {}.", id);
        medicamentoService.deleteMedicamento(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
