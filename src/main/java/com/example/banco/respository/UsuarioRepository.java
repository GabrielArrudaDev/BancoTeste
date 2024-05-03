package com.example.banco.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.banco.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}

