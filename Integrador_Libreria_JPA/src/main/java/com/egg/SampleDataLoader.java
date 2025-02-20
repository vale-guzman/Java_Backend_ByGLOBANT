package com.egg;

import com.egg.servicios.AutorServicio;
import com.egg.servicios.EditorialServicio;
import com.egg.servicios.LibroServicio;

public class SampleDataLoader implements Runnable {
    @Override
    public void run() {
//        try {
//            AutorServicio autorService = new AutorServicio();
//            // Crear autores
//            System.out.println("Cargando autores...");
//            autorService.crearAutor("Gabriel García Márquez", true);
//            autorService.crearAutor("Paulo Coelho", true);
//            autorService.crearAutor("Antoine de Saint-Exupéry", true);
//            autorService.crearAutor("Oscar Wilde", true);
//            autorService.crearAutor("J.R.R. Tolkien", true);
//        } catch (Exception e) {
//            System.out.println("Error creando autores " + e.getMessage());
//        }
//        try {
//            EditorialServicio editorialService = new EditorialServicio();
//            // Crear editoriales
//            System.out.println("Cargando editoriales...");
//            editorialService.crearEditorial("Editorial Sudamericana", true);
//            editorialService.crearEditorial("Editorial Planeta", true);
//        } catch (Exception e) {
//            System.out.println("Error creando editoriales " + e.getMessage());
//        }
        try {
            LibroServicio libroService = new LibroServicio();
            // Crear libros
            System.out.println("Cargando libros...");
            libroService.crearLibro(9788437604947L, "Cien años de soledad", 1967, 471, true,34 ,17);
            libroService.crearLibro(9788437604948L, "El amor en los tiempos del cólera", 1985, 368, true, 34, 17);
            libroService.crearLibro(9788437604949L, "El coronel no tiene quien le escriba", 1961, 128, true, 34, 18);
            libroService.crearLibro(9788437604950L, "El ojo del mundo", 1964, 128, true, 34, 18);
            libroService.crearLibro(9788437604951L, "El libro de la selva", 1961, 128, true, 35, 18);
            libroService.crearLibro(9788437604952L, "El ruido y la furia", 1961, 128, true, 35, 17);
            libroService.crearLibro(9788437604953L, "El alquimista", 1988, 208, true, 36, 17);
            libroService.crearLibro(9788437604954L, "El principito", 1943, 96, true, 37, 17);
            libroService.crearLibro(9788437604955L, "El retrato de Dorian Gray", 1890, 352, true, 37, 18);
            libroService.crearLibro(9788437604967L, "El señor de los anillos: La comunidad del anillo", 1954, 576, true, 38, 18);
            libroService.crearLibro(9788437604968L, "El señor de los anillos: Las dos torres", 1954, 576, true, 38, 17);
            libroService.crearLibro(9788437604969L, "El señor de los anillos: El retorno del rey", 1955, 576, true, 38, 18);

        } catch (Exception e) {
            System.out.println("Error creando libros " + e.getMessage());
        }
    }
}
