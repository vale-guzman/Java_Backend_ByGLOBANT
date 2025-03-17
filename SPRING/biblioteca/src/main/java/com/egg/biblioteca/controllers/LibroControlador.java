package com.egg.biblioteca.controllers;

import com.egg.biblioteca.entities.Autor;
import com.egg.biblioteca.entities.Editorial;
import com.egg.biblioteca.entities.Libro;
import com.egg.biblioteca.exceptions.MyException;
import com.egg.biblioteca.services.AutorService;
import com.egg.biblioteca.services.EditorialService;
import com.egg.biblioteca.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/libro") //http://localhost:8080/editorial
public class LibroControlador {
    @Autowired
    private LibroService libroService;

    @Autowired
    private AutorService autorService;

    @Autowired
    private EditorialService editorialService;

    @GetMapping("/registrar")//localhost:8080/libro/registrar
    public String registrar(ModelMap modelMap){
        List<Autor> autores=autorService.listarAutores();
        List<Editorial> editoriales=editorialService.listarEditoriales();
        modelMap.addAttribute("autores",autores);
        modelMap.addAttribute("editoriales",editoriales);
        return "libro_form.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam(required = false) Long isbn, @RequestParam String titulo,
                           @RequestParam(required = false) Integer ejemplares, @RequestParam UUID idAutor,
                           @RequestParam UUID idEditorial,
                           ModelMap modelMap) {
        try {
            libroService.crearLibro(isbn, titulo, ejemplares, idAutor, idEditorial);
            modelMap.put("exito","El Libro fué cargado Correctamente");

        } catch (MyException ex) {
            modelMap.put("error", ex.getMessage());
            return "libro_form.html"; // volvemos a cargar el formulario.
        }
        return "index.html";
    }
    @GetMapping("/listar") // http://localhost:8080/libro/listar
    public String listar (ModelMap modelMap){

        List<Libro> libros = libroService.listarLibros();
        modelMap.addAttribute("libros", libros);
        return "libro_list.html";

    }

    @GetMapping ("/modificar/{isbn}")
    public String modificar (@PathVariable Long isbn,ModelMap modelMap){

        Libro libro=libroService.getOne(isbn);

        modelMap.put("libro", libroService.getOne(isbn));
        modelMap.addAttribute("autores", autorService.listarAutores()); //traigo la lista de autores
        modelMap.addAttribute("editoriales", editorialService.listarEditoriales());//traigo las editoriales

        //traigo el id del Autor/editorial actual, para que aparezcan seleccionados
        modelMap.addAttribute("autorSeleccionado",libro.getAutor().getId());
        modelMap.addAttribute("editorialSeleccionada", libro.getEditorial().getId());
            return "libro_modificar.html"; //es el mismo form que para cargar un libro
    }

    @PostMapping ("/modificar/{isbn}")
    public String modificar(@PathVariable @RequestParam(required = false) Long isbn,
                            @RequestParam(required = false) int ejemplares, @RequestParam String titulo,
                            @RequestParam UUID idAutor, @RequestParam UUID idEditorial,
                            ModelMap modelMap){
        try{
            if (idAutor == null || idEditorial == null) {
                throw new MyException("Debe seleccionar un autor y una editorial válidos.");
            }

            libroService.modificarLibro(titulo,ejemplares,idAutor,idEditorial,isbn);
            modelMap.put("exito","El libro " + titulo+ ", fué Modificado Correctamente");
            return "redirect:../listar";
        }catch  (MyException ex){
            modelMap.addAttribute("autores", autorService.listarAutores());
            modelMap.addAttribute("editoriales", editorialService.listarEditoriales());
            modelMap.put("error", ex.getMessage());
            return "libro_modificar.html";
        }
    }

}
