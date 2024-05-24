package com.example.banco.controller;

import com.example.banco.entity.Diario;
import com.example.banco.service.DiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/diario")
public class DiarioController {

    @Autowired
    private DiarioService diarioService;

    @GetMapping
    public List<Diario> getAllDiarios() {
        return diarioService.getAllDiarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Diario> getDiarioById(@PathVariable Long id) {
        Optional<Diario> diario = diarioService.getDiarioById(id);
        return diario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Diario> createDiario(@RequestBody Diario diario) {
        try {
            Diario createdDiario = diarioService.createDiario(diario);
            return ResponseEntity.ok(createdDiario);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Diario> updateDiario(@PathVariable Long id, @RequestBody Diario diarioDetails) {
        try {
            Optional<Diario> updatedDiario = diarioService.updateDiario(id, diarioDetails);
            return updatedDiario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiario(@PathVariable Long id) {
        try {
            boolean deleted = diarioService.deleteDiario(id);
            return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }
}
