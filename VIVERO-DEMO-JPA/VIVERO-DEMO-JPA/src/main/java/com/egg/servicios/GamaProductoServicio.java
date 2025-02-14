package com.egg.servicios;

import com.egg.entidades.Cliente;
import com.egg.entidades.GamaProducto;
import com.egg.persistencia.ClienteDAO;
import com.egg.persistencia.GamaProductoDAO;

public class GamaProductoServicio {
    private final GamaProductoDAO gamaProductoDAO;// Instancio a la unidad de persistencia para acceder a los metodos del EM

    public GamaProductoServicio() {
        this.gamaProductoDAO = new GamaProductoDAO();
    }

    public void crearGama(String descripcionTexto, String descripcionHtml, String imagen, String gama) {

        try {
            // Crear una nueva instancia de GamaProducto
            GamaProducto gamaNueva= new GamaProducto();

            gamaNueva.setDescripcionTexto(descripcionTexto);
            gamaNueva.setDescripcionHtml(descripcionHtml);
            gamaNueva.setImagen(imagen);
            gamaNueva.setGama(gama);

            gamaProductoDAO.guardarGamaProducto(gamaNueva);


        } catch (Exception e) {
            System.out.println(e.toString() + "No se guardo la Nueva GamaDeProductos de manera correcta");
        }
    }
}
