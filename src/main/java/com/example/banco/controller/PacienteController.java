package com.example.banco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.banco.entity.Paciente;
import com.example.banco.service.PacienteService;

import java.util.List;


@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<Paciente> listarPacientes() {
        return pacienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public Paciente encontrarPacientePorId(@PathVariable Long id) {
        return pacienteService.encontrarPorId(id);
    }

    @PostMapping
    public Paciente adicionarPaciente(@RequestBody Paciente paciente) {
        return pacienteService.salvar(paciente);
    }

    @PutMapping("/{id}")
    public Paciente atualizarPaciente(@PathVariable Long id, @RequestBody Paciente pacienteAtualizado) {
        Paciente paciente = pacienteService.encontrarPorId(id);
        if (paciente != null) {
            paciente.setNome(pacienteAtualizado.getNome());
            paciente.setIdade(pacienteAtualizado.getIdade());
            paciente.setCondicao(pacienteAtualizado.getCondicao());
            // Atualize outras informações aqui
            return pacienteService.salvar(paciente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void excluirPaciente(@PathVariable Long id) {
        pacienteService.excluir(id);
    }
}
