
package com.example.banco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.banco.entity.Alimento;
import com.example.banco.respository.AlimentoRepository;



@Service
public class AlimentoService {

    @Autowired
    private AlimentoRepository alimentoRepository;

    public List<Alimento> listarTodos() {
        return alimentoRepository.findAll();
    }

    public Alimento encontrarPorId(Long id) {
        return alimentoRepository.findById(id).orElse(null);
    }

    public Alimento salvar(Alimento alimento) {
        return alimentoRepository.save(alimento);
    }

    public void excluir(Long id) {
        alimentoRepository.deleteById(id);
    }
}

