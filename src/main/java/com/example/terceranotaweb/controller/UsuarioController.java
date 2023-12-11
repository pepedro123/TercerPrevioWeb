package com.example.terceranotaweb.controller;

import com.example.terceranotaweb.entities.Usuario;
import com.example.terceranotaweb.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> getUsuarioAll() {

        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Usuario getUsuariosbyId(@PathVariable Integer id) {

        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (usuario.isPresent()) {
            return usuario.get();
        }

        return null;

    }

    @PostMapping
    public Usuario postUsuarios(@RequestBody Usuario usuario) {

        usuarioRepository.save(usuario);

        return usuario;


    }


    @PutMapping("/{id}")
    public Usuario putUsuariosbyId(@PathVariable Integer id, @RequestBody Usuario usuario) {

        Optional<Usuario> usuarioCurrent = usuarioRepository.findById(id);

        if (usuarioCurrent.isPresent()) {

            Usuario usuarioReturn = usuarioCurrent.get();


            usuarioReturn.setNombre(usuario.getNombre());
            usuarioReturn.setApellido(usuario.getApellido());
            usuarioReturn.setCedula(usuario.getCedula());
            usuarioReturn.setTelefono(usuario.getTelefono());



            usuarioRepository.save(usuarioReturn);

            return usuarioReturn;
        }

        return null;

    }

    @DeleteMapping("/{id}")
    public Usuario deleteUsuariosbyId(@PathVariable Integer id) {

        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (usuario.isPresent()) {

            Usuario usuarioReturn = usuario.get();

            usuarioRepository.deleteById(id);

            return usuarioReturn;
        }

        return null;

    }

}
