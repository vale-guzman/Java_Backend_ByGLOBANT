package com.egg.biblioteca;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SeguridadWeb {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize
        //los únicos usuarios que podrán ingresar a la URL /admin serán los que tengan el rol "ADMIN"
                                .requestMatchers( "/admin/**").hasRole("ADMIN")
                                .requestMatchers("/css/**", "/js/**", "/img/**").permitAll()
                                .requestMatchers("/login", "/registrar").permitAll() // Permitir acceso a login y registro
                                .anyRequest().authenticated() //Requiere autenticacion
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/logincheck")  //Cuando se envía el formulario, se acciona hacia logincheck
                        .usernameParameter("email")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/inicio", true)
                        .permitAll())
                .logout((logout) -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                        .permitAll())
                .csrf(csrf -> csrf.disable()); // Spring Security lo trae intrínsecamente, lo deshabilitamos.
        return http.build();
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
