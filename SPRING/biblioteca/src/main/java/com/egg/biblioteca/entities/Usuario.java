package com.egg.biblioteca.entities;

import com.egg.biblioteca.enumeraciones.Rol;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nombre;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    @OneToOne
    @JoinColumn (name="id_Imagen")
    private Imagen imagen;

}
