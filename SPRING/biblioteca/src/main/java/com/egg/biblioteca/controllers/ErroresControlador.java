package com.egg.biblioteca.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErroresControlador implements ErrorController {


    @RequestMapping(value = "/error", method = {RequestMethod.GET, RequestMethod.POST})
    /*Acá le decimos a nivel método, que todo recurso que venga con /error, sea del método que sea, ingrese a este método
    * este métod recibe una petición http                                     */
    public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {

        /* //Recuperamos el código de Error que viene del servidor, y en base a eso establecemos un
        * mensaje en particular para ese Error, y redireccionamos a la vista específica,
        * en este caso al error.html. */

        //El ModelAndView es como el ModelMap. Creamos una página de Error que acá adentro le llamamos errorPage
        //pero lo que trae de la manos es la vista error.html
        ModelAndView errorPage = new ModelAndView("error");

        String errorMsg = "";

        //Declaro un nuevo entero, donde guardo lo que me trae el método de abajo, pasandole por
        //parámetro el httpRequest que llega.
        Integer httpErrorCode = getErrorCode(httpRequest);

        if (httpErrorCode == -1) {
            httpErrorCode = 500; // Asigna un código de error por defecto
        }

        //en base a ese código de Status que obtenemos del 'getErrorCode', entramos al Switch.
        switch (httpErrorCode) {
            case 400: {
                errorMsg = "El recurso solicitado no existe.";
                break;
            }
            case 403: {
                errorMsg = "No tiene permisos para acceder al recurso.";
                break;
            }
            case 401: {
                errorMsg = "No se encuentra autorizado.";
                break;
            }
            case 404: {
                errorMsg = "El recurso solicitado no fue encontrado.";
                break;
            }
            case 500: {
                errorMsg = "Ocurrió un error interno.";
                break;
            }
            default: {
                errorMsg = "Se produjo un error inesperado.";
                break;
            }
        }

        /*Ahora inyectamos en nuestro error.html
         *bajo el nombre 'codigo': el nro. de código */
        errorPage.addObject("codigo", httpErrorCode);

        /*Y bajo el nombre 'mensaje': el mensaje de cada case del Switch.*/
        errorPage.addObject("mensaje", errorMsg);
        return errorPage;
    }


    /*Este método retorna el código de Status de la petición httpRequest */
    private int getErrorCode(HttpServletRequest httpRequest) {
        Object statusCode = httpRequest.getAttribute("jakarta.servlet.error.status_code");
        if (statusCode == null) {
            statusCode = httpRequest.getAttribute("javax.servlet.error.status_code"); //versión vieja
        }
        if (statusCode instanceof Integer) {
            return (Integer) statusCode;
        }
        // Maneja el caso en que el atributo es null o no es un Integer
        return -1; // O puedes usar otro valor por defecto adecuado
    }

}
