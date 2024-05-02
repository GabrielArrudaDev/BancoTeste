package com.example.banco.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.banco.entity.Medicamento;
import com.example.banco.service.MedicamentoService;

import java.util.List;

@RestController
@RequestMapping("/api/medicamentos")
public class MedicamentoController {

    private final MedicamentoService medicamentoService;

    public MedicamentoController(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    @GetMapping
    public List<Medicamento> getAllMedicamentos() {
        return medicamentoService.getAllMedicamentos();
    }

    @PostMapping
    public ResponseEntity<Medicamento> createMedicamento(@RequestBody Medicamento medicamento) {
        Medicamento novoMedicamento = medicamentoService.createMedicamento(medicamento);
        return new ResponseEntity<>(novoMedicamento, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medicamento> updateMedicamento(@PathVariable Long id, @RequestBody Medicamento medicamento) {
        Medicamento medicamentoAtualizado = medicamentoService.updateMedicamento(id, medicamento);
        return new ResponseEntity<>(medicamentoAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicamento(@PathVariable Long id) {
        medicamentoService.deleteMedicamento(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


