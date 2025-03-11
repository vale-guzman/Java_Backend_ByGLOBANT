package com.egg.biblioteca.services;

import com.egg.biblioteca.entities.Usuario;
import com.egg.biblioteca.enumeraciones.Rol;
import com.egg.biblioteca.exceptions.MyException;
import com.egg.biblioteca.repositories.UsuarioRepositorio;
import jakarta.servlet.http.HttpSession;
// import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.List;


@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;


    public void registrar (String nombre, String email, String password, String password2) throws MyException{
        validar(nombre, email, password, password2);
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setEmail(email);
        usuario.setPassword(new BCryptPasswordEncoder().encode(password));
        usuario.setRol(Rol.USER);
        usuarioRepositorio.save(usuario);
    }

    private void validar(String nombre, String email, String password, String password2) throws MyException {


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
    @Override //cargar el usuario según el nombre de usuario (por email) y retornar una lista de permisos.
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepositorio.findByEmail(email);

        if (usuario != null) {

            List<GrantedAuthority> permisos = new ArrayList<>();

            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_"+ usuario.getRol().toString());

            permisos.add(p);
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpSession session = attr.getRequest().getSession(true);
            session.setAttribute("usuariosession", usuario);

            return new User(usuario.getEmail(), usuario.getPassword(),permisos);
        }else{
            return null;
        }
    }
}
