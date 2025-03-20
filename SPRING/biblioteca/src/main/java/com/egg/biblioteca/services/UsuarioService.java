package com.egg.biblioteca.services;

import com.egg.biblioteca.entities.Imagen;
import com.egg.biblioteca.entities.Usuario;
import com.egg.biblioteca.enumeraciones.Rol;
import com.egg.biblioteca.exceptions.MyException;
import com.egg.biblioteca.repositories.UsuarioRepositorio;
import jakarta.servlet.http.HttpSession;
// import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private ImagenService imagenService;

    public void registrar(MultipartFile archivo, String nombre, String email, String password, String password2) throws MyException {

        validar(nombre, email, password, password2);
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setEmail(email);
        usuario.setPassword(new BCryptPasswordEncoder().encode(password));
        usuario.setRol(Rol.USER);

        Imagen imagen = imagenService.guardar(archivo);
        usuario.setImagen(imagen);
        usuarioRepositorio.save(usuario);
    }

    private void validar(String nombre, String email, String password, String password2) throws MyException {

        //no es obligatorio cargar una imagen al momento de crear un usuario.

        if (nombre.isEmpty() || nombre == null) {
            throw new MyException("el nombre no puede ser nulo o estar vacío");
        }
        if (email.isEmpty() || email == null) {
            throw new MyException("el email no puede ser nulo o estar vacío");
        }
        if (password.isEmpty() || password == null || password.length() <= 5) {
            throw new MyException("La contraseña no puede estar vacía, y debe tener más de 5 dígitos");
        }
        if (!password.equals(password2)) {
            throw new MyException("Las contraseñas ingresadas deben ser iguales");
        }
    }

    public void actualizar(MultipartFile archivo, UUID id, String nombre, String email, String password, String password2) throws MyException {

        validar(nombre, email, password, password2);

        Optional<Usuario> respuesta = usuarioRepositorio.findById(id);
        if (respuesta.isPresent()) {

            //Si el usuario está presente, actualizamos sus atributos
            Usuario usuario = respuesta.get();
            usuario.setNombre(nombre);
            usuario.setEmail(email);
            usuario.setPassword(new BCryptPasswordEncoder().encode(password));
            usuario.setRol(Rol.USER);

            //Antes de persistir, creamos una variable para guardar el id de la imagen.
            UUID idImagen = null;

            //Verificamos que si una imagen existe en este usuario, le guardamos ese id de imagen
            if (usuario.getImagen() != null) {
                idImagen = usuario.getImagen().getId();
            }

            //Creo una imagen y se lo paso al método Actualizar con el archivo y el id anterior de la Imagen
            //De este modo, pisamos la imagen guardada por esta nueva.
            Imagen imagen = imagenService.actualizar(archivo, idImagen);
            //seteo la imagen nueva
            usuario.setImagen(imagen);

            //persisitmos el usuario con todos los datos nuevos.
            usuarioRepositorio.save(usuario);
        }
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> usuariosList = new ArrayList<>();
        usuariosList = usuarioRepositorio.findAll();
        return usuariosList;
    }

    @Transactional
    public void cambiarRol(UUID id){
        Optional<Usuario>userEncontrado=usuarioRepositorio.findById(id);

        if(userEncontrado.isPresent()){
            Usuario usuario= userEncontrado.get();

            //le cambiamos un rol a otro, dependiendo del Rol que trae ese usuario
            if (usuario.getRol().equals(Rol.USER)){
                usuario.setRol(Rol.ADMIN);
            } else if(usuario.getRol().equals(Rol.ADMIN)){
                usuario.setRol(Rol.USER);
            }
        }
    }

    public Usuario getOne(UUID id){
         return usuarioRepositorio.findById(id).orElse(null);
    }

    @Override //cargar el usuario según el nombre de usuario (por email) y retornar una lista de permisos.
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepositorio.findByEmail(email);

        //verificamos si el usuario ingresó
        if (usuario != null) {

            List<GrantedAuthority> permisos = new ArrayList<>();
            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + usuario.getRol().toString());

            //le damos los permisos.
            permisos.add(p);

            //insertamos una llamada p/atrapar ese usuario autenticado y guardarlo en la sesión Web
            //esta llamada recupera los atrib. del request, es decir los atrb. de la solicitud Http ACTUAL.
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes(); //casteamos el tipo de dato que trae.

            //Vamos a pedir con .getRequest, los datos de la solicitud http ACTUAL que pedimos antes y,
            //con .getSession() los datos del usuario ACTUAL logueado.
            HttpSession session = attr.getRequest().getSession(true);

            //ahora, guardo el objeto Usuario, en la sesion. Seteandole los atributos y llamandole "usuariosession".
            session.setAttribute("usuariosession", usuario);

            return new User(usuario.getEmail(), usuario.getPassword(), permisos);
        } else {
            return null;
        }
    }
}


/* Recordar que tenemos un controlador que, debe direccionar al inicio.html para Usuarios comunes= USER
   En cambio, si se loguea un ADMIN, queremos que se direccione al dashboard (panel_form.html) */
