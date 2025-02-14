package com.egg.servicios;

import com.egg.entidades.Cliente;
import com.egg.entidades.Empleado;
import com.egg.persistencia.ClienteDAO;


public class ClienteServicio {
    private final ClienteDAO clienteDAO;// Instancio a la unidad de persistencia para acceder a los metodos del EM

    public ClienteServicio() {
        this.clienteDAO = new ClienteDAO();
    }

    public void crearCliente(String apellidoContacto, String ciudad, int codigoCliente, String codigoPostal, int idEmpleado,
                             String fax, double limiteCredito, String nombreCliente,
                             String nombreContacto, String pais, String telefono) {

        try {
            // Crear una nueva instancia de Cliente
            Cliente clienteNuevo= new Cliente();

            clienteNuevo.setCodCliente(codigoCliente);
            clienteNuevo.setNombreContacto(nombreContacto);
            clienteNuevo.setApellidoContacto(apellidoContacto);
            clienteNuevo.setTelefono(telefono);
            clienteNuevo.setFax(fax);
            clienteNuevo.setCiudad(ciudad);
            clienteNuevo.setPais(pais);
            clienteNuevo.setCp(codigoPostal);
            clienteNuevo.setIdEmpleado(idEmpleado);
            clienteNuevo.setLimiteCredito(limiteCredito);
            clienteNuevo.setNombreCliente(nombreCliente);

            clienteDAO.guardarCliente(clienteNuevo);

        } catch (Exception e) {
            System.out.println(e.toString() + "No se guardo el Nuevo Cliente de manera correcta");
        }
    }
}
