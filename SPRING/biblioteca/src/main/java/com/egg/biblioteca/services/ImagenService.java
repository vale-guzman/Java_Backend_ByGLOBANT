package com.egg.biblioteca.services;

import com.egg.biblioteca.entities.Imagen;
import com.egg.biblioteca.exceptions.MyException;
import com.egg.biblioteca.repositories.ImagenRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
public class ImagenService {

    //Llamado al repositorio para poder persistir con .save()
    @Autowired
    ImagenRepositorio imagenRepositorio;

    @Transactional
    //MutipartFile: es el tipo de Archivo en el que se va a almacenar la imagen
    public Imagen guardar(MultipartFile archivo) throws MyException {
        if (archivo != null && !archivo.isEmpty()) {
            try {
                Imagen imagen = new Imagen();
                //Seteamos los atributos desde el Archivo

                imagen.setMime(archivo.getContentType());
                imagen.setNombre(archivo.getOriginalFilename()); // Usar getOriginalFilename()
                imagen.setContenido(archivo.getBytes());
                return imagenRepositorio.save(imagen);
            } catch (IOException e) {
                System.err.println("Error al guardar la imagen: " + e.getMessage());
                return null;
            }
        } else {
            System.err.println("Archivo de imagen nulo o vacío.");
            return null;
        }
    }

    public Imagen actualizar(MultipartFile archivo, UUID id) throws MyException {

        if (archivo != null && !archivo.isEmpty()) { //ahora verifico que el archivo tenga contenido.
            try {

                Imagen imagen = new Imagen();

                //verfica que no esté vacío
                if (id != null) {
                    //lo busca
                    Optional<Imagen> respuesta = imagenRepositorio.findById(id);

                    //Si lo encuentra, lo guarda
                    if (respuesta.isPresent()) {
                        imagen = respuesta.get();
                    }
                }

                //le setea todos los datos que traiga desde el Archivo.
                imagen.setMime(archivo.getContentType());
                imagen.setNombre(archivo.getOriginalFilename());
                imagen.setContenido(archivo.getBytes());
                return imagenRepositorio.save(imagen);
            } catch (IOException e) {
                System.err.println("Error al guardar la imagen: " + e.getMessage());
                return null;
            }
        } else {
            System.err.println("Archivo de imagen nulo o vacío.");
            return null;
        }

    }
}
