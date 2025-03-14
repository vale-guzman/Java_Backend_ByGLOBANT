package com.egg.biblioteca.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table (name="autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    //@GenericGenerator(name = "uuid", strategy = "uuid2") está deprecado.
    private UUID id;

    String nombre;
}
