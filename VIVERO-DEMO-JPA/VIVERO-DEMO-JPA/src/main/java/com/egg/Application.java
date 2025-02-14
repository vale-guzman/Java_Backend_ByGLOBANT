package com.egg;

import com.egg.servicios.ClienteServicio;
import com.egg.servicios.GamaProductoServicio;
import com.egg.servicios.OficinaServicio;

public class Application {
    public static void main(String[] args) {
        /* Instanciar la clase OficinaServicio para acceder a sus métodos
        OficinaServicio oficinaServicio = new OficinaServicio();

        // Llamar al método del servicio para crear una nueva oficina
        oficinaServicio.crearOficna("OFI01", "Mendoza", "Argentina", "Cuyo", "11111111",
                "CP5000"); */

        // Instanciar la clase ClienteaServicio para acceder a sus métodos
       // ClienteServicio clienteServicio = new ClienteServicio();

        // Llamar al método del servicio para crear un nuevo Cliente
       // clienteServicio.crearCliente("Guzman", "Cordoba",100,"5000",11,
       //         "Fax123456",5000.00,"Valery","Monica","Argentina","0303456");

        // Instanciar la clase GamaProductoServicio para acceder a sus métodos
        GamaProductoServicio gamaProductoServicio=new GamaProductoServicio();

        // Llamar al método del servicio para crear una nueva Gama
        gamaProductoServicio.crearGama("Tester: Producto de Prueba para exhibición","none",null,"Test");
    }
}
