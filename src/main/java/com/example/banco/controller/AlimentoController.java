package com.example.banco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.banco.entity.Alimento;
import com.example.banco.respository.AlimentoRepository;

import java.util.List;


@RestController
@RequestMapping("/api/alimentos")
public class AlimentoController {
    @Autowired
    private AlimentoRepository alimentoRepository;

    @GetMapping
    public List<Alimento> getAllAlimentos() {
        return alimentoRepository.findAll();
    }

    @PostMapping
    public Alimento createAlimento(@RequestBody Alimento alimento) {
        return alimentoRepository.save(alimento);
    }

    @PutMapping("/{id}")
    public Alimento updateAlimento(@PathVariable Long id, @RequestBody Alimento novoAlimento) {
        return alimentoRepository.findById(id)
                .map(alimento -> {
                    alimento.setNome(novoAlimento.getNome());
                    alimento.setHorarios(novoAlimento.getHorarios());
                    alimento.setAlimentos(novoAlimento.getAlimentos());
                    alimento.setRestricoes(novoAlimento.getRestricoes());
                    return alimentoRepository.save(alimento);
                })
                .orElseGet(() -> {
                    novoAlimento.setId(id);
                    return alimentoRepository.save(novoAlimento);
                });
    }

    @DeleteMapping("/{id}")
    public void deleteAlimento(@PathVariable Long id) {
        alimentoRepository.deleteById(id);
    }
}
