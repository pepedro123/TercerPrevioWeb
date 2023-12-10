package com.example.terceranotaweb.repository;

import com.example.terceranotaweb.entities.Contraseña;
import com.example.terceranotaweb.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContraseñaRepository extends JpaRepository <Contraseña, Integer>{
}
