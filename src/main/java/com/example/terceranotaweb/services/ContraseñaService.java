package com.example.terceranotaweb.services;

import com.example.terceranotaweb.entities.Contraseña;
import com.example.terceranotaweb.repository.ContraseñaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContraseñaService {
    @Autowired
    private ContraseñaRepository contraseñaRepository;

    public List<Contraseña> listarContraseñas() {
        return contraseñaRepository.findAll();
    }

    public Contraseña obtenerContraseñaPorId(Integer id) {
        return contraseñaRepository.findById(id).orElse(null);
    }

    public Contraseña crearContraseña(Contraseña contraseña) {
        return contraseñaRepository.save(contraseña);
    }

    public Contraseña actualizarContraseña(Integer id, Contraseña contraseña) {
        if (contraseñaRepository.existsById(id)) {
            contraseña.setId(id);
            return contraseñaRepository.save(contraseña);
        }
        return null; // Manejar la lógica de error según sea necesario
    }

    public void eliminarContraseña(Integer id) {
        contraseñaRepository.deleteById(id);
    }
}
