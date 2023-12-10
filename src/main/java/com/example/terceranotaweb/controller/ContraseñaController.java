package com.example.terceranotaweb.controller;

import com.example.terceranotaweb.entities.Contraseña;
import com.example.terceranotaweb.services.ContraseñaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contraseñas")
public class ContraseñaController {

    @Autowired
    private ContraseñaService contraseñaService;

    @GetMapping
    public List<Contraseña> listarContraseñas() {
        return contraseñaService.listarContraseñas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contraseña> obtenerContraseñaPorId(@PathVariable Integer id) {
        Contraseña contraseña = contraseñaService.obtenerContraseñaPorId(id);
        if (contraseña != null) {
            return ResponseEntity.ok(contraseña);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Contraseña> crearContraseña(@RequestBody Contraseña contraseña) {
        Contraseña nuevaContraseña = contraseñaService.crearContraseña(contraseña);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaContraseña);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contraseña> actualizarContraseña(@PathVariable Integer id, @RequestBody Contraseña contraseña) {
        Contraseña contraseñaActualizada = contraseñaService.actualizarContraseña(id, contraseña);
        if (contraseñaActualizada != null) {
            return ResponseEntity.ok(contraseñaActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarContraseña(@PathVariable Integer id) {
        contraseñaService.eliminarContraseña(id);
        return ResponseEntity.noContent().build();
    }

}
