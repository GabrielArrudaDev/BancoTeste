package com.example.banco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.banco.entity.Alimento;
import com.example.banco.service.AlimentoService;


@RestController
@RequestMapping("/api/alimentos")
public class AlimentoController {

    @Autowired
    private AlimentoService alimentoService;

    @GetMapping
    public List<Alimento> listarAlimentos() {
        return alimentoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Alimento encontrarAlimentoPorId(@PathVariable Long id) {
        return alimentoService.encontrarPorId(id);
    }

    @PostMapping
    public Alimento adicionarAlimento(@RequestBody Alimento alimento) {
        return alimentoService.salvar(alimento);
    }

    @PutMapping("/{id}")
    public Alimento atualizarAlimento(@PathVariable Long id, @RequestBody Alimento alimentoAtualizado) {
        Alimento alimento = alimentoService.encontrarPorId(id);
        if (alimento != null) {
            alimento.setNome(alimentoAtualizado.getNome());
            alimento.setAlimento(alimentoAtualizado.getAlimento());
            alimento.setHorario(alimentoAtualizado.getHorario());
            alimento.setObservacao(alimentoAtualizado.getObservacao());
            // Atualize outras informações aqui
            return alimentoService.salvar(alimento);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void excluirAlimento(@PathVariable Long id) {
        alimentoService.excluir(id);
    }
}

