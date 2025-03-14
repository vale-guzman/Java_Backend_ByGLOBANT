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
public class Imagen {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String mime; //es el atributo que asigna el formato del archivo de la imagen.
    private String nombre;

    @Lob @Basic(fetch = FetchType.LAZY) //Lob: le avisa a String, que este atributo puede ser Grande
                                        //Basic: le indicamos cómo va a ser el tipo de carga.
                                        //Lazy: hace que se cargue este atributo Solo cuando lo pidamos, es decir,solo cuando hagamos un .get
    private byte[] contenido; //almacenar datos binarios, como archivos.

}
