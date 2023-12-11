package com.example.terceranotaweb.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Usuario")
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @SequenceGenerator(name = "usuario_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_id_seq")

    private Integer id;
    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;

}
