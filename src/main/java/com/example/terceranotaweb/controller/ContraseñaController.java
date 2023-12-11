package com.example.terceranotaweb.controller;

import com.example.terceranotaweb.entities.Contraseña;
import com.example.terceranotaweb.repository.ContraseñaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/contraseñas")
public class ContraseñaController {

    @Autowired
    private ContraseñaRepository contraseñaRepository;

    @GetMapping
    public List<Contraseña> getCategoriaAll() {

        return contraseñaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Contraseña getCategoriasbyId(@PathVariable Integer id) {

        Optional<Contraseña> categoria = contraseñaRepository.findById(id);

        if (categoria.isPresent()) {
            return categoria.get();
        }

        return null;

    }

    @PostMapping
    public Contraseña postCategorias(@RequestBody Contraseña contraseña) {

        contraseñaRepository.save(contraseña);

        return contraseña;


    }


    @PutMapping("/{id}")
    public Contraseña putCategoriasbyId(@PathVariable Integer id, @RequestBody Contraseña categoria) {

        Optional<Contraseña> categoriaCurrent = contraseñaRepository.findById(id);

        if (categoriaCurrent.isPresent()) {

            Contraseña contraseñaReturn = categoriaCurrent.get();


            contraseñaReturn.setContraseña(categoria.getContraseña());



            contraseñaRepository.save(contraseñaReturn);

            return contraseñaReturn;
        }

        return null;

    }

    @DeleteMapping("/{id}")
    public Contraseña deleteCategoriasbyId(@PathVariable Integer id) {

        Optional<Contraseña> contraseña = contraseñaRepository.findById(id);

        if (contraseña.isPresent()) {

            Contraseña contraseñaReturn = contraseña.get();

            contraseñaRepository.deleteById(id);

            return contraseñaReturn;
        }

        return null;

    }


   }

}
