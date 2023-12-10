package com.example.terceranotaweb.repository;

import com.example.terceranotaweb.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository  extends JpaRepository <Usuario, Integer>{
}
