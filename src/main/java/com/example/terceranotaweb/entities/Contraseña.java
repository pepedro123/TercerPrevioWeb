package com.example.terceranotaweb.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Contraseña")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contraseña {
    @Id
    @SequenceGenerator(name = "contraseña_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contraseña_id_seq")
    private Integer id;
    private String contraseña;
}
